package com.mybasket.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDto {

    private Long id;

//    private String url;

    private String title;

    private String imageurl;
}
