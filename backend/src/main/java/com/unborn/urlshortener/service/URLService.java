package com.unborn.urlshortener.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class URLService {
    public ResponseEntity<String> shortenURL(String url) {
        return ResponseEntity.status(HttpStatus.OK).body("test");
    }
}
