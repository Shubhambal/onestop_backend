package com.infobell.one_stop.controller;

import com.infobell.one_stop.model.CartItem;
import com.infobell.one_stop.service.CartItemService;
import com.infobell.one_stop.serviceimpl.CartItemServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    /**
     * Retrieves all cart items.
     *
     * @return A list of cart items.
     */
    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    /**
     * Retrieves a cart item by its ID.
     *
     * @param cartItemId The ID of the cart item.
     * @return The cart item with the given ID.
     */
    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable int cartItemId) {
        try {
            CartItem cartItem = cartItemService.getCartItemById(cartItemId);
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates a new cart item.
     *
     * @param cartItem The cart item to create.
     * @return The created cart item.
     */
    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.createCartItem(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    /**
     * Updates an existing cart item.
     *
     * @param cartItemId The ID of the cart item to update.
     * @param cartItem   The updated cart item.
     * @return The updated cart item.
     */
    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(
            @PathVariable int cartItemId, @RequestBody CartItem cartItem) {
        try {
            CartItem updatedCartItem = cartItemService.updateCartItem(cartItemId, cartItem);
            return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a cart item.
     *
     * @param cartItemId The ID of the cart item to delete.
     * @return A response indicating the success of the operation.
     */
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int cartItemId) {
        try {
            cartItemService.deleteCartItem(cartItemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
