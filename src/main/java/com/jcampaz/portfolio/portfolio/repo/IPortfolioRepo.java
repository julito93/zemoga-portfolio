package com.jcampaz.portfolio.portfolio.repo;

import com.jcampaz.portfolio.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPortfolioRepo extends JpaRepository<Portfolio, Long> {
}