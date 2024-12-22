package com.unborn.urlshortener.dao;

import com.unborn.urlshortener.dto.URLBean;
import com.unborn.urlshortener.entity.URLEntity;
import com.unborn.urlshortener.utils.BEConverter;
import com.unborn.urlshortener.utils.URLShortener;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class URLDaoWrapper {
    @Autowired
    private URLDao urlDao;

    public URLBean getShortUrl(URLBean longUrlBean) {
        URLEntity longUrlEntity = BEConverter.convertBeanToEntity(longUrlBean);

        Long urlId = new Date().getTime();
        String shortUrl = URLShortener.convertIdToShortUrl(urlId);
        longUrlEntity.setId(urlId);
        longUrlEntity.setShortUrl(shortUrl);

        URLEntity shortUrlEntity = urlDao.save(longUrlEntity);
        return BEConverter.convertEntityToBean(shortUrlEntity);
    }
    public URLBean getLongUrl(String shortUrl, boolean alreadyVisited) {
        Long urlId = URLShortener.convertShortUrlToId(shortUrl);
        urlDao.incrementClickCount(urlId);
        if(!alreadyVisited) {
            urlDao.incrementUniqueClients(urlId);
        }
        URLEntity longUrlEntity = urlDao.findById(urlId);
        return BEConverter.convertEntityToBean(longUrlEntity);
    }
    public List<URLBean> getAllUrls() {
        List<URLEntity> urlEntityList = urlDao.findAll();
        List<URLBean> urlBeanList = new ArrayList<>();
        for (URLEntity urlEntity : urlEntityList) {
            urlBeanList.add(BEConverter.convertEntityToBean(urlEntity));
        }
        return urlBeanList;
    }
}
