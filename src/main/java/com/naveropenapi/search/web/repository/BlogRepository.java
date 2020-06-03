package com.naveropenapi.search.web.repository;


import com.naveropenapi.search.web.config.NaverProperties;
import com.naveropenapi.search.web.repository.response.BlogResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class BlogRepository {

    private final NaverProperties naverProperties;
    private final RestTemplate naverRestTemplate;

    public  BlogResponse findByQuery(String query) {



        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getBlogurl() + "?query=" + query;

        return naverRestTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), BlogResponse.class).getBody();
    }
}
