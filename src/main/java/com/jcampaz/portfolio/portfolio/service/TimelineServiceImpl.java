package com.jcampaz.portfolio.portfolio.service;


import com.jcampaz.portfolio.portfolio.model.TimelineResponseDTO;
import com.jcampaz.portfolio.portfolio.utils.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimelineServiceImpl extends TwitterBaseService implements TimeLineService {

    @Override
    public TimelineResponseDTO[] getTimelines(String handle) {
        Map<String, String> requestParams = new HashMap<>();
        //requestParams.put("cursor", "-1");
        requestParams.put(Constants.COUNT, "5");
        requestParams.put(Constants.SCREEN_NAME, handle);
        String header = generator.generateHeader(HttpMethod.GET.name(), Constants.TIMELINES_API, requestParams);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", header);
        HttpEntity<String> httpEntity = new HttpEntity<String>("body", headers);
        ResponseEntity<TimelineResponseDTO[]> timelinesResEntity = restTemplate.exchange(Constants.TIMELINES_API
                        + "?count=5&screen_name=" + handle,
                HttpMethod.GET, httpEntity, TimelineResponseDTO[].class);
        TimelineResponseDTO[] timelinesResponse = timelinesResEntity.getBody();
        return timelinesResponse;
    }
}