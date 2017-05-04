package com.system.controller.manage;

import com.system.core.annotation.Before;
import com.system.core.interceptor.ManagerLoginInterceptor;
import com.system.core.util.Const;
import com.system.core.util.HttpStatus;
import com.system.data.entity.Result;
import com.system.data.entity.Website;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jx on 2017/4/26.
 */
@Controller("ManageAboutUsController")
@RequestMapping("/manage/aboutUs")
@Before(ManagerLoginInterceptor.class)
public class AboutUsController {
    private final String TEMPLATE = "manage/aboutUs/";

    @Resource
    private WebsiteService websiteService;

    @RequestMapping("")
    public String aboutUs(Model model) {
        Website website = websiteService.find();
        model.addAttribute("type", "aboutUs");
        model.addAttribute("web", website);
        return TEMPLATE + "index";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateAboutUs(@Valid Website website,
                                Errors errors) {
        if (errors.hasErrors())
            return Result.returnError(errors);
        websiteService.update(website);
        String redirectUrl = Const.PROJECT_PATH + "/manage/aboutUs";
        Map<String, Object> data = new HashMap<>();
        data.put("url", redirectUrl);
        return Result.returnJson(HttpStatus.SUCCESS, "更改成功", data);
    }
}