package com.example.OnlineShoppingCart;

import com.example.OnlineShoppingCart.entity.Product;
import com.example.OnlineShoppingCart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShoppingCartApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingCartApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
//		Product p1 = new Product(1,"Colgate","tooth paste",300,"dental care",1);
//		productRepository.save(p1);
//
//		Product p2 = new Product(2,"Dove","bathing Soap",400,"bathing",2);
//		productRepository.save(p2);
//
//		Product p3 = new Product(3,"Kurkure","fried chips",20,"snack item",1);
//		productRepository.save(p3);

	}
}
