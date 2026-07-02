package com.mybasket.app.service;

import com.mybasket.app.dto.CategoryDto;

import java.util.List;


public interface CategoryService {


    //  Create
    CategoryDto create(CategoryDto categoryDto);

    //  getall

    List<CategoryDto> getAll();

//  getsingle

    CategoryDto get(Long categoryId);

//      update
   CategoryDto update(Long categoryId , CategoryDto categoryDto);

//  delete

 void delete(Long categoryId);
}
