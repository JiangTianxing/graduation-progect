package com.system.data.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by jx on 2017/4/26.
 */
public interface BaseDao<T> {
    boolean add(@Param("data") T data);

    boolean update(@Param("data") T data);
}