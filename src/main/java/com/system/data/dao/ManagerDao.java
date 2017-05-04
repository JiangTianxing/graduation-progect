package com.system.data.dao;

import com.system.data.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jx on 2017/4/24.
 */
public interface ManagerDao {
    Manager findByEmail(@Param("email") String email);
}
