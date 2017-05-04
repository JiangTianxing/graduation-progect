package com.system.data.service;

import com.system.core.util.FormConst;
import com.system.data.dao.MessageContentDao;
import com.system.data.dao.MessageDao;
import com.system.data.dto.Page;
import com.system.data.entity.Message;
import com.system.data.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jx on 2017/4/30.
 */
@Service
public class MessageService {
    @Resource
    private MessageDao messageDao;

    @Resource
    private MessageContentDao messageContentDao;

    public boolean save(Message message) {
        boolean step1 = messageContentDao.add(message);
        System.out.println("id ==== " + message.getId());
        boolean step2 = messageDao.add(message);
        return (step1 && step2);
    }

    public boolean update(Message message) {
        boolean step1 = messageContentDao.update(message);
        boolean step2 = messageDao.update(message);
        return step1 && step2;
    }

    public Page<Message> getMessagePage(int page, Integer status) {
        int messageCount = FormConst.RULE_PAGE.getValue();
        int start = (page - 1) * messageCount;
        int count = messageDao.count(status, null);
        int pageCount = (count % messageCount == 0) ? count/messageCount : count/messageCount + 1;
        List<Message> message = messageDao.page(status, start, messageCount);
        Page<Message> messagePage = new Page<>();
        messagePage.setCurrent(page);
        messagePage.setItems(message);
        messagePage.setSize(messageCount);
        messagePage.setTotal(pageCount);
        return messagePage;
    }

    public Page<Message> getMessagePage(Integer userId, int page, Integer status) {
        int messageCount = FormConst.RULE_PAGE.getValue();
        int start = (page - 1) * messageCount;
        int count = messageDao.count(status, userId);
        int pageCount = (count % messageCount == 0) ? count/messageCount : count/messageCount + 1;
        List<Message> message = messageDao.pageByUserId(userId, status, start, messageCount);
        Page<Message> messagePage = new Page<>();
        messagePage.setCurrent(page);
        messagePage.setItems(message);
        messagePage.setSize(messageCount);
        messagePage.setTotal(pageCount);
        return messagePage;
    }

    public Message find(Integer id, Integer status) {
        return messageDao.find(id, status);
    }

    public boolean delete(Integer id) {
        return messageDao.delete(id);
    }

}
