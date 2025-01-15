package com.alt.products.services;

import com.alt.products.dto.ProductReqDTO;
import com.alt.products.dto.ProductResDTO;
import com.alt.products.entities.Product;
import com.alt.products.mapper.ProductMapper;
import com.alt.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductResDTO> getAllProducts() {
        return productMapper.listProductToListProductResDTO(productRepository.findAll());
    }

    public Optional<ProductResDTO> getProductById(Long id) {
        return Optional.ofNullable(productMapper.productToProductResDTO(productRepository.findById(id).get()));
    }

    public Product createProduct(ProductReqDTO productReqDTO) throws AccessDeniedException {
        if (!isAdminUser()) {
            throw new AccessDeniedException("Access Denied: Only admin can add products.");
        }
        return productRepository.save(productMapper.productReqDTOToProduct(productReqDTO));
    }

    public ProductResDTO updateProduct(Long id, ProductReqDTO productDetails) throws AccessDeniedException {
        if (!isAdminUser()) {
            throw new AccessDeniedException("Access Denied: Only admin can add products.");
        }
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            product.setInventoryStatus(productDetails.getInventoryStatus());
            product.setRating(productDetails.getRating());
            return productMapper.productToProductResDTO(productRepository.save(product));
        }).orElseThrow(() -> null);
    }

    public void deleteProduct(Long id) throws AccessDeniedException {
        if (!isAdminUser()) {
            throw new AccessDeniedException("Access Denied: Only admin can add products.");
        }
        productRepository.deleteById(id);
    }


    private boolean isAdminUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof String email) {
            return "admin@admin.com".equals(email);
        }
        return false;
    }
}
