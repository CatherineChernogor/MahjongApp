package com.example.mahjongapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahjongapp.R;
import com.example.mahjongapp.data.Tile;

import java.util.ArrayList;

public class TileListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Tile> tiles;

    public TileListAdapter(Context ctx, ArrayList<Tile> tiles) {
        this.ctx = ctx;
        this.tiles = tiles;
    }

    @Override
    public int getCount() {
        return tiles.size();
    }

    @Override
    public Object getItem(int position) {
        return tiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tile t = tiles.get(position);

        convertView = LayoutInflater.from(ctx).
                inflate(R.layout.item_list, parent, false);

        ImageView imageView = convertView.findViewById(R.id.list_picture);
        TextView textView = convertView.findViewById(R.id.list_tile_name);

        textView.setText(t.name);
        imageView.setImageBitmap(t.image);

        return convertView;
    }
}
