package com.mybasket.app.service.impl;

import com.mybasket.app.dto.CategoryDto;
import com.mybasket.app.entity.Category;
import com.mybasket.app.repository.CategoryRepository;
import com.mybasket.app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


 private final CategoryRepository categoryRepository;
 private final ModelMapper modelMapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
//    dto to ---> entity conversion
//   model mapper library use
        Category categoryEntity = modelMapper.map(categoryDto, Category.class);
           var savedCategoryEntity=categoryRepository.save(categoryEntity);
//           ab entity ---> dto
        return modelMapper.map(savedCategoryEntity,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAll() {
       List<Category> categories = categoryRepository.findAll();
       return categories
               .stream()
               .map(category -> modelMapper.map(category,CategoryDto.class))
               .toList();
    }

    @Override
    public CategoryDto get(Long categoryId) {
       Category category= categoryRepository.findById(categoryId).get();
        return  modelMapper.map(category,CategoryDto.class);
    }


}
