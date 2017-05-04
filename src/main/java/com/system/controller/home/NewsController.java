package com.system.controller.home;

import com.system.core.util.FormConst;
import com.system.core.util.HttpStatus;
import com.system.data.dto.Page;
import com.system.data.entity.Comment;
import com.system.data.entity.News;
import com.system.data.entity.Website;
import com.system.data.service.CommentService;
import com.system.data.service.NewsService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


/**
 * Created by jx on 2017/4/27.
 */
@Controller("HomeNewsController")
@RequestMapping("/news")
public class NewsController {

    private final String TEMPLATE = "home/news/";
    @Resource
    private NewsService newsService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping(value = {"/", "/{pageNum}"} , method = RequestMethod.GET)
    public String index(@PathParam(value = "pageNum") Optional<Integer> pageNum,
                        Model model) {
        Integer id = pageNum.isPresent() ? pageNum.get() : 1;
        Page<News> newsPage = newsService.getNewsPage(id, FormConst.STATUS.SAVE.getValue());
        Website website = websiteService.find();
        model.addAttribute("web", website);
        model.addAttribute("news", newsPage);
        model.addAttribute("type", "news");
        return TEMPLATE + "index";
    }

    @RequestMapping(value = "/detail/{newsId}", method = RequestMethod.GET)
    public String detail(@PathVariable("newsId") Optional<Integer> newsId,
                        Model model) {
        Integer id = (newsId.isPresent() ? newsId.get() : 1);
        News news = newsService.find(id, null);
        Website website = websiteService.find();
        model.addAttribute("news", news);
        model.addAttribute("type", "news");
        model.addAttribute("web", website);
        return TEMPLATE + "detail";
    }

}