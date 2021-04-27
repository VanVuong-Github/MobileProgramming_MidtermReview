package com.example.midterm_review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvProduct;
    private ProductAdapter productAdapter;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvProduct = findViewById(R.id.rcvProduct);
        products = new ArrayList<Product>();
        products.add(new Product("Matteo Armchair", 550, R.drawable.matteo_armchair));
        products.add(new Product("Modern Armchair", 550, R.drawable.modern_armchair));
        products.add(new Product("Nice Armchair", 550, R.drawable.nice_armchair));
        products.add(new Product("Circle Armchair", 550, R.drawable.circle_armchair));

        productAdapter =new ProductAdapter(this, products);
        rcvProduct.setAdapter(productAdapter);
        rcvProduct.setLayoutManager(new GridLayoutManager(this, 2));

    }
}