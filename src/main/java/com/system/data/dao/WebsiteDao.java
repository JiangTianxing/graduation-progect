package com.system.data.dao;

import com.system.data.entity.Website;
import org.apache.ibatis.annotations.Param;
/**
 * Created by jx on 2017/4/25.
 */
public interface WebsiteDao {
    Website find();

    boolean update(@Param("website") Website website);
}
