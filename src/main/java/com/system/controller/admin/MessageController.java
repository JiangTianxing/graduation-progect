package com.system.controller.admin;

import com.system.core.annotation.Before;
import com.system.core.interceptor.UserLoginInterceptor;
import com.system.core.util.Const;
import com.system.core.util.FormConst;
import com.system.core.util.HttpStatus;
import com.system.core.util.SessionUtil;
import com.system.data.dto.Page;
import com.system.data.entity.*;
import com.system.data.service.CommentService;
import com.system.data.service.MessageService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jx on 2017/4/30.
 */
@Controller("AdminMessageController")
@RequestMapping("/admin/message")
@Before(UserLoginInterceptor.class)
public class MessageController {

    private final String TEMPLATE = "admin/message/";

    @Resource
    HttpServletRequest request;
    @Resource
    CommentService commentService;
    @Resource
    private WebsiteService websiteService;
    @Resource
    private MessageService messageService;

    @RequestMapping({"/", "/{pageId}"})
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        Integer id = pageId.isPresent() ? pageId.get() : 1;
        User user = SessionUtil.getUser(request);
        Page<Message> message = messageService.getMessagePage(user.getId(), id, null);
        Website website = websiteService.find();
        model.addAttribute("web", website);
        model.addAttribute("type", "message");
        model.addAttribute("page", message);
        return TEMPLATE + "index";
    }

    /**
     * 处理添加
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result doSave(@Valid Message message,
                         Errors errors,
                         HttpServletRequest request) {
        if (errors.hasErrors()) return Result.returnError(errors);
        User user = SessionUtil.getUser(request);
        message.setUserId(user.getId());
        message.setName(user.getName());
        message.setEmail(user.getEmail());
        messageService.save(message);
        String url = Const.PROJECT_PATH + "/admin/message/";
        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return Result.returnJson(HttpStatus.SUCCESS, "保存成功", data);
    }

    @RequestMapping(value = "/update/{messageId}", method = RequestMethod.GET)
    public String update(@PathVariable("messageId") Optional<Integer> messageId,
                         Model model) {
        Website website = websiteService.find();
        Integer id = messageId.isPresent() ? messageId.get() : null;
        Message message = messageService.find(id, null);
        model.addAttribute("web", website);
        model.addAttribute("message", message);
        model.addAttribute("type", "message");
        return TEMPLATE + "update";
    }

    /**
     * 处理更新
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result doUpdate(@Valid Message message,
                           Errors errors) {
        if (errors.hasErrors()) {
            return Result.returnError(errors);
        }
        User user = SessionUtil.getUser(request);
        message.setUserId(user.getId());
        messageService.update(message);
        Map<String, Object> data = new HashMap<>();
        String url = Const.PROJECT_PATH + "/admin/message/";
        data.put("url", url);
        return Result.returnJson(HttpStatus.SUCCESS, "更新成功", data);
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

    @ResponseBody
    @RequestMapping(value = "/comment/{messageId}", method = RequestMethod.POST)
    public Result comment(@PathVariable("messageId") Optional<Integer> messageId,
                          @Valid Comment comment,
                          Errors errors) {
        if (errors.hasErrors()) return Result.returnError(errors);
        Integer id = messageId.isPresent() ? messageId.get() : 1;
        comment.setMessageId(id);
        commentService.add(comment);
        comment.setSavetime(new Date());
        Map<String, Object> data = new HashMap<>();
        data.put("data", comment);
        return Result.returnJson(HttpStatus.SUCCESS, "评论成功", data);
    }

    @ResponseBody
    @RequestMapping(value = "/comment/delete/{commentId}")
    public Result deleteComment(@PathVariable("commentId") Optional<Integer> commentId) {
        if (commentId.isPresent()) {
            commentService.delete(commentId.get());
            return Result.returnJson(HttpStatus.SUCCESS, "删除成功", null);
        }
        return Result.returnJson(HttpStatus.ERROR, "评论不存在", null);
    }
}