package com.unborn.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ShortURLRequest {
    private String ShortURL;

    public String getURL() {
        return ShortURL;
    }
}