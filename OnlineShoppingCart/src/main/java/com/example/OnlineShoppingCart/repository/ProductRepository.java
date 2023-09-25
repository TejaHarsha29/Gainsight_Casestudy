package com.example.OnlineShoppingCart.repository;

import com.example.OnlineShoppingCart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
