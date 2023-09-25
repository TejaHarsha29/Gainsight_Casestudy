package com.example.OnlineShoppingCart.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "checkoutdetails")
public class CheckoutDetails {

    @Id
    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;
    @Column(name = "shipping_address")
    private String shipping_address;
    @Column(name = "total_amount")
    private int total_amount;


    public CheckoutDetails(String first_name, String last_name, String shipping_address, int total_amount) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.shipping_address = shipping_address;
        this.total_amount = total_amount;
    }


    public CheckoutDetails() {
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
}
