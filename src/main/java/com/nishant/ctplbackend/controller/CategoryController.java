package com.nishant.ctplbackend.controller;

import com.nishant.ctplbackend.DTO.productDto.CategoryDto;
import com.nishant.ctplbackend.service.categoryServices.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryServices categoryServices;

    @Autowired
    public CategoryController(CategoryServices categoryServices){
        this.categoryServices = categoryServices;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){

        return ResponseEntity.status(HttpStatus.OK).body(categoryServices.allCategory());

    }


}
