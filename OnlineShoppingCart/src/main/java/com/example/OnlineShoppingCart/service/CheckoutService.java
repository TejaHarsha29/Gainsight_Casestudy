package com.example.OnlineShoppingCart.service;

import com.example.OnlineShoppingCart.entity.Cart;
import com.example.OnlineShoppingCart.entity.CheckoutDetails;
import com.example.OnlineShoppingCart.entity.Product;

import java.util.List;

public interface CheckoutService {

    CheckoutDetails saveCheckoutDetails(CheckoutDetails checkoutDetails);



    public List<CheckoutDetails> getAllProducts();

}
