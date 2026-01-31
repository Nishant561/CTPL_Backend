package com.nishant.ctplbackend.DTO.productDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDto {


    private int productCategoryId;

    @NotBlank(message = "Product Category Title Cannot be blank!")
    @Size(min = 3, message = "Category Title must be 3 character long!")
    private String productCategoryTitle;

}
