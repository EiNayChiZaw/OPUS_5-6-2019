package com.sakebakery.opus;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
public class startscreen extends AppCompatActivity {
    private static int TIME_OUT = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(startscreen.this,UserFilter.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

    }
}
