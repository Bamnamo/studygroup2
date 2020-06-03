package com.naveropenapi.search.web.service;

import com.naveropenapi.search.web.repository.MovieRepository;
import com.naveropenapi.search.web.service.dto.MovieDto;
import com.naveropenapi.search.web.service.dto.MovieGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NaverMovie {

    private final MovieRepository movieRepository;

    public NaverMovie (MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
   public List<MovieDto> findByQuery(String query){
        return getMovieGroup(query).getList();
   }

   private MovieGroup getMovieGroup(String query){
        return new MovieGroup(findByQueryImpl(query));
   }

    public List<MovieDto> findByQueryImpl(String query) {

        return movieRepository.findByQuery(query).getItems().stream()
                .map(m->MovieDto.builder()
                .title(m.getCleanTitle())
                .link(m.getLink())
                .userRating(m.getUserRating())
                        .actor(m.getActor())
                        .director(m.getDirector())
                .build()).collect(Collectors.toList());
    }
}
