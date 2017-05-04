package com.system.data.service;

import com.system.data.dao.WebsiteDao;
import com.system.data.entity.Website;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jx on 2017/4/25.
 */
@Service
public class WebsiteService{
    @Resource
    private WebsiteDao websiteDao;

    public Website find() {
        return websiteDao.find();
    }

    public boolean update(Website website) {
        return websiteDao.update(website);
    }
}
