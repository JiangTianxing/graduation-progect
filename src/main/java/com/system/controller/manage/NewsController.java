package com.system.controller.manage;

import com.system.core.util.Const;
import com.system.core.util.FormConst;
import com.system.core.util.HttpStatus;
import com.system.data.dto.Page;
import com.system.data.entity.News;
import com.system.data.entity.Result;
import com.system.data.entity.Website;
import com.system.data.service.NewsService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by jx on 2017/4/30.
 */
@Controller("AdminNewsController")
@RequestMapping("/manage/news")
public class NewsController {

    private final String TEMPLATE = "manage/news/";

    @Resource
    private NewsService newsService;

    @Resource
    private WebsiteService websiteService;

    @RequestMapping({"/", "/{pageId}"})
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        Integer id = pageId.isPresent() ? pageId.get() : 1;
        Page<News> news = newsService.getNewsPage(id, null);
        Website website = websiteService.find();
        model.addAttribute("web", website);
        model.addAttribute("type", "news");
        model.addAttribute("page", news);
        return TEMPLATE + "index";
    }

    /**
     * 处理添加
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result doSave(@Valid News news,
                         Errors errors) {
        if (errors.hasErrors()) return Result.returnError(errors);
        newsService.save(news);
        String url = Const.PROJECT_PATH + "/manage/news/";
        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return Result.returnJson(HttpStatus.SUCCESS, "保存成功", data);
    }

    @RequestMapping("/update/{newsId}")
    public String update(@PathVariable("newsId") Optional<Integer> newsId,
                         Model model) {
        Integer id = newsId.isPresent() ? newsId.get() : 1;
        News news = newsService.find(id, null);
        Website website = websiteService.find();
        model.addAttribute("news", news);
        model.addAttribute("web", website);
        model.addAttribute("type", "news");
        return TEMPLATE + "update";
    }
    /**
     * 处理更新
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result doUpdate(@Valid News news,
                           Errors errors) {
        if (errors.hasErrors()) {
            return Result.returnError(errors);
        }
        int contentId = newsService.find(news.getId(), null).getContentId();
        news.setContentId(contentId);
        newsService.update(news);
        Map<String, Object> data = new HashMap<>();
        String url = Const.PROJECT_PATH + "/manage/news/1";
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
        News news = newsService.find(id.get(), null);
        if (news == null)
            return null;
        int status = news.getStatus() == FormConst.STATUS.DELETE.getValue() ? FormConst.STATUS.SAVE.getValue() : FormConst.STATUS.DELETE.getValue();
        news.setStatus(status);
        newsService.update(news);
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
        newsService.delete(id.get());
        return "redirect:" + refer;
    }

}