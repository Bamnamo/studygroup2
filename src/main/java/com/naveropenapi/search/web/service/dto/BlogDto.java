package com.naveropenapi.search.web.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogDto {

    private String title;
    private String link;
    private String blogger;
    private String description;
    private String postdate;
}
