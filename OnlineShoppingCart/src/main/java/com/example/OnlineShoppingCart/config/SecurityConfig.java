package com.example.OnlineShoppingCart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("Harsha")
                .password(encoder.encode("harsha")).roles("ADMIN").build();


        UserDetails user = User.withUsername("Vaishnavi")
                .password(encoder.encode("vaishnavi")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/cart","/addTocart","/addToCart/{id}","/removeFromCart/{id}","/removeFromCartinCartPage/{id}","/cart/checkout","/checkout/start","/success","checkout/showOrders","/search","search/{}")
                .permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/products","/products/new","/products/edit/{id}","/products/{id}","/products/delete/{id}","/search").hasRole("ADMIN").and()
                .formLogin()
                .and()
                .build();

    }





}
