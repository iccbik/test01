package com.ccbik.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("life cycle", "onCreate()...");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life cycle", "onStart()...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life cycle", "onResum()...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life cycle", "onPause()...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life cycle", "onStop()...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life cycle", "onDestroy()...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life cycle", "onRestart()...");
    }
}