package com.jcampaz.portfolio.portfolio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcampaz.portfolio.portfolio.model.Portfolio;
import com.jcampaz.portfolio.portfolio.service.IPortfolioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import static org.hamcrest.core.Is.is;

import static org.hamcrest.core.Is.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IPortfolioService service;

    @Test
    public void savePortfolioSuccessfully() throws Exception {
        when(service.savePortfolio(Mockito.any(Portfolio.class)))
                .thenAnswer(answer -> answer.getArguments()[0]);
        Portfolio portfolio = getPortfolio();
        mvc.perform(put("/portfolio")
                        .content(objectMapper.writeValueAsString(portfolio))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getPortfolioSuccessfully() throws Exception {
        when(service.findById(Mockito.any(Long.class)))
                .thenAnswer(answer -> Optional.of(getPortfolio()));
        Portfolio portfolio = getPortfolio();
        mvc.perform(get("/portfolio/6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", isA(Integer.class)));
        ;
    }

    private Portfolio getPortfolio() {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(Long.valueOf(1));
        portfolio.setName("Username");
        portfolio.setEmail("user@domain.com");
        portfolio.setAddress("P sherman Calle Wallby 42 Sidney");
        portfolio.setExperience("The user is experienced");
        portfolio.setPhone("3024567890");
        portfolio.setImagePath("fakepath/");
        portfolio.setTwitterUser("fakeTwitteruser");
        portfolio.setZipCode("750000");
        return portfolio;
    }
}
