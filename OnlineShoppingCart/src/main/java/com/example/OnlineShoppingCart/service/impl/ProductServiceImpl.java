package com.example.OnlineShoppingCart.service.impl;

import com.example.OnlineShoppingCart.entity.Product;
import com.example.OnlineShoppingCart.repository.ProductRepository;
import com.example.OnlineShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById((long) id).get();
    }

    @Override
    public void deleteProductBtId(int id) {
        productRepository.deleteById((long) id);
    }
}
