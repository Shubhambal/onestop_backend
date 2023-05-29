package com.infobell.one_stop.repository;

import com.infobell.one_stop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // You can define additional custom queries or operations here if needed
}
