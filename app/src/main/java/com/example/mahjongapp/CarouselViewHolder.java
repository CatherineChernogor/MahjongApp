package com.example.mahjongapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView textView;
    ImageView imageView;
    Context context;
    OnTileListener onTileListener;

    public CarouselViewHolder(@NonNull View itemView, OnTileListener onTileListener) {
        super(itemView);
        textView = itemView.findViewById(R.id.carousel_tile_name);
        imageView = itemView.findViewById(R.id.carousel_picture);
        context = itemView.getContext();
        this.onTileListener = onTileListener;
        itemView.setOnClickListener(this);
    }


    void bindTo(Tile tile) {
        imageView.setImageBitmap(tile.image);
        textView.setText("name: " + tile.name);
    }

    @Override
    public void onClick(View view) {
        onTileListener.onTileClick(getAbsoluteAdapterPosition());
    }

    public interface OnTileListener {
        void onTileClick(int position);
    }

}