package com.nishant.ctplbackend.controller;


import com.nishant.ctplbackend.DTO.productDto.ProductCreationDto;
import com.nishant.ctplbackend.DTO.productDto.ProductDto;
import com.nishant.ctplbackend.model.Response;
import com.nishant.ctplbackend.service.productServices.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping("/add-new-product")
    public ResponseEntity<Response> addNewProduct(@Valid @RequestPart(name = "product", required = true)ProductCreationDto productCreationDto, @RequestPart (name = "image") List<MultipartFile> file){

        Response res = productServices.addProduct(productCreationDto,file);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "size", required = true) int size){

        return new ResponseEntity<>(
                productServices.allProducts(page,size),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getSingleProduct(@PathVariable( required = true) int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(productServices.singleProduct(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable(required = true) int id){
         productServices.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.OK).body(new Response("200","Product Deleted Successfully!"));
    }



}
