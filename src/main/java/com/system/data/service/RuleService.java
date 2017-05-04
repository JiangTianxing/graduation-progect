package com.system.data.service;

import com.system.core.util.FormConst;
import com.system.data.dao.RuleDao;
import com.system.data.dto.Page;
import com.system.data.entity.Rule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jx on 2017/4/26.
 */
@Service("ruleService")
public class RuleService {

    @Resource
    private RuleDao ruleDao;

    public boolean add(Rule rule) {
        return ruleDao.add(rule);
    }

    public Rule findByMd5(String md5) {
        return ruleDao.findByMd5(md5, FormConst.STATUS.SAVE.getValue());
    }

    public Page<Rule> getRulePage(int page, Integer status) {
        int ruleCount = FormConst.RULE_PAGE.getValue();
        int start = (page - 1) * ruleCount;
        int count = ruleDao.count(status);
        int pageCount = (count % ruleCount == 0) ? count/ruleCount : count/ruleCount + 1;
        List<Rule> rules = ruleDao.page(status, start, ruleCount);
        Page<Rule> rulePage = new Page<>();
        rulePage.setCurrent(page);
        rulePage.setItems(rules);
        rulePage.setSize(ruleCount);
        rulePage.setTotal(pageCount);
        return rulePage;
    }

    public Rule find(Integer id, Integer status) {
        return ruleDao.find(id, status);
    }

    public boolean update(Rule rule) {
        return ruleDao.update(rule);
    }

    public boolean delete(Integer id) {
        return ruleDao.delete(id);
    }
}
