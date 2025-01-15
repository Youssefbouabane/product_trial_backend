package com.alt.products.controllers;

import com.alt.products.entities.Wishlist;
import com.alt.products.services.WishlistService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
@SecurityRequirement(name = "BearerAuth")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/add")
    public Wishlist addProductToWishlist(@RequestParam Long userId, @RequestParam Long productId) {
        return wishlistService.addProductToWishlist(userId, productId);
    }

    @DeleteMapping("/remove")
    public Wishlist removeProductFromWishlist(@RequestParam Long userId, @RequestParam Long productId) {
        return wishlistService.removeProductFromWishlist(userId, productId);
    }

    @GetMapping("/{userId}")
    public Wishlist getWishlist(@PathVariable Long userId) {
        return wishlistService.getWishlistByUserId(userId);
    }
}
