package com.naveropenapi.search.web.repository.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private List<Item> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item{
        private String title;
        private String link;
        private String actor;
        private String director;
        private float userRating;


        public String getCleanTitle(){

            return removeSpecialTitle(title);
        }

        private String removeSpecialTitle(String str){
            String resultStr = str;
            resultStr = StringUtils.replace(resultStr, "<b>","");
            resultStr = StringUtils.replace(resultStr, "</b>","");
            return resultStr;
        }

    }
}
