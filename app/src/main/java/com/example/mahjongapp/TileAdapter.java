package com.example.mahjongapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class TileAdapter extends SimpleAdapter {


    public TileAdapter(Context context, List<Tile> data, int resource, String[] from, int[] to) {
        super(context, (List<? extends Map<String, ?>>) data, resource, from, to);
    }
}
