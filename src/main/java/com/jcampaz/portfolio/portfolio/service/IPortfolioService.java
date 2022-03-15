package com.jcampaz.portfolio.portfolio.service;

import com.jcampaz.portfolio.portfolio.model.Portfolio;

import java.util.List;
import java.util.Optional;

public interface IPortfolioService {

    public Optional<Portfolio> findById(long id);
    public List<Portfolio> findAll();

    Portfolio savePortfolio(Portfolio portfolio);
}
