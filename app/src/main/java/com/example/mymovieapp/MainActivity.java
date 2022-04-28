package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymovieapp.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements detailInterface {
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    List<Integer> givenList = Arrays.asList(R.drawable.movies_1,R.drawable.movies_2,R.drawable.movies_3,R.drawable.movies_4, R.drawable.movies_5,R.drawable.movies_6);
    LinearLayoutManager HorizontalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.recyclerView;
        MoviesRecycler adapter = new MoviesRecycler(this,givenList,this);
        recyclerView.setAdapter(adapter);
        HorizontalLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        binding.randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(givenList);
                MoviesRecycler adapter = new MoviesRecycler(MainActivity.this,givenList,MainActivity.this);
                recyclerView.setAdapter(adapter);
                HorizontalLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(HorizontalLayout);
            }
        });
    }

    @Override
    public void onDetailButtonClick(int position) {
        Toast.makeText(MainActivity.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
    }
}























