package com.jcampaz.portfolio.portfolio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimelineResponseDTO {

    @JsonProperty("text")
    private String text;

    @JsonProperty("created_at")
    private String created_at;
}
