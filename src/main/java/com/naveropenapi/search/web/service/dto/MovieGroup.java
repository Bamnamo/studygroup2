package com.naveropenapi.search.web.service.dto;




import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MovieGroup {

    private final List<MovieDto> list;

    public MovieGroup(List<MovieDto> list) {
        this.list = list;
    }

    public List<MovieDto> getList() {
        return ListOrderRating();
    }

    public List<MovieDto> ListOrderRating() {
        return list.stream()
                .filter(b -> !((Float)b.getUserRating()).equals(0.0f))
                .sorted((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1)
                .collect(Collectors.toList());
    }

}
