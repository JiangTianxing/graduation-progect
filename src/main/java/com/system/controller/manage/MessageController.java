package com.system.controller.manage;

import com.system.core.annotation.Before;
import com.system.core.interceptor.ManagerLoginInterceptor;
import com.system.core.util.FormConst;
import com.system.data.dto.Page;
import com.system.data.entity.Message;
import com.system.data.entity.Rule;
import com.system.data.entity.Website;
import com.system.data.service.MessageService;
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
 * Created by jx on 2017/5/1.
 */
@Controller("ManageMessageController")
@RequestMapping("/manage/message")
@Before(ManagerLoginInterceptor.class)
public class MessageController {
    private final String TEMPLATE = "manage/message/";

    @Resource
    private MessageService messageService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping({"/", "/{pageId}"})
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        Integer id = pageId.isPresent() ? pageId.get() : 1;
        Page<Message> message = messageService.getMessagePage(id, null);
        Website website = websiteService.find();
        model.addAttribute("web", website);
        model.addAttribute("type", "message");
        model.addAttribute("page", message);
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
        Message message = messageService.find(id.get(), null);
        if (message == null)
            return null;
        int status = message.getStatus() == FormConst.STATUS.DELETE.getValue() ? FormConst.STATUS.SAVE.getValue() : FormConst.STATUS.DELETE.getValue();
        message.setStatus(status);
        messageService.update(message);
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
        messageService.delete(id.get());
        return "redirect:" + refer;
    }
}
