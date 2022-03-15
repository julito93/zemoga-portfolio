package com.jcampaz.portfolio.portfolio.service;

import com.jcampaz.portfolio.portfolio.model.Portfolio;
import com.jcampaz.portfolio.portfolio.repo.IPortfolioRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IPortfolioServiceImpl implements IPortfolioService{


    private static Logger logger = LoggerFactory.getLogger(IPortfolioServiceImpl.class);

    @Autowired
    private IPortfolioRepo portfolioRepo;

    @Override
    public Optional<Portfolio> findById(long id){
        logger.info(">>>>>>>>>>>>>>>>>>> retrieving data for portfolio id "+id);

        return portfolioRepo.findById(id);
    }

    @Override
    public List<Portfolio> findAll(){
        return portfolioRepo.findAll();
    }

    @Override
    public Portfolio savePortfolio(Portfolio portfolio)
    {
     return portfolioRepo.save(portfolio);
    }


    public void getTweets()
    {

    }
}
