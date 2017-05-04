package com.system.controller.manage;

import com.system.core.util.FormConst;
import com.system.data.dto.Page;
import com.system.data.entity.User;
import com.system.data.entity.Website;
import com.system.data.service.UserService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by jx on 2017/4/28.
 */
@Controller("ManageUserController")
@RequestMapping("/manage/user")
public class UserController {

    private final String TEMPLATE = "manage/user/";

    @Resource
    private UserService userService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping({"/", "/{pageId}"})
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        Integer id = pageId.isPresent() ? pageId.get() : 1;
        Website website = websiteService.find();
        Page<User> page = userService.getUserPage(id, null);
        model.addAttribute("page", page);
        model.addAttribute("type", "user");
        model.addAttribute("web", website);
        return TEMPLATE + "index";
    }

    /**
     * 状态更换
     */
    @RequestMapping(value = {"/change/", "/change/{id}"}, method = RequestMethod.GET)
    public String change(@PathVariable("id") Optional<Integer> id,
                         @RequestHeader("Referer") String refer) {
        if (!id.isPresent())
            return null;
        User user = userService.find(id.get(), null);
        if (user == null)
            return null;
        int status = (user.getStatus() != FormConst.STATUS.SAVE.getValue() ? FormConst.STATUS.SAVE.getValue() : FormConst.STATUS.DELETE.getValue());
        user.setStatus(status);
        userService.update(user);
        return "redirect:" + refer;
    }

    /**
     * 状态更换
     */
    @RequestMapping(value = {"/delete/", "/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable("id") Optional<Integer> id,
                         @RequestHeader("Referer") String refer) {
        if (!id.isPresent())
            return null;
        userService.delete(id.get());
        return "redirect:" + refer;
    }
}