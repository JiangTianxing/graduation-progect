package com.system.controller.manage;

import com.system.core.annotation.Before;
import com.system.core.annotation.Clear;
import com.system.core.interceptor.ManagerLoginInterceptor;
import com.system.core.util.*;
import com.system.data.entity.*;
import com.system.data.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jx on 2017/4/24.
 */
@Controller("ManageIndexController")
@RequestMapping("/manage")
@Before(ManagerLoginInterceptor.class)
public class IndexController {

    private final String TEMPLATE = "manage/index/";

    @Resource
    private ManagerService managerService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("type", "index");
        return TEMPLATE + "index";
    }

    @Clear
    @RequestMapping("/login")
    public String login() {
        return "manage/login/index";
    }

    @Clear
    @ResponseBody
    @RequestMapping("/doLogin")
    public Result doLogin(@Valid Manager loginData,
                          Errors errors,
                          HttpServletRequest request) {
        if (errors.hasErrors())
            return Result.returnError(errors);
        Manager manager = managerService.findByEmail(loginData.getEmail());
        if (manager == null)
            return Result.returnJson(HttpStatus.ERROR, "用户不存在", null);
        String password = Md5Util.getMD5Code(loginData.getPassword());
        if (password.equals(manager.getPassword())) {
            if (SessionUtil.checkIfUser(request)) SessionUtil.clearAttr(request, Const.USER);
            SessionUtil.setAttr(request, Const.MANAGER, manager);
            String directUrl = Const.PROJECT_PATH + "/manage/";
            Map<String, Object> data = new HashMap<>();
            data.put("url", directUrl);
            return Result.returnJson(HttpStatus.SUCCESS, "登录成功", data);
        }
        return Result.returnJson(HttpStatus.ERROR, "密码错误", null);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        SessionUtil.clearAttr(request, Const.MANAGER);
        response.sendRedirect(Const.PROJECT_PATH);
    }
}