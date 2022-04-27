package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mymovieapp.databinding.ActivityPushNotificationsBinding;

public class PushNotificationsActivity extends AppCompatActivity {

    private ActivityPushNotificationsBinding activityPushNotificationsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPushNotificationsBinding = ActivityPushNotificationsBinding.inflate(getLayoutInflater());
        View view = activityPushNotificationsBinding.getRoot();
        setContentView(view);
    }
}