package com.infobell.one_stop.controller;

import com.infobell.one_stop.model.CartItem;
import com.infobell.one_stop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    // Get cart item by ID
    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable int id) {
        try {
            CartItem cartItem = cartItemService.getCartItemById(id);
            return ResponseEntity.ok(cartItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create a new cart item
    @PostMapping("/create")
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
        try {
            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCartItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Update an existing cart item
    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable int id, @RequestBody CartItem cartItem) {
        try {
            CartItem updatedCartItem = cartItemService.updateCartItem(id, cartItem);
            return ResponseEntity.ok(updatedCartItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a cart item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable int id) {
        try {
            String message = cartItemService.deleteCartItem(id);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
