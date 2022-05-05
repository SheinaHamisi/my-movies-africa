package com.example.mymovieapp;

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

public class RecyclerAdapter extends FirebaseRecyclerAdapter<
        NotificationModal, RecyclerAdapter.notificationViewholder> {

    public RecyclerAdapter(
            @NonNull FirebaseRecyclerOptions<NotificationModal> options)
    {
        super(options);
    }


    @Override
    protected void
    onBindViewHolder(@NonNull notificationViewholder holder,
                     int position, @NonNull NotificationModal model)
    {

        holder.title.setText(model.getTitle());

        holder.text.setText(model.getText());

    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public notificationViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row, parent, false);
        return new RecyclerAdapter.notificationViewholder(view);
    }


    class notificationViewholder
            extends RecyclerView.ViewHolder {
        TextView title, text;
        public notificationViewholder(@NonNull View itemView)
        {
            super(itemView);

            title
                    = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);

        }
    }
}
