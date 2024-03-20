package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Database_Func dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dbhandler = new Database_Func(MainActivity.this);
         dbhandler.addUser("test", "test", "test");
         dbhandler.addMood("happy", null, 1);
        //test
    }
}