package com.jcampaz.portfolio.portfolio.controller;

import com.jcampaz.portfolio.portfolio.model.Portfolio;
import com.jcampaz.portfolio.portfolio.service.IPortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PortfolioController {

    private static Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping("/portfolio/{id}")
    public String getUserPortfolio(Model model, @PathVariable long id){
        Portfolio portfolio = portfolioService.findById(id).get();
        logger.info(">>>>>>>>>>>>>> retrieved the portfolio of "+portfolio.getName());
        model.addAttribute("name",portfolio.getName());
        model.addAttribute("experience",portfolio.getExperience());
        model.addAttribute("profileImage",portfolio.getImagePath());
        model.addAttribute("phoneNumber",portfolio.getPhone());
        model.addAttribute("email",portfolio.getEmail());
        model.addAttribute("zipCode",portfolio.getZipCode());
        model.addAttribute("address",portfolio.getAddress());
        model.addAttribute("twitterUser",portfolio.getTwitterUser());
        return "index";
    }
}
