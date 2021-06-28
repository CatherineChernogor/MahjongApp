package com.example.mahjongapp.data;

public class Yaku {

    public String name;
    public int openCost;
    public int closeCost;

    public Yaku(String name, int openCost, int closeCost) {
        this.name = name;
        this.openCost = openCost;
        this.closeCost = closeCost;
    }
}

//            sanshoku, //три схожих чи каждой масти
//            ittsuu, //три последовательных чи
//            iipeikou, //два идентичных чи
//            ryanpeikou, //два иппейко
//
//            tanyao, //все средние тайлы
//            yakuhai, //пон (или кан) драконов или ветров места/раунда
//            chanta, //все сеты и пара содержат хотя бы один не средний тайл
//            junchan, //все сеты и пара содержат хотя бы один терминал
//
//            honitsu, //рука из одной масти и тайлов ветров/драконов
//            chinitsu, // рука из чистой масти
//
//            pinfu, // плоская **закрытая** рука без дополнительных минипоинтов
//
//            toitoi, // все поны
//            chitoitsu, //семь разных пар

