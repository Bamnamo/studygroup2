package com.naveropenapi.search.web.service.dto;

import java.util.List;

public class BlogGroup {

    private final List<BlogDto> list;

    public BlogGroup(List<BlogDto> list){
        this.list = list;
    }

    public List<BlogDto> getList(){
        return list;
    }
}
