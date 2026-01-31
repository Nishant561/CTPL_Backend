package com.nishant.ctplbackend.model.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productItemId;

    private String productItemColor;

    private long productItemStock;

    private double productItemPrice;

    private String productItemColorCode;

    private String productItemSize;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product itemMainProduct;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "product_image_id")
    private Image itemImage;


}
