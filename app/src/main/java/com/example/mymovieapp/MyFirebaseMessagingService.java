package com.example.mymovieapp;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.mymovieapp.databinding.ActivityPushNotificationsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private DBHandler dbHandler;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private NotificationModal notificationModal;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        String title = message.getNotification().getTitle();
        Looper.prepare();
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        String text = message.getNotification().getBody();
        final String CHANNEL_ID = "HEADS_UP_NOTIFICATION";

        firebaseDatabase = FirebaseDatabase.getInstance();

        //firebase db
        databaseReference = firebaseDatabase.getReference("Notification");
        notificationModal = new NotificationModal(title, text);


        dbHandler = new DBHandler(MyFirebaseMessagingService.this);
        //add data to sqlite
        dbHandler.addNewNotification("title","text");


        addDatatoFirebase(title, text);
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,"Heads Up Notification", NotificationManager.IMPORTANCE_HIGH
        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.mymovies)
                .setAutoCancel(true);
        NotificationManagerCompat.from(this).notify(1, notification.build());

        super.onMessageReceived(message);


    }

    // Method to get the custom Design for the display of notification.
    private RemoteViews getCustomDesign(String title, String text) {
        RemoteViews remoteViews = new RemoteViews(
                getApplicationContext().getPackageName(),
                R.layout.notifications);
        remoteViews.setTextViewText(R.id.title, title);
        remoteViews.setTextViewText(R.id.text, text);
        remoteViews.setImageViewResource(R.id.app_logo, R.drawable.mymovies);

        return  remoteViews;
    }

    private void addDatatoFirebase(String title, String text) {
        notificationModal.setTitle(title);
        notificationModal.setText(text);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(title).setValue(notificationModal);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}