package com.naveropenapi.search.web;


import com.naveropenapi.search.web.service.NaverBlog;
import com.naveropenapi.search.web.service.NaverMovie;
import com.naveropenapi.search.web.service.dto.BlogDto;
import com.naveropenapi.search.web.service.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final NaverBlog naverBlog;
    private final NaverMovie naverMovie;


    @GetMapping("/blog")
    public List<BlogDto> searchBlogByQuery(@RequestParam(name = "query",required = false) String query) {

        return naverBlog.findByQuery(query);
    }

    @GetMapping("/movie")
    public List<MovieDto> searchMovieByQuery(@RequestParam(name = "query",required = false)String query){
        return  naverMovie.findByQuery("반지");
    }
    }
