package com.system.data.dao;

import com.system.data.entity.News;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by jx on 2017/4/27.
 */
public interface NewsDao extends BaseDao<News>{

    List<News> page(@Param("status") Integer status, @Param("start") int start, @Param("offset") int offset);

    Integer count(@Param("status") Integer status);

    News find(@Param("id") Integer id, @Param("status") Integer status);

    boolean delete(@Param("id") Integer id);

}
