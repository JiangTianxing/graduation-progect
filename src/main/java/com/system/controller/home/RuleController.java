package com.system.controller.home;

import com.system.core.util.Const;
import com.system.core.util.FormConst;
import com.system.core.util.SessionUtil;
import com.system.data.dto.Page;
import com.system.data.entity.Rule;
import com.system.data.entity.Website;
import com.system.data.service.RuleService;
import com.system.data.service.WebsiteService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by jx on 2017/4/26.
 */
@Controller("HomeRuleController")
@RequestMapping("/rule")
public class RuleController {

    private final String TEMPLATE = "home/rule/";

    @Resource
    private RuleService ruleService;
    @Resource
    private WebsiteService websiteService;

    @RequestMapping("/{pageId}")
    public String index(@PathVariable("pageId") Optional<Integer> pageId,
                        Model model) {
        int pageNum = (pageId.isPresent()) ? pageId.get() : 1;
        Website website = websiteService.find();
        Page<Rule> page = ruleService.getRulePage(pageNum, FormConst.STATUS.SAVE.getValue());
        model.addAttribute("page", page);
        model.addAttribute("web", website);
        model.addAttribute("type", "rule");
        return TEMPLATE + "index";
    }

    @RequestMapping({"/", "/download/{md5}"})
    public ResponseEntity<byte[]> download(@PathVariable("md5") Optional<String> md5,
                                           HttpServletRequest request) throws IOException {
        if (!SessionUtil.checkIfManager(request) && !SessionUtil.checkIfUser(request)) return null;
        if (!md5.isPresent()) return null;
        System.out.println(md5.get());
        Rule rule = ruleService.findByMd5(md5.get());
        String path = Const.ROOT_PATH + "/" + rule.getPath();
        System.out.println(path);
        String name = new String(rule.getFilename().getBytes("UTF-8"),"iso-8859-1");
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", name);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}