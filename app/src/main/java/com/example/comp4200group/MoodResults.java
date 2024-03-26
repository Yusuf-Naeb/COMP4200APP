package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MoodResults extends AppCompatActivity {
    private Database_Func dbhandler;
    private Button exitbtn, redobtn, switchbtn;
    private TextView datetext, titletext;
    private ImageView moodimage;
    private int userMood, hCount, oCount, sCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_results);
        dbhandler = new Database_Func(MoodResults.this);
        hCount = oCount = sCount = 0;
        exitbtn = findViewById(R.id.exitbutton);
        redobtn = findViewById(R.id.redobutton);
        switchbtn = findViewById(R.id.switchbutton);

        datetext = findViewById(R.id.mooddate);
        titletext = findViewById(R.id.moodtitle);
        moodimage = findViewById(R.id.moodimg);

        // Get results from MoodInput
        Intent intent = getIntent();
        userMood = intent.getIntExtra("mood", 1);
        moodimage.setImageResource(userMood);

        // Calculate Average and save to reuse (Replace 1 with actual id not sure where it is)
        ArrayList<Mood_His> UserMoods = dbhandler.getMoodHist(1);
        for (Mood_His SavedMood : UserMoods) {
            switch (SavedMood.getMood()) {
                case "happy":
                    hCount++;
                case "okay":
                    oCount++;
                case "sad":
                    sCount++;
            }
            switch (SavedMood.getMood2()) {
                case "happy":
                    hCount++;
                case "okay":
                    oCount++;
                case "sad":
                    sCount++;
            }
        }
        if (hCount >= oCount) {

        }

        switchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datetext.isEnabled()) {
                    datetext.setVisibility(View.INVISIBLE);
                    titletext.setText("Your Average Mood");
                }
                else {
                    datetext.setVisibility(View.VISIBLE);
                    titletext.setText("Your Mood of the Day");
                    moodimage.setImageResource(userMood);
                }
            }
        });
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        redobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will check if the second. Just put true for now since not sure how the database works fully

            }
        });
    }
}
