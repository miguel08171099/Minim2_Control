package com.vogella.android.minim2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 4000);//La splash activity espera 4000 ms --> 3s
    }
}