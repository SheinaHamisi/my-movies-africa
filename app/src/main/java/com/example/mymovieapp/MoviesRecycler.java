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
    List<Integer> image;
    List<Integer> description;
    Context context;
    private final detailInterface DetailInterface;

    public MoviesRecycler(Context context,List<Integer> image,List<Integer> description,detailInterface DetailInterfaces) {
        this.image = image;
        this.context = context;
        this.description  = description;
        this.DetailInterface= DetailInterfaces;
    }

    @NonNull
    @Override
    public MoviesRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.random,parent,false);
        return new MoviesRecycler.MyViewHolder(view,DetailInterface);
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
        public MyViewHolder(@NonNull View itemView,detailInterface DetailInterfaces) {
            super(itemView);
            moviesImage = itemView.findViewById(R.id.movieImage);

            itemView.findViewById(R.id.movieImage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(DetailInterfaces != null){
                        int itemPosition = getAdapterPosition();

                        if(itemPosition != RecyclerView.NO_POSITION){
                            DetailInterfaces.onDetailButtonClick(itemPosition);
                        }
                    }
                }
            });

        }
    }
}

















