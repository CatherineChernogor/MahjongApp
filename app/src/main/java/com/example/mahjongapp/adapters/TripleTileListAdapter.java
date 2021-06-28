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
import com.example.mahjongapp.data.Triple;

import java.util.ArrayList;

public class TripleTileListAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<Triple<Tile, Tile, Tile>> tiles;

    public TripleTileListAdapter(Context ctx, ArrayList<Triple<Tile, Tile, Tile>> tiles) {
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
        Triple<Tile, Tile, Tile> tt = tiles.get(i);
        Tile t1 = tt.getFirst();
        Tile t2 = tt.getSecond();
        Tile t3 = tt.getThird();

        view = LayoutInflater.from(ctx).
                inflate(R.layout.item_triple, viewGroup, false);

        ImageView imageView1 = view.findViewById(R.id.triple_list_picture1);
        ImageView imageView2 = view.findViewById(R.id.triple_list_picture2);
        ImageView imageView3 = view.findViewById(R.id.triple_list_picture3);
        TextView textView = view.findViewById(R.id.triple_list_tile_name);

        textView.setText(String.format("%s %s %s", t1.name, t2.name, t3.name));
        imageView1.setImageBitmap(t1.image);
        imageView2.setImageBitmap(t2.image);
        imageView3.setImageBitmap(t3.image);

        return view;
    }
}
