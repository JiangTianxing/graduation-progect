package com.system.controller.admin;

import com.system.core.annotation.Before;
import com.system.core.interceptor.UserLoginInterceptor;
import com.system.core.util.Const;
import com.system.core.util.FormConst;
import com.system.core.util.HttpStatus;
import com.system.core.util.SessionUtil;
import com.system.data.entity.Result;
import com.system.data.entity.User;
import com.system.data.entity.UserRegisterData;
import com.system.data.entity.Website;
import com.system.data.service.UserService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jx on 2017/5/1.
 */
@Controller("AdminUserController")
@RequestMapping("/admin/user")
@Before(UserLoginInterceptor.class)
public class UserController {

    private final String TEMPLATE = "admin/user/";

    @Resource
    private UserService userService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping("/")
    public String index(Model model,
                        HttpServletRequest request) {
        User user = SessionUtil.getUser(request);
        Website website = websiteService.find();
        model.addAttribute("type", "user");
        model.addAttribute("user", user);
        model.addAttribute("web", website);
        return TEMPLATE + "index";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result doUpdate(@Valid UserRegisterData user,
                           Errors errors) {
        if (errors.hasErrors()) return Result.returnError(errors);
        if (!user.checkPasswordIfSame()) return Result.returnJson(HttpStatus.ERROR, "两次密码不一致", null);
        User updateUser = user.getUser();
        updateUser.setStatus(FormConst.STATUS.SAVE.getValue());
        userService.update(user.getUser());
        Map<String, Object> data = new HashMap<>();
        String url = Const.PROJECT_PATH + "/admin/user/";
        data.put("url", url);
        return Result.returnJson(HttpStatus.SUCCESS, "更新成功", data);
    }
}
