package com.system.data.dao;

import com.system.data.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jx on 2017/4/24.
 */
public interface UserDao extends BaseDao<User>{
    User find(@Param("id") Integer id);

    User findByEmail(@Param("email") String email);

    List<User> page(@Param("status") Integer status, @Param("start") int start, @Param("offset") int offset);

    int count(@Param("status") Integer status);

    User find(@Param("id") Integer id, @Param("status") Integer status);

    boolean delete(@Param("id") Integer id);
}