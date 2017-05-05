package com.system.controller.manage;

import com.system.core.annotation.Before;
import com.system.core.annotation.Clear;
import com.system.core.exception.ResultException;
import com.system.core.interceptor.ManagerLoginInterceptor;
import com.system.core.util.*;
import com.system.data.dto.Page;
import com.system.data.entity.Result;
import com.system.data.entity.Rule;
import com.system.data.entity.Website;
import com.system.data.service.RuleService;
import com.system.data.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

/**
 * Created by jx on 2017/4/26.
 */
@Controller("ManageRuleController")
@RequestMapping("/manage/rule")
@Before(ManagerLoginInterceptor.class)
public class RuleController {

    private final String TEMPLATE = "manage/rule/";

    @Resource
    private WebsiteService websiteService;

    @Resource
    private RuleService ruleService;

    /**
     * 分页显示
     */
    @RequestMapping({"/", "/{pageId}"})
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        int pageNum = pageId.isPresent() ? pageId.get() : 1;
        Page<Rule> page = ruleService.getRulePage(pageNum, null);
        Website website = websiteService.find();
        model.addAttribute("type", "rule");
        model.addAttribute("web", website);
        model.addAttribute("page", page);
        return TEMPLATE + "index";
    }

    /**
     * 处理添加
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result doSave(@RequestParam(value = "file", required = false)CommonsMultipartFile file,
                         @Valid Rule rule) throws IOException {
        if (file == null || file.getBytes().length == 0)
            return Result.returnJson(HttpStatus.ERROR, "文件未上传", null);
        try {
            long timestamp = System.currentTimeMillis();
            String filename = file.getOriginalFilename();
            String path = FileUtil.uploadFile(file);
            String md5 = Md5Util.getMD5Code(path + timestamp + "uploadfile");
            rule.setTitle(StringUtil.cleanXSS(rule.getTitle()));
            rule.setDescription(StringUtil.cleanXSS(rule.getDescription()));
            rule.setFilename(filename);
            rule.setPath(path);
            rule.setMd5(md5);
            rule.setStatus(FormConst.STATUS.SAVE.getValue());
            ruleService.add(rule);
            String url = Const.PROJECT_PATH + "/manage/rule/";
            Map<String, Object> data = new HashMap<>();
            data.put("url", url);
            return Result.returnJson(HttpStatus.SUCCESS, "提交成功", data);
        } catch (ResultException e) {
            return Result.returnException(e);
        }
    }

    /**
     * 处理更新
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result doUpdate(@RequestHeader("Referer") String refer,
                           @RequestParam(value = "file", required = false)CommonsMultipartFile file,
                           @Valid Rule rule,
                           Errors errors) {
        if (errors.hasErrors()) {
            return Result.returnError(errors);
        }
        try {
            if (file != null && file.getBytes().length > 0) {
                long timestamp = System.currentTimeMillis();
                String filename = file.getOriginalFilename();
                String path = FileUtil.uploadFile(file);
                String md5 = Md5Util.getMD5Code(path + timestamp + "uploadfile");
                rule.setFilename(filename);
                rule.setPath(path);
                rule.setMd5(md5);
            }
            rule.setTitle(StringUtil.cleanXSS(rule.getTitle()));
            rule.setDescription(StringUtil.cleanXSS(rule.getDescription()));
            ruleService.update(rule);
            Map<String, Object> data = new HashMap<>();
            data.put("url", refer);
            return Result.returnJson(HttpStatus.SUCCESS, "更新成功", data);
        } catch (ResultException e) {
            return Result.returnException(e);
        }
    }

    /**
     * 状态更换
     */
    @RequestMapping(value = {"/change/", "/change/{id}"}, method = RequestMethod.GET)
    public String change(@PathVariable("id") Optional<Integer> id,
                         @RequestHeader("Referer") String refer) {
        if (!id.isPresent())
            return null;
        Rule rule = ruleService.find(id.get(), null);
        if (rule == null)
            return null;
        int status = rule.getStatus() == FormConst.STATUS.DELETE.getValue() ? FormConst.STATUS.SAVE.getValue() : FormConst.STATUS.DELETE.getValue();
        rule.setStatus(status);
        ruleService.update(rule);
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
        ruleService.delete(id.get());
        return "redirect:" + refer;
    }


}