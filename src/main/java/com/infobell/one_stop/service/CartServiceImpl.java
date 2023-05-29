package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Cart;
import com.infobell.one_stop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCartById(int id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart", "id", String.valueOf(id)));
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(int id, Cart cart) {
        Cart existingCart = getCartById(id);
        existingCart.setTotalCost(cart.getTotalCost());
        existingCart.setCustomer(cart.getCustomer());
        existingCart.setCartItems(cart.getCartItems());
        existingCart.setOrder(cart.getOrder());
        return cartRepository.save(existingCart);
    }

    @Override
    public String deleteCart(int id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return "Cart with ID " + id + " deleted.";
        } else {
            throw new ResourceNotFoundException("Cart", "id", String.valueOf(id));
        }
    }
}
