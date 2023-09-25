package com.example.OnlineShoppingCart.controller;


import com.example.OnlineShoppingCart.entity.Cart;
import com.example.OnlineShoppingCart.entity.CheckoutDetails;
import com.example.OnlineShoppingCart.entity.Product;
import com.example.OnlineShoppingCart.entity.Query;
import com.example.OnlineShoppingCart.service.CartService;
import com.example.OnlineShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    //method to handle list and return model and view





    @GetMapping("/cart")
    public String showCart(Model model){
        model.addAttribute("products",cartService.getAllProducts());
        return "show_cart";
    }



    @GetMapping("/search")
    public String showFilteredCart(@RequestParam("inputText") String inputText,
                                   Model model){

        System.out.println(inputText);
        model.addAttribute("products",cartService.getFilteredProducts(inputText));
        return "add_to_cart";
    }




    @GetMapping("/addTocart")
    public String addToCart(Model model){

        model.addAttribute("products",productService.getAllProducts());
        return "add_to_cart";

    }

    @GetMapping("/cart/checkout")
    public String goToCheckout(Model model){
        CheckoutDetails checkoutDetails = new CheckoutDetails();
        model.addAttribute("checkoutdetails",checkoutDetails);
        return "checkout_page";
    }




    @GetMapping("/addToCart/{id}")
    public String editProduct(@PathVariable int id, Model model){
        Product product = productService.getProductById(id);
        Cart cart = new Cart(product.getProduct_id(),product.getProduct_name(),product.getProduct_description(),product.getProduct_price(),product.getProduct_category(),product.getProduct_weight());
        cartService.saveProductToCart(cart);
        return "redirect:/addTocart";
    }


    @GetMapping("/removeFromCart/{id}")
    public String deleteCartItem(@PathVariable int id){
        cartService.deleteProductById(id);
        return "redirect:/addTocart";
    }

    @GetMapping("/removeFromCartinCartPage/{id}")
    public String deleteStudentFromCart(@PathVariable int id){
        cartService.deleteProductById(id);
        return "redirect:/cart";
    }

}
