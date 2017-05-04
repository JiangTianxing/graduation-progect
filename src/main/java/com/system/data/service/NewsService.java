package com.system.data.service;

import com.system.core.util.FormConst;
import com.system.data.dao.NewsContentDao;
import com.system.data.dao.NewsDao;
import com.system.data.dto.Page;
import com.system.data.entity.News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jx on 2017/4/27.
 */
@Service("newsService")
public class NewsService {

    @Resource
    private NewsDao newsDao;

    @Resource
    private NewsContentDao newsContentDao;

    public boolean save(News news) {
        boolean step1 = newsContentDao.add(news);
        System.out.println("id ==== " + news.getId());
        boolean step2 = newsDao.add(news);
        return (step1 && step2);
    }

    public boolean update(News news) {
        boolean step1 = newsContentDao.update(news);
        boolean step2 = newsDao.update(news);
        return step1 && step2;
    }

    public Page<News> getNewsPage(int page, Integer status) {
        int newsCount = FormConst.RULE_PAGE.getValue();
        int start = (page - 1) * newsCount;
        int count = newsDao.count(status);
        int pageCount = (count % newsCount == 0) ? count/newsCount : count/newsCount + 1;
        List<News> news = newsDao.page(status, start, newsCount);
        Page<News> newsPage = new Page<>();
        newsPage.setCurrent(page);
        newsPage.setItems(news);
        newsPage.setSize(newsCount);
        newsPage.setTotal(pageCount);
        return newsPage;
    }

    public News find(Integer id, Integer status) {
        return newsDao.find(id, status);
    }

    public boolean delete(Integer id) {
        return newsDao.delete(id);
    }
}
