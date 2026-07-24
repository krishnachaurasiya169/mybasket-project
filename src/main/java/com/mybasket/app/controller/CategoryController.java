package com.mybasket.app.controller;

import com.mybasket.app.dto.CategoryDto;
import com.mybasket.app.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/categories")
    public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Create
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category1 = categoryService.create(categoryDto);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    // Get All
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> list = categoryService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Get Single
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> get(@PathVariable Long categoryId) {
        CategoryDto categoryDto = categoryService.get(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

//    update the data from the database
    @PutMapping("/{categoryId}")
                public ResponseEntity<CategoryDto>update(@PathVariable("categoryId") Long categoryId , @RequestBody CategoryDto categoryDto)
             {
                CategoryDto updateCategory= categoryService.update(categoryId,categoryDto);
                return new ResponseEntity<>(updateCategory ,HttpStatus.OK);
               }


//            delete only admin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> delete(@PathVariable Long categoryId){
        categoryService.delete(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    }
