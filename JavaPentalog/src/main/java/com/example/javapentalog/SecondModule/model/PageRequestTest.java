package com.example.javapentalog.SecondModule.model;


import lombok.Data;

@Data
public class PageRequestTest {
    private Integer page;
    private Integer size;
    public PageRequestTest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
