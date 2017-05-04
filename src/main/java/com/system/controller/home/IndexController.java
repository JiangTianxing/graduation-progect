package com.system.controller.home;

import com.system.core.util.FormConst;
import com.system.data.dto.Page;
import com.system.data.entity.Website;
import com.system.data.service.MessageService;
import com.system.data.service.NewsService;
import com.system.data.service.RuleService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jx on 2017/4/23.
 */
@Controller("HomeIndexController")
public class IndexController {

    private final String TEMPLATE = "home/";

    @Resource
    private WebsiteService websiteService;
    @Resource
    private RuleService ruleService;
    @Resource
    private NewsService newsService;
    @Resource
    private MessageService messageService;
    @RequestMapping({"", "/"})
    public String index(HttpServletRequest request,
                        Model model) throws IOException {
        Page rulePage = ruleService.getRulePage(1, FormConst.STATUS.SAVE.getValue());
        Page newsPage = newsService.getNewsPage(1, FormConst.STATUS.SAVE.getValue());
        Page messagePage = messageService.getMessagePage(1, FormConst.STATUS.SAVE.getValue());
        Website website = websiteService.find();
        model.addAttribute("web", website);
        model.addAttribute("news", newsPage.getItems());
        model.addAttribute("message", messagePage.getItems());
        model.addAttribute("rules", rulePage.getItems());
        model.addAttribute("type", "index");
        return TEMPLATE + "index/index";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs(Model model) {
        Website website = websiteService.find();
        model.addAttribute("type","aboutUs");
        model.addAttribute("web", website);
        return TEMPLATE + "aboutUs/index";
    }

}