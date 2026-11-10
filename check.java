package com.ecommerce;

public class check {
    public static void main(String[] args) {
        CheckoutFacade checkout = new CheckoutFacade();
        boolean result = checkout.placeOrder("Phone-12", "user_777", "Abay street 10", 850.00);
        if (result) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order checkout failed!");
        }
    }
}