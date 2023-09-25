package com.example.OnlineShoppingCart.service.impl;

import com.example.OnlineShoppingCart.entity.Cart;
import com.example.OnlineShoppingCart.entity.Product;
import com.example.OnlineShoppingCart.repository.CartRepository;
import com.example.OnlineShoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {


    @Autowired
    CartRepository cartRepository;

    @Override
    public void saveProductToCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteProductById(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getAllProducts() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> getFilteredProducts(String query) {
        List<Cart> list  = cartRepository.findAll();


        List<Cart> filteredList = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getProduct_name().contains(query)){
                filteredList.add(list.get(i));
            }
        }

        return filteredList;


    }


}
