package com.system.data.dao;

import com.system.data.entity.Rule;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * Created by jx on 2017/4/26.
 */
public interface RuleDao extends BaseDao<Rule>{
    int count(@Param("status") Integer status);

    List<Rule> page(@Param("status") Integer status, @Param("start") int start, @Param("offset") int offset);

    Rule findByMd5(@Param("md5") String md5, @Param("status") Integer status);

    Rule find(@Param("id") Integer id, @Param("status") Integer status);

    boolean delete(@Param("id") Integer id);
}