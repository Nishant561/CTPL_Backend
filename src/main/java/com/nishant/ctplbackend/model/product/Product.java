package com.nishant.ctplbackend.model.product;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;


    private String productTitle;

    @Column(columnDefinition = "TEXT")
    private String productDescription;

    private Long productSoldQuantity;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_category_id")
    private Category productRelatedCategory;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL , orphanRemoval = true ,mappedBy = "itemMainProduct")
    private Set<Items> productsRelatedItems = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ratingProduct")
    private Rating productRating;



}
