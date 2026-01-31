package com.nishant.ctplbackend.service.productServices;


import com.nishant.ctplbackend.DTO.productDto.*;
import com.nishant.ctplbackend.errorhandler.ProductCreationException;
import com.nishant.ctplbackend.errorhandler.ResourceNotFoundException;
import com.nishant.ctplbackend.mapper.ProductMapper;
import com.nishant.ctplbackend.model.Response;
import com.nishant.ctplbackend.model.product.*;
import com.nishant.ctplbackend.repo.CategoryRepository;
import com.nishant.ctplbackend.repo.ProductRepository;
import com.nishant.ctplbackend.service.cloudinaryService.CloudinaryService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServices {

    private final CloudinaryService cloudinaryService;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServices(CloudinaryService cloudinaryService, ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper){
        this.cloudinaryService = cloudinaryService;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public Response addProduct(ProductCreationDto productCreationDto , List<MultipartFile> files){

        try{
            List<Map<String,Object>> fileUploadedResult = cloudinaryService.uploadFile(files, "CTPL");

            Iterator<Map<String,Object>> uploadResults = fileUploadedResult.iterator();

            Product product = new Product();

            product.setProductTitle(productCreationDto.getProductTitle());
            product.setProductDescription(productCreationDto.getProductDescription());
            product.setProductSoldQuantity(productCreationDto.getProductSoldQuantity());

            Category category = categoryRepository
                    .findByProductCategoryTitle(
                            productCreationDto.getCategory().getProductCategoryTitle()
                    )
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Category not found")
                    );

            category.addProduct(product);

            Set<Items> items = productCreationDto.getItems().stream()
                    .map(itemDto -> {

                        Items item = new Items();
                        item.setProductItemColor(itemDto.getProductItemColor());
                        item.setProductItemPrice(itemDto.getProductItemPrice());
                        item.setProductItemStock(itemDto.getProductItemStock());
                        item.setProductItemColorCode(itemDto.getProductItemColorCode());
                        item.setProductItemSize(itemDto.getProductItemSize());

                        Map<String, Object> upload = uploadResults.next();

                        Image image = new Image();
                        image.setProductImageUrl(upload.get("secure_url").toString());
                        image.setProductImagePublicId(upload.get("public_id").toString());


                        image.setImageItem(item);
                        item.setItemImage(image);


                        item.setItemMainProduct(product);

                        return item;
                    })
                    .collect(Collectors.toSet());

            product.setProductsRelatedItems(items);
            Product savedProduct = productRepository.save(product);

            return new Response(
                    "201",
                    "Product added successfully"
            );

        }catch (Exception ex){
            log.info("Failed to add the product! Error: {}",ex.getMessage());
            throw new ProductCreationException("Unable to add product!",ex);
        }
    }

    public List<ProductDto> allProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page-1,size);
        Page<Product> result = productRepository.findAll(pageable);
        return result.stream().map(productMapper::mapToDto).toList();


    }

    public ProductDto singleProduct(int productId){
       Product result = productRepository.findById(productId).orElseThrow(()-> (new ResourceNotFoundException("Uable to find product!")));

       return productMapper.mapToDto(result);

    }

    public void deleteProduct(int productId){

       Product result = productRepository.findById(productId).orElseThrow(()-> ( new ResourceNotFoundException("Item you tried to delete is not found!")));

       productRepository.deleteById(productId);


    }




}
