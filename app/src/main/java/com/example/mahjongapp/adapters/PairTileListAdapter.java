package com.example.mahjongapp.adapters;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahjongapp.R;
import com.example.mahjongapp.data.Tile;

import java.util.ArrayList;

public class PairTileListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Pair<Tile, Tile>> tiles;

    public PairTileListAdapter(Context ctx, ArrayList<Pair<Tile, Tile>> tiles) {
        this.ctx = ctx;
        this.tiles = tiles;
    }

    @Override
    public int getCount() {
        return tiles.size();
    }

    @Override
    public Object getItem(int i) {
        return tiles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Pair<Tile, Tile> tp = tiles.get(i);
        Tile t1 = tp.first;
        Tile t2 = tp.second;

        view = LayoutInflater.from(ctx).
                inflate(R.layout.item_pair, viewGroup, false);

        ImageView imageView1 = view.findViewById(R.id.pair_list_picture1);
        ImageView imageView2 = view.findViewById(R.id.pair_list_picture2);
        TextView textView = view.findViewById(R.id.pair_list_tile_name);

        textView.setText(String.format("%s pair", t1.name));
        imageView1.setImageBitmap(t1.image);
        imageView2.setImageBitmap(t2.image);

        return view;
    }
}
