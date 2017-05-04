package com.system.data.dao;

import com.system.data.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jx on 2017/5/1.
 */
public interface CommentDao {
    List<Comment> select(@Param("messageId") Integer id);

    boolean add(@Param("data") Comment data);
}
