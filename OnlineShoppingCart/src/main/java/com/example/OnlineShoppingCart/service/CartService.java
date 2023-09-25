package com.example.OnlineShoppingCart.service;


import com.example.OnlineShoppingCart.entity.Cart;
import com.example.OnlineShoppingCart.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {

    public void saveProductToCart(Cart cart);

    public void deleteProductById(int id);


    public List<Cart> getAllProducts();


    public List<Cart> getFilteredProducts(String query);
}
