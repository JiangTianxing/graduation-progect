package com.system.controller.admin;

import com.system.core.annotation.Before;
import com.system.core.interceptor.UserLoginInterceptor;
import com.system.core.util.*;
import com.system.data.entity.Result;
import com.system.data.entity.User;
import com.system.data.entity.UserRegisterData;
import com.system.data.entity.Website;
import com.system.data.service.UserService;
import com.system.data.service.WebsiteService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Controller("AdminIndexController")
@RequestMapping("/admin")
public class IndexController {

    private final String TEMPLATE = "admin/index/";
    @Resource
    private UserService userService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping({"", "/"})
    @Before(UserLoginInterceptor.class)
    public String index(Model model) {
        Website website = websiteService.find();
        model.addAttribute("type", "index");
        model.addAttribute("web", website);
        return TEMPLATE + "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "admin/login/index";
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public Result doLogin(HttpServletRequest request,
                          @Valid User loginData,
                          Errors result) {
        if (result.hasErrors())
            return Result.returnError(result);
        User user = userService.findByEmail(loginData.getEmail());
        if (user == null)
            return Result.returnJson(HttpStatus.ERROR, "用户不存在", null);
        String password = Md5Util.getMD5Code(loginData.getPassword());
        if (!password.equals(user.getPassword()))
            return Result.returnJson(HttpStatus.ERROR, "密码错误", null);
        if (user.getStatus() != FormConst.STATUS.SAVE.getValue())
            return Result.returnJson(HttpStatus.ERROR, "管理员尚未审核，请稍后再试", null);
        SessionUtil.setAttr(request, Const.USER, user);
        if (SessionUtil.checkIfManager(request)) SessionUtil.clearAttr(request, Const.MANAGER);
        String redirectUrl = Const.PROJECT_PATH + "/admin/";
        Map<String, Object> data = new HashedMap();
        data.put("url", redirectUrl);
        return Result.returnJson(HttpStatus.SUCCESS, "登录成功", data);
    }

    @ResponseBody
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public Result doRegister(HttpServletRequest request,
                             @Valid UserRegisterData registerData,
                             Errors result) {
        if (result.hasErrors())
            return Result.returnError(result);
        if (!registerData.checkPasswordIfSame())
            return Result.returnJson(HttpStatus.ERROR, "两次密码不一致", null);
        String password = Md5Util.getMD5Code(registerData.getPassword());
        User user = registerData.getUser();
        User checkUser = userService.findByEmail(user.getEmail());
        if (checkUser != null) return Result.returnJson(HttpStatus.ERROR, "该邮箱已注册", null);
        user.setPassword(password);
        userService.add(user);
        SessionUtil.setAttr(request, Const.USER, user);
        String redirectUrl = Const.PROJECT_PATH + "/";
        Map<String, Object> data = new HashMap<>();
        data.put("url", redirectUrl);
        return Result.returnJson(HttpStatus.SUCCESS, "注册成功，请等待管理员审核", data);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        SessionUtil.clearAttr(request, Const.USER);
        String redirectUrl = Const.PROJECT_PATH;
        response.sendRedirect(redirectUrl);
    }
}