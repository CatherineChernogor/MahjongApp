package com.example.mahjongapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mahjongapp.Combinations;
import com.example.mahjongapp.R;
import com.example.mahjongapp.data.Tile;
import com.example.mahjongapp.adapters.TileListAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class CheckActivity extends AppCompatActivity {

    static ArrayList<Integer> selectedTileIds;

    ListView listView;
    TileListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_check);

        listView = findViewById(R.id.checkListView);

        selectedTileIds = new ArrayList<>();
        selectedTileIds = (ArrayList<Integer>) getIntent().getSerializableExtra("selectedTilesExtra");

        assert selectedTileIds != null;
        adapter = new TileListAdapter(this, Combinations.convertToTileList(selectedTileIds));
        listView.setAdapter(adapter);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.GoBackBtn) {
            Intent intent = new Intent(CheckActivity.this, CarouselActivity.class);
            startActivity(intent);
        } else {

            Collections.sort(selectedTileIds);

            Intent intent = new Intent(CheckActivity.this, CombinationsActivity.class);
            // intent.putIntegerArrayListExtra("selectedTilesExtra", selectedTileIds);

            startActivity(intent);
        }
    }
}
