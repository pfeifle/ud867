package com.example.lib_androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity_AndroidJokeLib extends AppCompatActivity {
    TextView tv_jokeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_lib_activity_main);

        tv_jokeDisplay = findViewById(R.id.tv_jokedisplay);

        Intent intent = getIntent();
        if (intent.hasExtra("JOKE")) {
            String s=intent.getStringExtra("JOKE");
            tv_jokeDisplay.setText(s);
        }

    }
}