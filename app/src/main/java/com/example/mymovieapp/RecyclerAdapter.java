package com.example.mymovieapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovieapp.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    List<String> notificationName = new ArrayList<>();

    //method to update disease names
    public void updateNotificationName(List<String> notificationName){
        this.notificationName = notificationName;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(recyclerRowBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(notificationName.get(position));
    }

    @Override
    public int getItemCount() {
        return notificationName.size();
    }

    //View holder
    class ViewHolder extends RecyclerView.ViewHolder {

        //Constructor for the ViewHolder
        private RecyclerRowBinding recyclerRowBinding;

        public ViewHolder(@NonNull RecyclerRowBinding recyclerRowBinding){
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
        //Bind object to recycler view
        public void bindView(String notificationName){
            recyclerRowBinding.notificationTextView.setText(notificationName);
        }

    }
}
