package com.example.midterm_review;

import java.util.ArrayList;
import java.util.List;

public class CartList {
    private ArrayList<CartItem> cartItems;
    private static CartList cartList = null;

    public CartList(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public CartList() {
        cartItems = new ArrayList<CartItem>();
    }

    public static CartList getCartList() {
        if (cartList == null)
            cartList = new CartList();
        return cartList;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public double getSubTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total +=item.getQuantity()*item.getProduct().getPrice();
        }
        return total;
    }

}
