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
    private ArrayList<NotificationModal> notificationModalArrayList;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPushNotificationsBinding = ActivityPushNotificationsBinding.inflate(getLayoutInflater());
        View view = activityPushNotificationsBinding.getRoot();
        setContentView(view);

        notificationModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(PushNotificationsActivity.this);

        notificationModalArrayList = dbHandler.readNotifications();
        recyclerAdapter = new RecyclerAdapter(notificationModalArrayList,PushNotificationsActivity.this);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PushNotificationsActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerAdapter);
    }

}