package com.example.mymovieapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mymovieapp.databinding.ActivityPushNotificationsBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PushNotificationsActivity extends AppCompatActivity {

    private ActivityPushNotificationsBinding activityPushNotificationsBinding;
    RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    RecyclerAdapter adapter;
    DatabaseReference mbase;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPushNotificationsBinding = ActivityPushNotificationsBinding.inflate(getLayoutInflater());
        View view = activityPushNotificationsBinding.getRoot();
        setContentView(view);

        mbase = FirebaseDatabase.getInstance().getReference();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a query in the database to fetch appropriate data
        FirebaseRecyclerOptions<NotificationModal> options
                = new FirebaseRecyclerOptions.Builder<NotificationModal>()
                .setQuery(mbase, NotificationModal.class)
                .build();
        // Connecting object of required Adapter class to the Adapter class itself
        adapter = new RecyclerAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
    }

    // Function to tell the app to start getting data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting data from database on stopping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}