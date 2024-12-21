package com.unborn.urlshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

//    @RequestMapping(value = "sayHello", method = RequestMethod.GET)
    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello() {
        String name = "Subbu";
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }
}
