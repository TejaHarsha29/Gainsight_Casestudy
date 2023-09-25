package com.example.OnlineShoppingCart.repository;

import com.example.OnlineShoppingCart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {



}
