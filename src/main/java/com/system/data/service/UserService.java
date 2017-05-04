package com.system.data.service;

import com.system.core.util.FormConst;
import com.system.data.dao.UserDao;
import com.system.data.dto.Page;
import com.system.data.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jx on 2017/4/24.
 */
@Service
public class UserService{
    @Resource
    private UserDao userDao;

    public User findStudentById(Integer id) {
        return userDao.find(id);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public boolean add(User user) {
        return userDao.add(user);
    }

    public Page<User> getUserPage(int page, Integer status) {
        int ruleCount = FormConst.RULE_PAGE.getValue();
        int start = (page - 1) * ruleCount;
        int count = userDao.count(status);
        int pageCount = (count % ruleCount == 0) ? count/ruleCount : count/ruleCount + 1;
        List<User> rules = userDao.page(status, start, ruleCount);
        Page<User> rulePage = new Page<>();
        rulePage.setCurrent(page);
        rulePage.setItems(rules);
        rulePage.setSize(ruleCount);
        rulePage.setTotal(pageCount);
        return rulePage;
    }

    public User find(Integer id, Integer status) {
        return userDao.find(id, status);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean delete(Integer id) {
        return userDao.delete(id);
    }
}
