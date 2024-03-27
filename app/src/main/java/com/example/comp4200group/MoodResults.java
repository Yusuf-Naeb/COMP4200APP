package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class MoodResults extends AppCompatActivity {
    private Database_Func dbhandler;
    private Button redobtn, switchbtn;
    private TextView datetext, titletext;
    private ImageView moodimage;
    private int userMood, aveMood, hCount, oCount, sCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_results);
        dbhandler = new Database_Func(MoodResults.this);
        hCount = oCount = sCount = 0;
        redobtn = findViewById(R.id.redobutton);
        switchbtn = findViewById(R.id.switchbutton);

        datetext = findViewById(R.id.mooddate);
        titletext = findViewById(R.id.moodtitle);
        moodimage = findViewById(R.id.moodimg);

        // Display time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datetext.setText("On " + dateFormat.format(Calendar.getInstance().getTime()));
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
                    break;
                case "okay":
                    oCount++;
                    break;
                case "sad":
                    sCount++;
                    break;
            }
        }

        if (hCount >= oCount && hCount >= sCount) {
            aveMood =  R.drawable.happy;
        } else if (oCount >= hCount && oCount >= sCount) {
            aveMood = R.drawable.okay;
        } else {
            aveMood = R.drawable.sad;
        }

        switchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datetext.getVisibility() == View.VISIBLE) {
                    datetext.setVisibility(View.INVISIBLE);
                    titletext.setText("Your Average Mood");
                    moodimage.setImageResource(aveMood);
                }
                else {
                    datetext.setVisibility(View.VISIBLE);
                    titletext.setText("Your Mood of the Day");
                    moodimage.setImageResource(userMood);
                }
            }
        });

        redobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoodResults.this, MoodInput.class);
                intent.putExtra("change mood", true);
                startActivity(intent);
                // Goes back to MoodInput and allows user to change mood they just put in
            }
        });
    }
}
