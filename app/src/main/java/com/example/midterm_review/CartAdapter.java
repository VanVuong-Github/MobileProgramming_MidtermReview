package com.example.midterm_review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    List<CartItem> cartItems;
    LayoutInflater inflater;

    public CartAdapter(Context context, List<CartItem> cartItems) {
        this.inflater = LayoutInflater.from(context);
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        holder.tvName.setText(item.getProduct().getName());
        holder.tvPrice.setText("$" + item.getProduct().getPrice());
        holder.img.setImageResource(item.getProduct().getImg());
        holder.tvQuantity.setText(""+item.getQuantity());
        holder.imbInc.setBackgroundResource(R.drawable.plus);
        holder.imbSub.setBackgroundResource(R.drawable.minus);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
    public class CartViewHolder extends RecyclerView.ViewHolder {
        CartAdapter cartAdapter;
        TextView tvName, tvPrice, tvQuantity;
        ImageView img;
        ImageButton imbSub, imbInc;
        public CartViewHolder(@NonNull View itemView, CartAdapter adapter) {
            super(itemView);
            this.cartAdapter = adapter;
            tvName = itemView.findViewById(R.id.tv_cartitem_name);
            tvPrice = itemView.findViewById(R.id.tv_cartitem_price);
            tvQuantity = itemView.findViewById(R.id.tv_cartitem_quantity);
            img = itemView.findViewById(R.id.img_cartitem);
            imbInc = itemView.findViewById(R.id.imb_cartitem_increase);
            imbSub = itemView.findViewById(R.id.imb_cartitem_sub);
        }
    }
}
