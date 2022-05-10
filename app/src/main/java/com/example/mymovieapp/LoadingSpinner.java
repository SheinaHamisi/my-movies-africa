package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.mymovieapp.databinding.ActivityLoadingSpinnerBinding;

public class LoadingSpinner extends AppCompatActivity {

    LottieAnimationView lottie;
    private ActivityLoadingSpinnerBinding activityLoadingSpinnerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoadingSpinnerBinding = ActivityLoadingSpinnerBinding.inflate(getLayoutInflater());
        View view = activityLoadingSpinnerBinding.getRoot();
        setContentView(view);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activityLoadingSpinnerBinding.load.animate().translationY(2000).setDuration(1000).setStartDelay(5000);
        activityLoadingSpinnerBinding.lottie.animate().translationY(1500).setDuration(1000).setStartDelay(5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(LoadingSpinner.this, PushNotificationsActivity.class));
                finish();

            }
        },6000);
    }
    }
