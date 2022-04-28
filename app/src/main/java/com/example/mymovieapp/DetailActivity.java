package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mymovieapp.databinding.ActivityDetailBinding;
import com.example.mymovieapp.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        int image = getIntent().getIntExtra("IMAGE",0);
        int description = getIntent().getIntExtra("DESCRIPTION",0);

        binding.imageView.setImageResource(image);
        binding.textView2.setText(description);
    }
}
















