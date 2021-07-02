package com.example.mahjongapp;

import android.util.Log;

import com.example.mahjongapp.activities.CombinationsActivity;
import com.example.mahjongapp.activities.ScoreActivity;
import com.example.mahjongapp.data.Tile;
import com.example.mahjongapp.data.Triple;
import com.example.mahjongapp.data.Yaku;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Score {

    ArrayList<Yaku> yakuList;
    public ArrayList<Yaku> foundYaku;
    Combinations cmb;

    public Score(Combinations cmb, CombinationsActivity activity) {
        this.cmb = cmb;
        this.yakuList = loadYakuList(activity);
        this.foundYaku = new ArrayList<>();
    }

    private ArrayList<Yaku> loadYakuList(CombinationsActivity activity) {

        Gson gson = new Gson();
        try {
            InputStream stream = activity.getAssets().open("yaku.json");
            Yaku[] arr = gson.fromJson(new InputStreamReader(stream), Yaku[].class);

            return new ArrayList<>(Arrays.asList(arr));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void searchForYaku() { // check if has any yaku

        hasChitoitsu();
        hasToitoi();
        hasYakuhai();
        hasTanyao();

        // Todo: add more
    }


    private Yaku findYaku(String name) { // find yaku in the loaded yaku list
        for (Yaku yaku : this.yakuList) {
            if (yaku.name.equals(name)) return yaku;
        }
        return null;
    }

    private void hasToitoi() {
        if (cmb.pairTiles.size() >= 1 && cmb.ponTiles.size() >= 4)
            foundYaku.add(findYaku("toitoi"));
    }

    private void hasChitoitsu() {
        if (cmb.pairTiles.size() == 7) foundYaku.add(findYaku("chitoitsu"));
    }

    private void hasTanyao() {
        for (Tile tile : cmb.tiles) {
            if (!hasMiddleTile(tile)) return;
        }
        foundYaku.add(findYaku("tanyao"));
    }

    private boolean hasMiddleTile(Tile tile) {
        if (!tile.label.equals("dragon") && !tile.label.equals("wind")) {
            String name = tile.name;
            int lastChar = Integer.parseInt(name.substring(name.length() - 1));
            return lastChar != 1 && lastChar != 9;
        }
        return false;
    }

    private void hasYakuhai() {
        for (Triple<Tile, Tile, Tile> pon : cmb.ponTiles) {
            if (pon.getFirst().label.equals("dragon") || pon.getFirst().label.equals("wind"))
                foundYaku.add(findYaku("yakuhai"));
        }
    }
}
