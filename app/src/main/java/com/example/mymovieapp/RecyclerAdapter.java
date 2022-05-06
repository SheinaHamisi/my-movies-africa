package com.example.mymovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovieapp.databinding.RecyclerRowBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<NotificationModal> notificationModalArrayList;
    private Context context;

    // constructor
    public RecyclerAdapter(ArrayList<NotificationModal> notificationModalArrayList, Context context) {
        this.notificationModalArrayList = notificationModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        NotificationModal modal = notificationModalArrayList.get(position);
        holder.title.setText(modal.getTitle());
        holder.text.setText(modal.getText());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return notificationModalArrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView title, text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);

        }
    }
}