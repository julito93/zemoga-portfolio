package com.jcampaz.portfolio.portfolio.controller;


import com.jcampaz.portfolio.portfolio.model.TimelineResponseDTO;
import com.jcampaz.portfolio.portfolio.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/timelines")
public class TimelineController {

    @Autowired
    private TimeLineService timelineService;

    @GetMapping(path = "/")
    public TimelineResponseDTO[] getTimelines(@RequestParam("x") String x) {
        return timelineService.getTimelines(x);
    }
}