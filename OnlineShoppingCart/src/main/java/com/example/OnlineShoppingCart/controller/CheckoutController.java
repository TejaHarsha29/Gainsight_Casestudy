package com.example.OnlineShoppingCart.controller;


import com.example.OnlineShoppingCart.entity.Cart;
import com.example.OnlineShoppingCart.entity.CheckoutDetails;
import com.example.OnlineShoppingCart.entity.Product;
import com.example.OnlineShoppingCart.service.impl.CartServiceImpl;
import com.example.OnlineShoppingCart.service.impl.CheckoutDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    CheckoutDetailsImpl checkoutDetailsService;


    @Autowired
    CartServiceImpl cartService;


    @PostMapping("/checkout/start")
    public String completeCheckout(@ModelAttribute("checkoutdetails") CheckoutDetails checkoutDetails){

        List<Cart> list = cartService.getAllProducts();

        int total =0;

        for(int i=0;i<list.size();i++){
            total+=list.get(i).getProduct_price();
        }

        checkoutDetails.setTotal_amount(total);

        checkoutDetailsService.saveCheckoutDetails(checkoutDetails);

        return "success";




    }


    @GetMapping("checkout/showOrders")
    public String getAllOrders(Model model){

        model.addAttribute("orders",checkoutDetailsService.getAllProducts());
        return "show_orders";

    }













}
