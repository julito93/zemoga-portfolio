package com.jcampaz.portfolio.portfolio.service;

import com.jcampaz.portfolio.portfolio.model.TimelineResponseDTO;

public interface TimeLineService {
    TimelineResponseDTO[] getTimelines(String handle);
}
