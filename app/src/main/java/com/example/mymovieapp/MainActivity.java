package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mymovieapp.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    List<Integer> givenList = Arrays.asList(R.drawable.movies_1,R.drawable.movies_2,R.drawable.movies_3,R.drawable.movies_4,R.drawable.movies_5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = binding.recyclerView;
        MoviesRecycler adapter = new MoviesRecycler(this,givenList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                Integer randomElement = givenList.get(random.nextInt(givenList.size()));
//                binding.imageView.setImageResource(randomElement);
//                binding.imageView2.setImageResource(randomElement);
                Toast.makeText(MainActivity.this,randomElement.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}













