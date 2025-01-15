package com.alt.products.dto;

import com.alt.products.enums.InventoryStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ProductResDTO {
        private Long id;
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
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
