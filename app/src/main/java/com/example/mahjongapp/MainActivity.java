package com.example.mahjongapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button handModeBtn;
    ImageView imageView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handModeBtn = findViewById(R.id.handModeBtn);
        imageView = findViewById(R.id.image);
        context = getApplicationContext();


    }

    public void onClick(View v) {
        if (v.getId() == R.id.handModeBtn)
            openCarouselView();
    }

    private void openCarouselView() {
        Intent intent = new Intent(MainActivity.this, CarouselActivity.class);

        startActivity(intent);
    }

}