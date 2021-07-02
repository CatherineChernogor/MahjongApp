package com.example.mahjongapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mahjongapp.R;
import com.example.mahjongapp.Score;

public class ScoreActivity extends AppCompatActivity {

    TextView yaku;
    TextView han;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_score);

        yaku = findViewById(R.id.found_yaku);
        han = findViewById(R.id.han_amount);

        String yakuStr = getIntent().getExtras().getString("found_yaku", "tsumo");
        int hanAmount = getIntent().getExtras().getInt("han_amount", 1);

        yaku.setText(String.format("%s %s", getString(R.string.found_yaku), yakuStr));
        han.setText(String.format("%s %s", getString(R.string.han_amount), hanAmount));

    }
}