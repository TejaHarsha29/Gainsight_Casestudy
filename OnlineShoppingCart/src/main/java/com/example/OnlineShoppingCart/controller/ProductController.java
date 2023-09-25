package com.example.OnlineShoppingCart.controller;


import com.example.OnlineShoppingCart.entity.Product;
import com.example.OnlineShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    //method to handle list and return model and view


    @GetMapping("/products")
    public String listProducts(Model model){

        model.addAttribute("products",productService.getAllProducts());
        return "products";

    }




    @GetMapping("/products/new")
    public String createStudentForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add_product";
    }


    @PostMapping("/products")
    public String saveProducts(@ModelAttribute("product")Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable int id, Model model){

        model.addAttribute("product",productService.getProductById(id));
        return "edit_product";

    }


    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable int id,@ModelAttribute("product") Product product,Model model){

        Product existingProduct = productService.getProductById(id);
        existingProduct.setProduct_id(id);
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setProduct_category(product.getProduct_category());
        existingProduct.setProduct_description(product.getProduct_description());
        existingProduct.setProduct_price(product.getProduct_price());
        existingProduct.setProduct_weight(product.getProduct_weight());

        productService.updateProduct(existingProduct);
        return "redirect:/products";


    }


    @GetMapping("/products/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        productService.deleteProductBtId(id);
        return "redirect:/products";
    }




}
