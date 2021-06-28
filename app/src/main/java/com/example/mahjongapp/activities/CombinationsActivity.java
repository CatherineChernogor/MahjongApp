package com.example.mahjongapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.widget.ListView;

import com.example.mahjongapp.Combinations;
import com.example.mahjongapp.R;
import com.example.mahjongapp.adapters.PairTileListAdapter;
import com.example.mahjongapp.adapters.TileListAdapter;
import com.example.mahjongapp.adapters.TripleTileListAdapter;
import com.example.mahjongapp.data.Tile;
import com.example.mahjongapp.data.Triple;

import java.util.ArrayList;

public class CombinationsActivity extends AppCompatActivity {

    ListView pairListView;
    ListView ponListView;
    ListView chiListView;

    PairTileListAdapter pairAdapter;
    TripleTileListAdapter ponAdapter;
    TripleTileListAdapter chiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_combinations);

        pairListView = findViewById(R.id.pairList);
        ponListView = findViewById(R.id.ponList);
        chiListView = findViewById(R.id.chiList);

        Combinations cmb = new Combinations(CheckActivity.selectedTileIds);

        ArrayList<Pair<Integer, Integer>> pairListIds = cmb.getPairList();
        ArrayList<Triple<Integer, Integer, Integer>> ponListIds = cmb.getPonList();
        ArrayList<Triple<Integer, Integer, Integer>> chiListIds = cmb.getChiList();

        pairAdapter = new PairTileListAdapter(this, Combinations.convertToPairTileList(pairListIds));
        ponAdapter = new TripleTileListAdapter(this, Combinations.convertToTripleTileList(ponListIds));
        chiAdapter = new TripleTileListAdapter(this, Combinations.convertToTripleTileList(chiListIds));

        pairListView.setAdapter(pairAdapter);
        ponListView.setAdapter(ponAdapter);
        chiListView.setAdapter(chiAdapter);

    }
}