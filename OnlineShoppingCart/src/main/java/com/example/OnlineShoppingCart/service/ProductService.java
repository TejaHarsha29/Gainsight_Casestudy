package com.example.OnlineShoppingCart.service;

import com.example.OnlineShoppingCart.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    Product getProductById(int id);

    void deleteProductBtId(int id);

}
