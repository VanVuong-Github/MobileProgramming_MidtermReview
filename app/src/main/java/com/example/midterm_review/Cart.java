package com.example.midterm_review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    private CartList cartList;
    CartAdapter cartAdapter;
    RecyclerView rcvCart;
    TextView tvDelivery, tvDeliveryFee, tvTotal, tvTotalPrice;
    Button btnCheckOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartList = new CartList().getCartList();
        Bundle bundle =getIntent().getExtras();
        CartItem cartItem =(CartItem) bundle.getSerializable("cartItem");
        cartList.addToCart(cartItem);

        rcvCart = findViewById(R.id.rcvCart);
        cartAdapter = new CartAdapter(this, cartList.getCartItems());
        rcvCart.setAdapter(cartAdapter);
        rcvCart.setLayoutManager(new GridLayoutManager(this, 1));

        tvDelivery = findViewById(R.id.cart_tv_delivery);
        tvDeliveryFee = findViewById(R.id.cart_tv_deliveryfee);
        tvTotal = findViewById(R.id.cart_tv_total);
        tvTotalPrice = findViewById(R.id.cart_tv_totalprice);
        btnCheckOut = findViewById(R.id.btnCheckOut);

        tvDelivery.setText("Delivery fee:");
        tvDeliveryFee.setText("Free");
        tvTotal.setText("Total:");
        tvTotalPrice.setText(cartList.getSubTotal()+"");
        btnCheckOut.setText("Check Out");
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this, MainActivity.class); //back to main intent
                startActivity(intent);
            }
        });
    }


}