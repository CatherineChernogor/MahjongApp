package com.example.mahjongapp;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Tile implements Serializable {

    public String name;
    public Bitmap image;

    public Tile(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

}
