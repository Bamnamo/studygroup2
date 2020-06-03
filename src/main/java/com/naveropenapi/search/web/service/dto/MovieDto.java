package com.naveropenapi.search.web.service.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class MovieDto {
    private String title;
    private String link;
    private String actor;
    private String director;
    private float userRating;


}
