package com.example.mahjongapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Button takePictureBtn;
    ImageView imageView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takePictureBtn = findViewById(R.id.takePictureBtn);
        imageView = findViewById(R.id.image);
        context = getApplicationContext();


    }

    public void onClick(View v) {
        openCarouselView();
    }

    private void openCarouselView() {
        Intent intent = new Intent(MainActivity.this, CarouselActivity.class);

        startActivity(intent);
    }

}