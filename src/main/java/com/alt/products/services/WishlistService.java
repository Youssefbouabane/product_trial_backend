package com.alt.products.services;

import com.alt.products.entities.Product;
import com.alt.products.entities.User;
import com.alt.products.entities.Wishlist;
import com.alt.products.entities.WishlistItem;
import com.alt.products.repositories.ProductRepository;
import com.alt.products.repositories.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;

    public WishlistService(WishlistRepository wishlistRepository, ProductRepository productRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Wishlist addProductToWishlist(Long userId, Long productId) {
        Wishlist wishlist = wishlistRepository.findByUserId(userId).orElseGet(() -> createWishlistForUser(userId));
        Optional<Product> productOpt = productRepository.findById(productId);

        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product product = productOpt.get();

        boolean alreadyInWishlist = wishlist.getItems().stream()
                .anyMatch(item -> item.getProduct().getId().equals(productId));

        if (!alreadyInWishlist) {
            WishlistItem newItem = new WishlistItem();
            newItem.setProduct(product);
            wishlist.getItems().add(newItem);
        }

        return wishlistRepository.save(wishlist);
    }

    @Transactional
    public Wishlist removeProductFromWishlist(Long userId, Long productId) {
        Wishlist wishlist = wishlistRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Wishlist not found"));
        wishlist.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
        return wishlistRepository.save(wishlist);
    }

    public Wishlist getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId).orElseGet(() -> createWishlistForUser(userId));
    }

    private Wishlist createWishlistForUser(Long userId) {
        Wishlist wishlist = new Wishlist();
        User user = new User();
        user.setId(userId);
        wishlist.setUser(user);
        return wishlistRepository.save(wishlist);
    }
}
