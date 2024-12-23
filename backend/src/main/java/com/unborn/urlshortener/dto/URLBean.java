package com.unborn.urlshortener.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class URLBean {

    private Long id;
    private String title;
    private String shortUrl;
    private String longUrl;
    private Integer noOfClicks = 0;
    private Integer noOfUniqueClients = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Integer getNoOfClicks() {
        return noOfClicks;
    }

    public void setNoOfClicks(Integer noOfClicks) {
        this.noOfClicks = noOfClicks;
    }

    public Integer getNoOfUniqueClients() {
        return noOfUniqueClients;
    }

    public void setNoOfUniqueClients(Integer noOfUniqueClients) {
        this.noOfUniqueClients = noOfUniqueClients;
    }
}
