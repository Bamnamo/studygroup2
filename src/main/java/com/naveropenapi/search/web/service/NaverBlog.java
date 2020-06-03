package com.naveropenapi.search.web.service;


import com.naveropenapi.search.web.repository.BlogRepository;
import com.naveropenapi.search.web.service.dto.BlogDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NaverBlog {

    private final BlogRepository blogRepository;

    public NaverBlog(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogDto> findByQuery(String query) {

        return blogRepository.findByQuery(query).getItems().stream()
                .map(b->BlogDto.builder()
                .title(b.getTitle())
                .link(b.getLink())
                .description(b.getDescription())
                .postdate(b.getPostdate())
                .blogger(b.getBloggername())
                .build()).collect(Collectors.toList());

    }
}
