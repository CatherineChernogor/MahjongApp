package com.example.mahjongapp;

import com.example.mahjongapp.activities.CombinationsActivity;
import com.example.mahjongapp.data.Yaku;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Score {

    ArrayList<Yaku> yakuList;
    Combinations cmb;

    public Score(Combinations cmb, CombinationsActivity activity) {
        this.cmb = cmb;
        this.yakuList = loadYakuList(activity);
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


    private void searchForYaku() {

        hasChitoitsu();
        hasToitoi();

        // Todo: add more
    }

    private Yaku findYaku(String name) {
        for (Yaku yaku : this.yakuList) {
            if (yaku.name.equals(name)) return yaku;
        }
        return null;
    }

    private void hasToitoi() {
        if (cmb.pairTiles.size() >= 1 && cmb.ponTiles.size() >= 4) yakuList.add(findYaku("toitoi"));
    }

    private void hasChitoitsu() {
        if (cmb.pairTiles.size() == 7) yakuList.add(findYaku("chitoitsu"));
    }


}
