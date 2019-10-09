package com.example.androidappicon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //bươc 1: tải ảnh
    //    bước 2: mip map -> rightclick -> new -> image asset -> chọn dường dẫn - > ok
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
