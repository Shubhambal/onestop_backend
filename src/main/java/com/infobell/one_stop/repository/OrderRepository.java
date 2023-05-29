package com.infobell.one_stop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infobell.one_stop.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
