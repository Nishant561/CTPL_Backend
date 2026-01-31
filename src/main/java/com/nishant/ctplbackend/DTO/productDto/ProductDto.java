package com.nishant.ctplbackend.DTO.productDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class ProductDto {


    private int productId;

    @NotBlank
    @Size(min = 3, message = "Product title must be 3 character long!")
    private String productTitle;

    @NotBlank
    @Size(min = 5, message = "Product description must be 5 character long!")
    private String productDescription;

    @NotBlank
    @Min(value = 0, message = "Product sold quantity must be greater than zero !")
    private Long productSoldQuantity;

    @Valid
    @NotNull
    private CategoryDto category;

    @Valid
    @NotNull
    private RatingDto rating;

    @Valid
    @NotNull
    private Set<ItemDto> items;





}
