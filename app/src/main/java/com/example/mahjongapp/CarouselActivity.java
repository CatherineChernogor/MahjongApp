package com.example.mahjongapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarouselActivity extends AppCompatActivity implements CarouselViewHolder.OnTileListener {

    ArrayList<Tile> selectedTiles;
    ArrayList<Tile> carouselTiles;
    int nSelectedTiles = 13;
    RecyclerView recyclerView;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);

        carouselTiles = new ArrayList<>();
        selectedTiles = new ArrayList<>();
        loadCarouselTiles();

        recyclerView = findViewById(R.id.carousel);
        statusTextView = findViewById(R.id.text2);
        statusTextView.setText(String.format("%s%s", 0, getString(R.string.text3)));


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        CarouselAdapter adapter = new CarouselAdapter(getLayoutInflater(), this);
        adapter.submitList(carouselTiles);


        recyclerView.setAdapter(adapter);
    }


    private Bitmap loadBitmap(int imgRes) {
        return BitmapFactory.decodeResource(getResources(), imgRes);
    }

    //Todo: refactor this
    private void loadCarouselTiles() {

        carouselTiles.add(new Tile("hatsu", loadBitmap(R.raw.hatsu)));
        carouselTiles.add(new Tile("haku", loadBitmap(R.raw.haku)));
        carouselTiles.add(new Tile("ton", loadBitmap(R.raw.ton)));
        carouselTiles.add(new Tile("shaa", loadBitmap(R.raw.shaa)));
        carouselTiles.add(new Tile("pei", loadBitmap(R.raw.pei)));
        carouselTiles.add(new Tile("chun", loadBitmap(R.raw.chun)));
        carouselTiles.add(new Tile("nan", loadBitmap(R.raw.nan)));


        carouselTiles.add(new Tile("man1", loadBitmap(R.raw.man1)));
        carouselTiles.add(new Tile("man2", loadBitmap(R.raw.man2)));
        carouselTiles.add(new Tile("man3", loadBitmap(R.raw.man3)));
        carouselTiles.add(new Tile("man4", loadBitmap(R.raw.man4)));
        carouselTiles.add(new Tile("man5", loadBitmap(R.raw.man5)));
        carouselTiles.add(new Tile("man6", loadBitmap(R.raw.man6)));
        carouselTiles.add(new Tile("man7", loadBitmap(R.raw.man7)));
        carouselTiles.add(new Tile("man8", loadBitmap(R.raw.man8)));
        carouselTiles.add(new Tile("man9", loadBitmap(R.raw.man9)));

        carouselTiles.add(new Tile("sou1", loadBitmap(R.raw.sou1)));
        carouselTiles.add(new Tile("sou2", loadBitmap(R.raw.sou2)));
        carouselTiles.add(new Tile("sou3", loadBitmap(R.raw.sou3)));
        carouselTiles.add(new Tile("sou4", loadBitmap(R.raw.sou4)));
        carouselTiles.add(new Tile("sou5", loadBitmap(R.raw.sou5)));
        carouselTiles.add(new Tile("sou6", loadBitmap(R.raw.sou6)));
        carouselTiles.add(new Tile("sou7", loadBitmap(R.raw.sou7)));
        carouselTiles.add(new Tile("sou8", loadBitmap(R.raw.sou8)));
        carouselTiles.add(new Tile("sou9", loadBitmap(R.raw.sou9)));

        carouselTiles.add(new Tile("pin1", loadBitmap(R.raw.pin1)));
        carouselTiles.add(new Tile("pin2", loadBitmap(R.raw.pin2)));
        carouselTiles.add(new Tile("pin3", loadBitmap(R.raw.pin3)));
        carouselTiles.add(new Tile("pin4", loadBitmap(R.raw.pin4)));
        carouselTiles.add(new Tile("pin5", loadBitmap(R.raw.pin5)));
        carouselTiles.add(new Tile("pin6", loadBitmap(R.raw.pin6)));
        carouselTiles.add(new Tile("pin7", loadBitmap(R.raw.pin7)));
        carouselTiles.add(new Tile("pin8", loadBitmap(R.raw.pin8)));
        carouselTiles.add(new Tile("pin9", loadBitmap(R.raw.pin9)));


    }

    @Override
    public void onTileClick(int position) {
        if (selectedTiles.size() < nSelectedTiles) {
            selectedTiles.add(carouselTiles.get(position));
            statusTextView.setText(String.format("%s%s", selectedTiles.size(), getString(R.string.text3)));
            if (selectedTiles.size() == nSelectedTiles) {
                Log.d("mytag", "start new intent");
                Intent intent = new Intent(CarouselActivity.this, CheckActivity.class);
                intent.putExtra("selectedTiles", selectedTiles);

                startActivity(intent);
            }
        }
    }
}
