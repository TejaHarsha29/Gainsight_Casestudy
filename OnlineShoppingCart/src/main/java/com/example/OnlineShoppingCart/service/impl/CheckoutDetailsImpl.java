package com.example.OnlineShoppingCart.service.impl;

import com.example.OnlineShoppingCart.entity.CheckoutDetails;
import com.example.OnlineShoppingCart.repository.CheckoutDetailsRepository;
import com.example.OnlineShoppingCart.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CheckoutDetailsImpl implements CheckoutService {

    @Autowired
    CheckoutDetailsRepository checkoutDetailsRepository;

    @Override
    public CheckoutDetails saveCheckoutDetails(CheckoutDetails checkoutDetails) {

        return checkoutDetailsRepository.save(checkoutDetails);

    }

    @Override
    public List<CheckoutDetails> getAllProducts() {
        return checkoutDetailsRepository.findAll();
    }
}
