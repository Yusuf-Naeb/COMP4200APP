package com.example.my_his;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Database_Func dbhandler;
    ArrayList<Mood_His> dataSets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //dbhandler = new Database_Func(MainActivity.this);

        //dataSets = dbhandler.getMoodHist(id);

        //For testing, only need to test with database
        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Angry", "Sad", "XXXX-XX-XX"));
        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Sad", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Sad", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Anxious", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Overworked", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Balance", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Love", "Sad", "2024-03-22"));
        dataSets.add(new Mood_His(1,1, "Sad", "Sad", "2024-03-22"));


        CalendarAdapter myAdapter = new CalendarAdapter(dataSets, MainActivity.this);
        recyclerView.setAdapter(myAdapter);
    }
}