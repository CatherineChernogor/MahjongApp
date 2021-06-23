package com.example.mahjongapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class CarouselAdapter extends ListAdapter<Tile, CarouselViewHolder> {
    LayoutInflater inflater;
    CarouselViewHolder.OnTileListener mOnTileListener;

    protected CarouselAdapter(LayoutInflater inflater, CarouselViewHolder.OnTileListener onTileListener) {
        super(DIFF_CALLBACK); // задаём специальный объект-сравниватель
        this.inflater = inflater;
        this.mOnTileListener = onTileListener;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // создать View с разметкой
        View item = inflater.inflate(R.layout.item_carousel, parent, false);
        return new CarouselViewHolder(item, mOnTileListener);
    }


    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        // привязать данные
        holder.bindTo(getItem(position));
    }

    // объект сравнивает два элемента списка: буквально и по содержанию
    static final DiffUtil.ItemCallback<Tile> DIFF_CALLBACK = new DiffUtil.ItemCallback<Tile>() {
        @Override
        public boolean areItemsTheSame(@NonNull Tile oldTile, @NonNull Tile newTile) {
            return oldTile.equals(newTile);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tile oldTile, @NonNull Tile newTile) {
            return areItemsTheSame(oldTile, newTile);
        }
    };

}
