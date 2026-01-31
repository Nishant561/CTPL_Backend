package com.nishant.ctplbackend.model.product;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCategoryId;

    private String productCategoryTitle;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "productRelatedCategory")
    private Set<Product> categoryRelatedProduct = new HashSet<>();

    public void addProduct(Product product) {
        categoryRelatedProduct.add(product);
        product.setProductRelatedCategory(this);
    }

}
