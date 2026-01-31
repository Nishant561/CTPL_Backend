package com.nishant.ctplbackend.mapper;


import com.nishant.ctplbackend.DTO.productDto.*;
import com.nishant.ctplbackend.model.product.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToDto(Product product){
        ProductDto dto = new ProductDto();

        dto.setProductId(product.getProductId());
        dto.setProductTitle(product.getProductTitle());
        dto.setProductDescription(product.getProductDescription());
        dto.setProductSoldQuantity(product.getProductSoldQuantity());

        dto.setCategory(mapCategory(product.getProductRelatedCategory()));
        dto.setRating(mapRating(product.getProductRating()));
        dto.setItems(mapItems(product.getProductsRelatedItems()));

        return dto;
    }

    public CategoryDto mapCategory(Category category){
        CategoryDto categoryDto = new CategoryDto();

        if(category == null){
            return categoryDto;
        }

        categoryDto.setProductCategoryId(category.getProductCategoryId());
        categoryDto.setProductCategoryTitle(category.getProductCategoryTitle());

        return categoryDto;

    }

    private RatingDto mapRating(Rating rating){
        RatingDto ratingDto = new RatingDto();
        if(rating == null){
            return ratingDto;
        }

        ratingDto.setRatingDtoId(rating.getProductRatingId());
        ratingDto.setProductRate(rating.getProductRate());
        ratingDto.setProductCount(rating.getProductCount());

        return ratingDto;
    }


    private Set<ItemDto> mapItems(Set<Items> items){
        return items.stream().map(this::mapItem).collect(Collectors.toSet());
    }

    private ItemDto mapItem(Items item){
        ItemDto itemDto = new ItemDto();

        itemDto.setProductItemId(item.getProductItemId());
        itemDto.setProductItemColor(item.getProductItemColor());
        itemDto.setProductItemPrice(item.getProductItemPrice());
        itemDto.setProductItemStock(item.getProductItemStock());
        itemDto.setProductItemColorCode(item.getProductItemColorCode());
        itemDto.setProductItemSize(item.getProductItemSize());
        itemDto.setProductItemImage(mapImage(item.getItemImage()));

        return itemDto;
    }

    private ImageDto mapImage(Image image){
        ImageDto imageDto = new ImageDto();
        if(image == null){
            return imageDto;
        }

        imageDto.setProductImageId(image.getProductImageId());
        imageDto.setProductImagePublicId(image.getProductImagePublicId());
        imageDto.setProductImageUrl(image.getProductImageUrl());

        return imageDto;

    }


}
