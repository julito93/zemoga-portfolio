package com.jcampaz.portfolio.portfolio.service;


import com.jcampaz.portfolio.portfolio.utils.TwitterOauthHeaderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public abstract class TwitterBaseService {

    @Autowired
    @Qualifier("twitterRestTemplate")
    protected RestTemplate restTemplate;

    @Autowired
    protected TwitterOauthHeaderGenerator generator;
}
