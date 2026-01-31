package com.nishant.ctplbackend.service.categoryServices;


import com.nishant.ctplbackend.DTO.productDto.CategoryDto;
import com.nishant.ctplbackend.mapper.ProductMapper;
import com.nishant.ctplbackend.model.product.Category;
import com.nishant.ctplbackend.repo.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServices {


    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Autowired
    public CategoryServices(CategoryRepository categoryRepository, ProductMapper productMapper){
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public List<CategoryDto> allCategory(){
             List<Category> result =   categoryRepository.findAll();

             return result.stream().map(productMapper::mapCategory).toList();
    }



}
