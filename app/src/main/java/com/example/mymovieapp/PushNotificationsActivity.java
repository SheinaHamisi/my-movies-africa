package com.example.mymovieapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mymovieapp.databinding.ActivityPushNotificationsBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PushNotificationsActivity extends AppCompatActivity {

    private ActivityPushNotificationsBinding activityPushNotificationsBinding;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPushNotificationsBinding = ActivityPushNotificationsBinding.inflate(getLayoutInflater());
        View view = activityPushNotificationsBinding.getRoot();
        setContentView(view);

        //recycler Constructor
        recyclerAdapter = new RecyclerAdapter();
        activityPushNotificationsBinding.recyclerView.setAdapter(recyclerAdapter);
        initUpdateNotification();//Calling the method


    }

    private void initUpdateNotification() {
        List<String> notificationName = new ArrayList<>();
        notificationName.add("Test");
        recyclerAdapter.updateNotificationName(notificationName);
    }


}