package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.CartItem;
import com.emart.exception.CartItemNotFoundException;
import com.emart.services.CartItemManager;


/**
 * The CartItemController class handles the API endpoints related to cartIteam operations.
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class CartItemController {

    @Autowired
    CartItemManager manager;

    /**
     * Retrieves all the cart items.
     *
     * @return ResponseEntity with the list of CartItem objects if they exist,
     *         or a no content response if no cart items are found.
     */
    @GetMapping(value = "api/cartitems")
    public ResponseEntity<List<CartItem>> showcartitems() {
        List<CartItem> cartItems = manager.getCartItems();
        if (cartItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItems);
        }
    }

    /**
     * Retrieves a specific cart item by its ID.
     *
     * @param ctid The ID of the cart item to retrieve.
     * @return ResponseEntity with the CartItem if found,
     *         or throws CartItemNotFoundException if the cart item is not found.
     */
    @GetMapping(value = "api/cartitemsById/{ctid}")
    public ResponseEntity<CartItem> getcartitem(@PathVariable int ctid) {
        Optional<CartItem> cartItem = manager.getCartItem(ctid);
        return cartItem.map(ResponseEntity::ok).orElseThrow(() ->
                new CartItemNotFoundException("CartItem not found with ctid: " + ctid));
    }

    /**
     * Removes a cart item by its ID.
     *
     * @param ctid The ID of the cart item to remove.
     * @return ResponseEntity with a success message if the cart item is deleted successfully,
     *         or an error message if the cart item deletion fails.
     */
    @DeleteMapping(value = "api/cartitems/{ctid}")
    public ResponseEntity<String> removecartitem(@PathVariable int ctid) {
        try {
            manager.delete(ctid);
            return ResponseEntity.ok("Cart item deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete cart item: " + e.getMessage());
        }
    }

    /**
     * Updates a cart item by its ID.
     *
     * @param cartitem The updated CartItem object.
     * @param ctid     The ID of the cart item to update.
     * @return ResponseEntity with a success message if the cart item is updated successfully,
     *         or an error message if the cart item update fails.
     */
    @PutMapping(value = "api/cartitems/{ctid}")
    public ResponseEntity<String> updatecartitem(@RequestBody CartItem cartitem, @PathVariable int ctid) {
        try {
            manager.update(cartitem, ctid);
            return ResponseEntity.ok("Cart item updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update cart item: " + e.getMessage());
        }
    }

    /**
     * Adds a new cart item.
     *
     * @param cartitem The CartItem object to add.
     * @return ResponseEntity with a success message if the cart item is added successfully,
     *         or an error message if the cart item addition fails.
     */
    @PostMapping(value = "api/cartitems")
    public ResponseEntity<String> addcartitem(@RequestBody CartItem cartitem) {
        try {
            manager.addCartItem(cartitem);
            return ResponseEntity.ok("Cart item added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add cart item: " + e.getMessage());
        }
    }
}
