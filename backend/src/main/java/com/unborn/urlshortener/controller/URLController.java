package com.unborn.urlshortener.controller;

import com.unborn.urlshortener.dto.URLBean;
import com.unborn.urlshortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @RequestMapping(
            value = "generate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<URLBean> getShortUrl(@RequestBody URLBean longUrlBean) {
        URLBean shortUrlBean = urlService.getShortUrl(longUrlBean);
        String shortUrl = "http://localhost:8080/" + shortUrlBean.getShortUrl();

        URLBean responseUrlBean = new URLBean();
        responseUrlBean.setShortUrl(shortUrl);
        return new ResponseEntity<>(responseUrlBean, HttpStatus.OK);
    }

    @RequestMapping(
            value = "{shortUrl}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Object> redirectToLongUrl(@PathVariable String shortUrl, @CookieValue(name = "visited-urls", defaultValue = "") String visitedUrls ) throws URISyntaxException {
        // Check if the short URL is already in the visited URLs
        //TODO: modify this logic later as it will cookie value (cookie max size)
        // may be create user-id and maintain visited URLs in DB
        boolean alreadyVisited = visitedUrls.contains(shortUrl);
        System.out.println("Visited URLs: " + visitedUrls);
        URLBean longUrlBean = urlService.getLongUrl(shortUrl, alreadyVisited);
        URI longUrl = new URI(longUrlBean.getLongUrl());

        String updatedVisitedUrls = alreadyVisited ? visitedUrls : visitedUrls + (visitedUrls.isEmpty() ? "" : "|") + shortUrl;
        ResponseCookie springCookie = ResponseCookie.from("visited-urls", updatedVisitedUrls) //have to replace with  some meaningful Id
                .httpOnly(true)
                .path("/")
                .build();



        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Set-Cookie", springCookie.toString());
        httpHeaders.setLocation(longUrl);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @RequestMapping(
            value = "getall",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<URLBean>> getAllUrls() {
        List<URLBean> urlBeanList = urlService.getAllUrls();
        return new ResponseEntity<>(urlBeanList, HttpStatus.OK);
    }
}
