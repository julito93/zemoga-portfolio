package com.jcampaz.portfolio.portfolio;

import com.jcampaz.portfolio.portfolio.controller.TwitterErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PortfolioApplication {

    @Bean("twitterRestTemplate")
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().errorHandler(new TwitterErrorHandler()).build();
    }
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
