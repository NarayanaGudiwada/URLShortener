package com.unborn.urlshortener.service;

import com.unborn.urlshortener.dto.URLBean;

import java.util.List;

public interface URLService {

    public URLBean getShortUrl(URLBean longUrlBean);
    public URLBean getLongUrl(String shortUrl);
    public List<URLBean> getAllUrls();
}