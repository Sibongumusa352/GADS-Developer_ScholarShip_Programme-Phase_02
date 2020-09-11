package com.example.gads;

import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class HelloWorld extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HelloWorld.this, MainActivity.class));
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {
    }
}
