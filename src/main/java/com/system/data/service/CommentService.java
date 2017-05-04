package com.system.data.service;

import com.system.data.dao.CommentDao;
import com.system.data.entity.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by jx on 2017/5/1.
 */
@Service
public class CommentService {

    @Resource
    private CommentDao commentDao;

    public List<Comment> select(Integer messageId) {
        List<Comment> list = commentDao.select(messageId);
        Map<Integer, List<Comment>> result = new HashMap<>();
        for (Comment l : list) {
            List<Comment> level = result.get(l.getPid());
            if (level == null) {
                level = new ArrayList<>();
                result.put(l.getPid(), level);
            }
            level.add(l);
        }
        Set<Integer> keys = result.keySet();
        if (keys != null && keys.size() > 0) {
            for (Integer key : keys) {
                List<Comment> lists = result.get(key);
                for (Comment comment : lists) {
                    List<Comment> reply = result.get(comment.getId());
                    if (reply != null && reply.size()>0)
                        comment.setReply(reply);
                }
            }
        }
        return result.get(0);
    }

    public boolean add(Comment data) {
        return commentDao.add(data);
    }


}
