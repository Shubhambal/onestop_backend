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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Cart;
import com.emart.exception.CartNotFoundException;
import com.emart.services.CartManager;

/**
 * The CartController class handles the API endpoints related to cart operations.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

    @Autowired
    private CartManager manager;

    /**
     * Adds an item to the cart.
     *
     * @param cart The Cart object containing the item details to be added.
     * @return ResponseEntity with a success message if the item is added successfully,
     *         or an error message if the item addition fails.
     */
    @PostMapping("api/add")
    public ResponseEntity<String> addTo(@RequestBody Cart cart) {
        try {
            manager.addToCart(cart);
            return ResponseEntity.ok("Item added to the cart successfully.");
        } catch (Exception e) {
            // If an error occurs while adding item to the cart, return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add item to the cart.");
        }
    }

    /**
     * Retrieves all the cart items.
     *
     * @return ResponseEntity with the list of Cart items if they exist,
     *         or a no content response if no cart items are found.
     */
    @GetMapping("api/get")
    public ResponseEntity<List<Cart>> getAll() {
        List<Cart> cartItems = manager.getAllCart();
        if (cartItems.isEmpty()) {
            // If no cart items found, return a no content response
            return ResponseEntity.noContent().build();
        } else {
            // If cart items exist, return them in the response
            return ResponseEntity.ok(cartItems);
        }
    }

    /**
     * Retrieves a cart item by cart ID.
     *
     * @param cart_Id The ID of the cart item to retrieve.
     * @return ResponseEntity with the Cart item if it exists,
     *         or throws a CartNotFoundException if the cart item is not found.
     */
    @GetMapping("api/get/{cart_Id}")
    public ResponseEntity<Cart> getBy(@PathVariable int cart_Id) {
        Optional<Cart> cartItem = manager.getById(cart_Id);
        return cartItem.map(ResponseEntity::ok).orElseThrow(() ->
                new CartNotFoundException("Cart item not found with cart ID: " + cart_Id, null, cartItem));
    }

    /**
     * Deletes a cart item by cart ID.
     *
     * @param cart_Id The ID of the cart item to delete.
     * @return ResponseEntity with a success message if the item is deleted successfully,
     *         or an error message if the item deletion fails.
     */
    @DeleteMapping("api/delete/{cart_Id}")
    public ResponseEntity<String> deleteFrom(@PathVariable int cart_Id) {
        try {
            manager.deleteFromCart(cart_Id);
            return ResponseEntity.ok("Item deleted from the cart successfully.");
        } catch (Exception e) {
            // If an error occurs while deleting item from the cart, return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete item from the cart.");
        }
    }
}
