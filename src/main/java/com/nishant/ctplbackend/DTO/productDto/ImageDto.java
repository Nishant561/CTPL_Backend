package com.nishant.ctplbackend.DTO.productDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class ImageDto {


    private int productImageId;


    @NotBlank(message = "Image public ID cannot be blank")
    private String productImagePublicId;

    @NotBlank(message = "Image URL cannot be blank")
    @URL(message = "Please provide a valid URL")
    private String productImageUrl;

}
