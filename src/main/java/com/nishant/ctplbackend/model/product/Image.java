package com.nishant.ctplbackend.model.product;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productImageId;

    private String productImagePublicId;

    private String productImageUrl;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "itemImage")
    private Items imageItem;


}
