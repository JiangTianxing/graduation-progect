package com.system.data.service;

import com.system.data.dao.ManagerDao;
import com.system.data.entity.Manager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jx on 2017/4/24.
 */
@Service
public class ManagerService{

    @Resource
    private ManagerDao managerDao;

    public Manager findByEmail(String email) {
        return managerDao.findByEmail(email);
    }
}
