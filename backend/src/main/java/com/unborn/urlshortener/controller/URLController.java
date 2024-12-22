package com.unborn.urlshortener.controller;

import com.unborn.urlshortener.dto.ShortURLRequest;
import com.unborn.urlshortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class URLController {

    @Autowired
    URLService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenURL(@RequestBody ShortURLRequest shortURLRequest) {
        return urlService.shortenURL(shortURLRequest.getURL());
    }
}
