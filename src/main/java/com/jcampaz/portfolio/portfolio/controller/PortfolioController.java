package com.jcampaz.portfolio.portfolio.controller;

import com.jcampaz.portfolio.portfolio.model.Portfolio;
import com.jcampaz.portfolio.portfolio.model.TimelineResponseDTO;
import com.jcampaz.portfolio.portfolio.service.IPortfolioService;
import com.jcampaz.portfolio.portfolio.service.TimeLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class PortfolioController {

    private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private IPortfolioService portfolioService;

    @Autowired
    private TimeLineService timeLineService;

    @GetMapping("/")
    public  String getAllPortfolio(Model model)
    {
        List<Portfolio> list = portfolioService.findAll();
        model.addAttribute("portfolios",list);
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserPortfolio(Model model, @PathVariable long id) {
        Portfolio portfolio = portfolioService.findById(id).get();
        logger.info(">>>>>>>>>>>>>>> TwitterUser " + portfolio.getTwitterUser());
        TimelineResponseDTO[] timeline = timeLineService.getTimelines(portfolio.getTwitterUser());
        logger.info("the twits in the timeline are " + Arrays.stream(timeline)
                .reduce("", (string, next) -> string + ", " + next.getText(), String::concat));
        model.addAttribute("name", portfolio.getName());
        model.addAttribute("experience", portfolio.getExperience());
        model.addAttribute("profileImage", portfolio.getImagePath());
        model.addAttribute("phoneNumber", portfolio.getPhone());
        model.addAttribute("email", portfolio.getEmail());
        model.addAttribute("zipCode", portfolio.getZipCode());
        model.addAttribute("address", portfolio.getAddress());
        model.addAttribute("twitterUser", portfolio.getTwitterUser());
        model.addAttribute("timeline", timeline);
        return "portfolioDetails";
    }

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable long id, Model model) {
        Optional<Portfolio> portfolioFound = portfolioService.findById(id);

        if (portfolioFound.isEmpty())
            return new ResponseEntity<Portfolio>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Portfolio>(portfolioFound.get(), HttpStatus.OK);
    }

    @PutMapping("/portfolio")
    public ResponseEntity<Portfolio> saveUserPortfolio(@RequestBody Portfolio portfolio) {
        try {
            Portfolio saved = portfolioService.savePortfolio(portfolio);
            return new ResponseEntity<Portfolio>(saved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Portfolio>(portfolio, HttpStatus.BAD_REQUEST);
        }
    }

}
