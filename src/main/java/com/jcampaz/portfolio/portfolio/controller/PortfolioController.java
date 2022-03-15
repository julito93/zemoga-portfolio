package com.jcampaz.portfolio.portfolio.controller;

import com.jcampaz.portfolio.portfolio.model.Portfolio;
import com.jcampaz.portfolio.portfolio.service.IPortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.Optional;

@RestController
public class PortfolioController {

    private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private IPortfolioService portfolioService;



    @GetMapping("/{id}")
    public String getUserPortfolio(Model model, @PathVariable long id) {
        Portfolio portfolio = portfolioService.findById(id).get();
        model.addAttribute("name", portfolio.getName());
        model.addAttribute("experience", portfolio.getExperience());
        model.addAttribute("profileImage", portfolio.getImagePath());
        model.addAttribute("phoneNumber", portfolio.getPhone());
        model.addAttribute("email", portfolio.getEmail());
        model.addAttribute("zipCode", portfolio.getZipCode());
        model.addAttribute("address", portfolio.getAddress());
        model.addAttribute("twitterUser", portfolio.getTwitterUser());
        return "index";
    }

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable long id, Model model) {
        Optional<Portfolio> portfolioFound = portfolioService.findById(id);

        if(portfolioFound.isEmpty())
            return  new ResponseEntity<Portfolio>( HttpStatus.BAD_REQUEST);
        else
            return  new ResponseEntity<Portfolio>( portfolioFound.get(),HttpStatus.OK);
    }

    @PutMapping("/portfolio")
    public ResponseEntity<Portfolio> saveUserPortfolio(@RequestBody Portfolio portfolio ) {
        try {
            Portfolio saved = portfolioService.savePortfolio(portfolio);
            return new ResponseEntity<Portfolio>(saved, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Portfolio>(portfolio, HttpStatus.BAD_REQUEST);
        }
    }

}
