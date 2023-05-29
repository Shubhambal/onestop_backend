package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.CartItem;
import com.infobell.one_stop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart Item", "id", String.valueOf(id)));
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(int id, CartItem cartItem) {
        CartItem existingCartItem = getCartItemById(id);
        existingCartItem.setCart(cartItem.getCart());
        existingCartItem.setQuantity(cartItem.getQuantity());
        existingCartItem.setProduct(cartItem.getProduct());
        return cartItemRepository.save(existingCartItem);
    }

    @Override
    public String deleteCartItem(int id) {
        if (cartItemRepository.existsById(id)) {
            cartItemRepository.deleteById(id);
            return "Cart Item with ID " + id + " deleted.";
        }
        throw new ResourceNotFoundException("Cart Item", "id", String.valueOf(id));
    }
}
