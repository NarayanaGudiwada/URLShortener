package com.unborn.urlshortener.service;

import com.unborn.urlshortener.dao.URLDaoWrapper;
import com.unborn.urlshortener.dto.URLBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URLServiceImpl implements URLService {
    @Autowired
    private URLDaoWrapper urlDaoWrapper;

    @Override
    public URLBean getShortUrl(URLBean longUrlBean) {
        return urlDaoWrapper.getShortUrl(longUrlBean);
    }

    @Override
    public URLBean getLongUrl(String shortUrl, boolean alreadyVisited) {
        return urlDaoWrapper.getLongUrl(shortUrl, alreadyVisited);
    }

    @Override
    public List<URLBean> getAllUrls() {
        return urlDaoWrapper.getAllUrls();
    }
}
