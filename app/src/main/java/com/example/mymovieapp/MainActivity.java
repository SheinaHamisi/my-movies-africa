package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymovieapp.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements detailInterface {
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    List<Integer> givenDescription = Arrays.asList(R.string.movie1,R.string.movie2,R.string.movie3,R.string.movie4,R.string.movie5,R.string.movie6);
    List<Integer> givenList = Arrays.asList(R.drawable.movies_1,R.drawable.movies_2,R.drawable.movies_3,R.drawable.movies_4, R.drawable.movies_5,R.drawable.movies_6);
    LinearLayoutManager HorizontalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.recyclerView;
        MoviesRecycler adapter = new MoviesRecycler(this,givenList,givenDescription,this);
        recyclerView.setAdapter(adapter);
        HorizontalLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        binding.randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long seed = System.nanoTime();
                Collections.shuffle(givenList, new Random(seed));
                Collections.shuffle(givenDescription,new Random(seed));

                MoviesRecycler adapter = new MoviesRecycler(MainActivity.this,givenList,givenDescription,MainActivity.this);
                recyclerView.setAdapter(adapter);
                HorizontalLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(HorizontalLayout);
            }
        });
    }

    @Override
    public void onDetailButtonClick(int position) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra("IMAGE", givenList.get(position));
        intent.putExtra("DESCRIPTION", givenDescription.get(position));
        startActivity(intent);
    }
}























