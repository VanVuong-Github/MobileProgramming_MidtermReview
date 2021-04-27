package com.example.midterm_review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetail extends AppCompatActivity {
    TextView tvName, tvPrice, tvProductDetail, tvTitle, tvQuantity;
    ImageButton imbSub, imbInc;
    ImageView imgProduct;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Bundle bundle =getIntent().getExtras();
        Product product = (Product) bundle.getSerializable("product");
        imgProduct = findViewById(R.id.imgProductDetail);
        tvName = findViewById(R.id.tvNameDetail);
        tvPrice = findViewById(R.id.tvPriceDetail);
        tvProductDetail = findViewById(R.id.tvProductDetail);
        tvTitle = findViewById(R.id.tvTitle);
        tvQuantity = findViewById(R.id.tvNum);
        imbSub = findViewById(R.id.imbSub);
        imbInc = findViewById(R.id.imbInc);
        btnAdd = findViewById(R.id.btnAdd);

        imgProduct.setImageResource(product.getImg());
        tvName.setText(product.getName());
        tvPrice.setText("$" + product.getPrice());
        tvQuantity.setText("1");
        tvTitle.setText("Product Detail");
        tvProductDetail.setText(product.toString());
        imbSub.setBackgroundResource(R.drawable.minus);
        imbSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvQuantity.getText().toString());
                if(i > 1)
                    i--;
                tvQuantity.setText("" + i);
            }
        });
        imbInc.setBackgroundResource(R.drawable.plus);
        imbInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvQuantity.getText().toString());
                i++;
                tvQuantity.setText("" + i);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProductDetail.this, Cart.class);
                Bundle bundle = new Bundle();
                CartItem cartItem = new CartItem(product, Integer.parseInt(tvQuantity.getText().toString()));
                bundle.putSerializable("cartItem",cartItem);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}