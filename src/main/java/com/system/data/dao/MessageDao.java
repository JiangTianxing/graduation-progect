package com.system.data.dao;

import com.system.data.entity.Message;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by jx on 2017/4/30.
 */
public interface MessageDao extends BaseDao<Message>{

    List<Message> page(@Param("status") Integer status, @Param("start") int start, @Param("offset") int offset);

    List<Message> pageByUserId(@Param("userId") Integer userId, @Param("status") Integer status, @Param("start") int start, @Param("offset") int offset);

    Message find(@Param("id") Integer id, @Param("status") Integer status);

    boolean delete(@Param("id") Integer id);

    Integer count(@Param("status") Integer status, @Param("userId") Integer userId);
}
