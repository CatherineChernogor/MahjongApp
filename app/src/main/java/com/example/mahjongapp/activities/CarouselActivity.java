package com.example.mahjongapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mahjongapp.R;
import com.example.mahjongapp.adapters.CarouselAdapter;
import com.example.mahjongapp.adapters.CarouselViewHolder;
import com.example.mahjongapp.data.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarouselActivity extends AppCompatActivity implements CarouselViewHolder.OnTileListener {

    public static ArrayList<Tile> carouselTiles;

    ArrayList<Integer> selectedTileIds;
    int nSelectedTiles = 14;
    RecyclerView recyclerView;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_carousel);

        carouselTiles = new ArrayList<>();
        selectedTileIds = new ArrayList<>();
        selectedTileIds.add(27);
        selectedTileIds.add(28);
        selectedTileIds.add(29);
        selectedTileIds.add(1);
        selectedTileIds.add(1);
        selectedTileIds.add(1);
        selectedTileIds.add(20);
        selectedTileIds.add(21);
        selectedTileIds.add(22);
        selectedTileIds.add(7);
        selectedTileIds.add(8);
        selectedTileIds.add(9);
        selectedTileIds.add(0);


        loadCarouselTiles();

        recyclerView = findViewById(R.id.carousel);
        statusTextView = findViewById(R.id.text2);
        statusTextView.setText(String.format("%s%s", selectedTileIds.size(), getString(R.string.text3)));


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

        Collections.sort(carouselTiles, new Comparator<Tile>() {
            @Override
            public int compare(Tile tile, Tile t1) {
                return Integer.compare(tile.id, t1.id);
            }
        });
    }

    @Override
    public void onTileClick(int position) {
        if (selectedTileIds.size() < nSelectedTiles) {
            selectedTileIds.add(position);
            statusTextView.setText(String.format("%s%s", selectedTileIds.size(), getString(R.string.text3)));

            if (selectedTileIds.size() == nSelectedTiles) {

                Collections.sort(selectedTileIds);

                Intent intent = new Intent(CarouselActivity.this, CheckActivity.class);
                intent.putIntegerArrayListExtra("selectedTilesExtra", selectedTileIds);

                startActivity(intent);
            }
        }
    }
}
