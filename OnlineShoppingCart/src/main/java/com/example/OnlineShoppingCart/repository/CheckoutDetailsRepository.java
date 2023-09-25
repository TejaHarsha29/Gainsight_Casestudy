package com.example.OnlineShoppingCart.repository;

import com.example.OnlineShoppingCart.entity.CheckoutDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutDetailsRepository extends JpaRepository<CheckoutDetails,Integer> {
}
