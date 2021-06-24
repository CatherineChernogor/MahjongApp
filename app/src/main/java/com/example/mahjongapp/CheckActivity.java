package com.example.mahjongapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckActivity extends AppCompatActivity {

    ArrayList<Integer> selectedTileIds;
    ArrayList<Tile> tiles;

    ListView listView;
    TileListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        listView = findViewById(R.id.checkListView);

        selectedTileIds = new ArrayList<>();
        selectedTileIds = (ArrayList<Integer>) getIntent().getSerializableExtra("selectedTilesExtra");

        tiles = new ArrayList<>();
        for (int index : selectedTileIds) {
            tiles.add(CarouselActivity.carouselTiles.get(index));
        }

        adapter = new TileListAdapter(this, tiles);
        listView.setAdapter(adapter);
    }

    public void OnClick(View v) {
        Log.d("mytag", "OnClick: count pairs");
    }
}
