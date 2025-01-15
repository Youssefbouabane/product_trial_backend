package com.alt.products.controllers;

import com.alt.products.dto.ProductReqDTO;
import com.alt.products.dto.ProductResDTO;
import com.alt.products.entities.Product;
import com.alt.products.services.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/products")
@SecurityRequirement(name = "BearerAuth")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResDTO> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductReqDTO product) throws AccessDeniedException {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResDTO> updateProduct(@PathVariable Long id, @RequestBody ProductReqDTO productDetails) throws AccessDeniedException {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws AccessDeniedException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}