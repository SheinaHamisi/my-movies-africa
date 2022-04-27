package com.example.mymovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoviesRecycler extends RecyclerView.Adapter<MoviesRecycler.MyViewHolder> {
    //private int[] image;
    List<Integer> image;
    Context context;

    public MoviesRecycler(Context context,List<Integer> image) {
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.random,parent,false);
        return new MoviesRecycler.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecycler.MyViewHolder holder, int position) {
        holder.moviesImage.setImageResource(image.get(position));
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView moviesImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            moviesImage = itemView.findViewById(R.id.movieImage);
        }
    }
}

















