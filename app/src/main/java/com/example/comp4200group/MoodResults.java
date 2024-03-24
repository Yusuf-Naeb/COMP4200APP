package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.TextView;

public class MoodResults extends AppCompatActivity {
    private Database_Func dbhandler;
    private Button menubtn, secondbtn, switchbtn;
    private TextView datetext, titletext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_results);

        menubtn = findViewById(R.id.menubutton);
        secondbtn = findViewById(R.id.mood2button);
        switchbtn = findViewById(R.id.switchbutton);

        datetext = findViewById(R.id.mooddate);
        titletext = findViewById(R.id.moodtitle);

        dbhandler = new Database_Func(MoodResults.this);

        switchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datetext.isEnabled()) {
                    datetext.setEnabled(false);
                    titletext.setText("Your Average Mood");
                }
                else {
                    datetext.setEnabled(true);
                    titletext.setText("Your Mood of the Day");
                }
            }
        });
        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to Menu when clicked (insert menu info here)
            }
        });

        secondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will check if the second. Just put true for now since not sure how the database works fully
                if (true) {

                }
                else {
                    // Send toast since 2nd mood was picked already
                    Toast toast = Toast.makeText(MoodResults.this, "Second mood already picked", Toast.LENGTH_SHORT);
                    toast.show();
                }
                // Return to pick a second mood. Disallow if second mood has been picked already
            }
        });
    }
}
