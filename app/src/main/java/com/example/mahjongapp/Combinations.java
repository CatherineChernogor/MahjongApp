package com.example.mahjongapp;

import android.util.Pair;

import com.example.mahjongapp.activities.CarouselActivity;
import com.example.mahjongapp.data.Tile;
import com.example.mahjongapp.data.Triple;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {

    ArrayList<Tile> tiles;
    ArrayList<Pair<Tile, Tile>> pairTiles;
    ArrayList<Triple<Tile, Tile, Tile>> ponTiles;
    ArrayList<Triple<Tile, Tile, Tile>> chiTiles;


    public Combinations(ArrayList<Integer> tiles) {
        Collections.sort(tiles);
        this.tiles = convertToTileList(tiles);
        findRepeatedTiles();
        findChiTiles();
    }


    public static ArrayList<Tile> convertToTileList(ArrayList<Integer> selectedTileIds) {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int index : selectedTileIds) {
            tiles.add(CarouselActivity.carouselTiles.get(index));
        }
        return tiles;
    }

    public static ArrayList<Pair<Tile, Tile>> convertToPairTileList(ArrayList<Pair<Integer, Integer>> pairListIds) {
        ArrayList<Pair<Tile, Tile>> tiles = new ArrayList<>();
        for (Pair<Integer, Integer> pair : pairListIds) {
            Tile t1 = CarouselActivity.carouselTiles.get(pair.first);
            Tile t2 = CarouselActivity.carouselTiles.get(pair.second);
            tiles.add(new Pair<>(t1, t2));
        }
        return tiles;
    }

    public static ArrayList<Pair<Integer, Integer>> convertToPairIntegerList(ArrayList<Pair<Tile, Tile>> pairs) {
        ArrayList<Pair<Integer, Integer>> tiles = new ArrayList<>();
        for (Pair<Tile, Tile> pair : pairs) {
            tiles.add(new Pair<>(pair.first.id, pair.second.id));
        }
        return tiles;
    }

    public static ArrayList<Triple<Tile, Tile, Tile>> convertToTripleTileList(ArrayList<Triple<Integer, Integer, Integer>> ponListIds) {
        ArrayList<Triple<Tile, Tile, Tile>> tiles = new ArrayList<>();
        for (Triple<Integer, Integer, Integer> triple : ponListIds) {
            Tile t1 = CarouselActivity.carouselTiles.get(triple.getFirst());
            Tile t2 = CarouselActivity.carouselTiles.get(triple.getSecond());
            Tile t3 = CarouselActivity.carouselTiles.get(triple.getThird());
            tiles.add(new Triple<>(t1, t2, t3));
        }
        return tiles;
    }

    public static ArrayList<Triple<Integer, Integer, Integer>> convertToTripleIntegerList(ArrayList<Triple<Tile, Tile, Tile>> triples) {
        ArrayList<Triple<Integer, Integer, Integer>> tiles = new ArrayList<>();
        for (Triple<Tile, Tile, Tile> triple : triples) {
            tiles.add(new Triple<>(triple.getFirst().id, triple.getSecond().id, triple.getThird().id));
        }
        return tiles;
    }


    private void findRepeatedTiles() {

        pairTiles = new ArrayList<>();
        ponTiles = new ArrayList<>();
        for (int i = 0; i < tiles.size() - 2; i++) {

            if (tiles.get(i).id == tiles.get(i + 1).id) {           //if there's pair
                if (tiles.get(i + 2) != null) {                     // if third exists
                    if (tiles.get(i + 1).id == tiles.get(i + 2).id) {               // if third equals
                        ponTiles.add(new Triple<>(tiles.get(i), tiles.get(i + 1), tiles.get(i + 2)));
                        i++;
                        continue;
                    }
                }
                pairTiles.add(new Pair<>(tiles.get(i), tiles.get(i + 1)));
            }
        }

    }

    private void findChiTiles() {
        chiTiles = new ArrayList<>();
        for (int i = 0; i < tiles.size() - 2; i++) {
            Tile t1 = tiles.get(i);
            Tile t2 = tiles.get(i + 1);
            Tile t3 = tiles.get(i + 2);

            if (t1.label == t2.label && t2.label == t3.label) {           //if same label
                double sum = t1.id + 2 + t2.id + 1 + t3.id;
                sum /= 3;
                if (sum == t3.id) {
                    chiTiles.add(new Triple<>(t1, t2, t3));
                    i++;
                }
            }
        }
    }

    public ArrayList<Pair<Integer, Integer>> getPairList() {
        return convertToPairIntegerList(pairTiles);
    }


    public ArrayList<Triple<Integer, Integer, Integer>> getPonList() {
        return convertToTripleIntegerList(ponTiles);
    }


    public ArrayList<Triple<Integer, Integer, Integer>> getChiList() {
        return convertToTripleIntegerList(chiTiles);
    }
}
