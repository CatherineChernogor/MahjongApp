package com.example.mahjongapp.data;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Tile implements Serializable {

    public String name;
    public Bitmap image;
    public String label;
    public int id;

    public Tile(String name, Bitmap image) {
        this.name = name;
        this.image = image;
        this.label = getLabel(name);
        this.id = getId(name);
    }

    @Override
    public String toString() {
        return "Tile{" +
                "name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", id=" + id +
                '}';
    }

    private String getLabel(String name) {
        if (name.contains("man")) return "man";
        if (name.contains("pin")) return "pin";
        if (name.contains("sou")) return "sou";
        if (name.contains("chun") || name.contains("haku") || name.contains("hatsu"))
            return "dragon";
        if (name.contains("nan") || name.contains("pei")
                || name.contains("shaa") || name.contains("ton"))
            return "wind";
        return null;
    }

    private int getId(String name) {

        if (name.equals("chun")) return 0;
        if (name.equals("haku")) return 1;
        if (name.equals("hatsu")) return 2;

        if (name.equals("nan")) return 3;
        if (name.equals("pei")) return 4;
        if (name.equals("shaa")) return 5;
        if (name.equals("ton")) return 6;

        if (this.label.equals("man")) return 6 + name.charAt(name.length() - 1) - '0';
        if (this.label.equals("pin")) return 15 + name.charAt(name.length() - 1) - '0';
        if (this.label.equals("sou")) return 24 + name.charAt(name.length() - 1) - '0';

        return -1;
    }

}
