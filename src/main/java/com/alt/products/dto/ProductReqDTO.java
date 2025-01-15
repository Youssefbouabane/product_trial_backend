package com.alt.products.dto;

import com.alt.products.enums.InventoryStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductReqDTO {
    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private double price;
    private int quantity;
    private String internalReference;
    private Long shellId;
    private InventoryStatus inventoryStatus;
    private int rating;

}
