package com.example.mahjongapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckActivity extends AppCompatActivity {

    ArrayList<Tile> selectedTiles;
    ListView listView;
    TileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        listView = findViewById(R.id.checkListView);

        Intent intent = getIntent();
        selectedTiles = (ArrayList<Tile>) intent.getSerializableExtra("taskItems");


        adapter = new TileAdapter(this,selectedTiles, R.layout.item_list, new String[]{"img", "name"},
                new int[]{R.id.list_picture, R.id.list_tile_name});
        listView.setAdapter(adapter);
    }
}
