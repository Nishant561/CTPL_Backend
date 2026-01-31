package com.nishant.ctplbackend.DTO.productDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RatingDto {

    @JsonIgnore
    private int ratingDtoId;

    @NotNull(message = "Please provide the product-rate!")
    @Min(value = 0,message = "Product Rate must be 0 or greater than zero!")
    private double productRate;


    private int productCount;
}
