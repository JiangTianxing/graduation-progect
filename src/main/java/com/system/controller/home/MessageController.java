package com.system.controller.home;

import com.system.core.util.FormConst;
import com.system.data.dto.Page;
import com.system.data.entity.Comment;
import com.system.data.entity.Message;
import com.system.data.entity.Website;
import com.system.data.service.CommentService;
import com.system.data.service.MessageService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by jx on 2017/5/1.
 */
@Controller("HomeMessageController")
@RequestMapping("/message")
public class MessageController {

    private final String TEMPLATE = "home/message/";

    @Resource
    private MessageService messageService;
    @Resource
    private CommentService commentService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping("/{pageId}")
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        Integer id = pageId.isPresent() ? pageId.get() : 1;
        Page<Message> messagePage = messageService.getMessagePage(id, FormConst.STATUS.SAVE.getValue());
        Website website = websiteService.find();
        model.addAttribute("web", website);
        model.addAttribute("messages", messagePage);
        model.addAttribute("type", "message");
        return TEMPLATE + "index";
    }

    @RequestMapping("/detail/{messageId}")
    public String detail(@PathVariable("messageId") Optional<Integer> messageId,
                        Model model) {
        Integer id = messageId.isPresent() ? messageId.get() : 1;
        Message message = messageService.find(id, null);
        Website website = websiteService.find();
        List<Comment> comments = commentService.select(id);
        model.addAttribute("web", website);
        model.addAttribute("message", message);
        model.addAttribute("comments", comments);
        model.addAttribute("type", "message");
        return TEMPLATE + "detail";
    }
}
