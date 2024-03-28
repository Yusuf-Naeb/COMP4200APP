package com.example.comp4200group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//This is the main activity for History activity
public class History extends AppCompatActivity {
    RecyclerView recyclerView;
    Database_Func dbhandler;
    Button btn_back;
    ArrayList<Mood_His> dataSets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.his_main);
        btn_back = findViewById(R.id.button_back);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        dbhandler = new Database_Func(History.this);

        dataSets = dbhandler.getMoodHist(1);

        //For testing, only need to test with database
//        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Angry", "Sad", "XXXX-XX-XX"));
//        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Sad", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Sad", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Anxious", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(2,2, "Happy", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Overworked", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Balance", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Love", "Sad", "2024-03-22"));
//        dataSets.add(new Mood_His(1,1, "Sad", "Sad", "2024-03-22"));


        HistoryAdapter myAdapter = new HistoryAdapter(dataSets, History.this);
        recyclerView.setAdapter(myAdapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, MoodInput.class);        //should replace with the main activity or smt
                startActivity(intent);
            }
        });
    }
}
