package com.naveropenapi.search.service;

import com.naveropenapi.search.web.repository.MovieRepository;
import com.naveropenapi.search.web.repository.response.MovieResponse;
import com.naveropenapi.search.web.service.NaverMovie;
import com.naveropenapi.search.web.service.dto.MovieDto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.util.StringUtils.countOccurrencesOf;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private NaverMovie naverMovie;

    @Mock
    private MovieRepository movieRepository;

    @Test
    @DisplayName("평점 높은 순 정렬")
    void arranged_well_in_user_ratings() {
        //given
        float expectedUserRanking = 9.7f;
        Mockito.when(movieRepository.findByQuery(any())).thenReturn(getStubMovieList());
        naverMovie = new NaverMovie(movieRepository);
        //when
        List<MovieDto> actualList = naverMovie.findByQuery("쿼리");
        //then
        assertEquals(expectedUserRanking, actualList.stream().findFirst().get().getUserRating());
    }

    @Test
    @DisplayName("평점 0 제외")
    void remove_userRatig_0(){
        int expectedMovieSize = 3;
        Mockito.when(movieRepository.findByQuery(any())).thenReturn(getStubMovieList());
        naverMovie = new NaverMovie(movieRepository);

        List<MovieDto> actualList = naverMovie.findByQuery("쿼리");

        assertEquals(expectedMovieSize,actualList.stream().findFirst().get().getUserRating());
    }

    @Test
    @DisplayName("타이틑 특수문자 제거")
    void remove_special_title(){
        int expectedSpecialTile = 0;
        Mockito.when(movieRepository.findByQuery(any())).thenReturn(getStubMovieList());
        naverMovie = new NaverMovie(movieRepository);

        List<MovieDto> actualList = naverMovie.findByQuery("쿼리");

        assertEquals(expectedSpecialTile,
                countOccurrencesOf(actualList.stream().findFirst().get().getTitle(), "<b>"));
        assertEquals(expectedSpecialTile,
                countOccurrencesOf(actualList.stream().findFirst().get().getTitle(), "</b>"));
    }


    private MovieResponse getStubMovieList() {

        List<MovieResponse.Item> items = Arrays.asList(
                MovieResponse.Item.builder().title("<b>영화1</b>").actor("배우1").userRating(7.3f).build(),
                MovieResponse.Item.builder().title("<b>영화2</b>").actor("배우2").userRating(8.2f).build(),
                MovieResponse.Item.builder().title("<b>영화3</b>").actor("배우2").userRating(9.7f).build(),
                MovieResponse.Item.builder().title("<b>영화5</b>").actor("배우2").userRating(0.0f).build(),
                MovieResponse.Item.builder().title("<b>영화4</b>").actor("배우3").userRating(6.5f).build()
        );

        return MovieResponse.builder()
                .items(items)
                .build();
    }
}