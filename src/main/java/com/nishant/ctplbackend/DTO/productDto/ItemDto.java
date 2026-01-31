package com.nishant.ctplbackend.DTO.productDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class ItemDto {


    private int productItemId;


    @NotBlank
    @Size(min = 3, message = "Please provide valid color-name!")
    private String productItemColor;

    @NotNull
    @Min(value = 0,message = "Price cannot be set to negative!")
    private double productItemPrice;

    @NotNull
    @Min(value = 0,message = "Product stock cannot be less than Zero!")
    private long productItemStock;

    @NotNull
    @Size(min = 3, message = "Please provide valid product code!")
    private String productItemColorCode;

    @NotNull
    private String productItemSize;


    private ImageDto productItemImage;

}
