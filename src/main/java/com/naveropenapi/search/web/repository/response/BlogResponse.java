package com.naveropenapi.search.web.repository.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {

    private List<naverDocument> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class naverDocument{
        private String title;
        private String link;
        private String bloggername;
        private String description;
        private String postdate;
    }
}
