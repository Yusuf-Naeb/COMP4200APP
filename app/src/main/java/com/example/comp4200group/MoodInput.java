package com.example.comp4200group;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class MoodInput extends AppCompatActivity {
    private Database_Func dbhandler;
    private TextView dateText;
    private ImageButton selectedImageButton;
    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_input);
        dateText = findViewById(R.id.currentDate);
        submitBtn = findViewById(R.id.submitButton);
        dbhandler = new Database_Func(MoodInput.this);
        //Current Date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String currentDate = String.format("%04d-%02d-%02d", year, month, day);
        dateText.setText(currentDate);

        //submit button, once pressed adds mood to db, and goes to result page
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int selectedImageId = selectedImageButton.getId();
              String selectedMood = getMoodFromImageId(selectedImageId);
              addMoodToDatabase(selectedMood);
              Intent intent = new Intent(MoodInput.this, MoodResults.class);
              startActivity(intent);
            }
        });

    }

    private String getMoodFromImageId(int imageId){
        String mood;
        if (imageId == R.id.happyButton) {
            mood = "Happy";
        } else if (imageId == R.id.sadButton) {
            mood = "Sad";
        } else if (imageId == R.id.okayButton) {
            mood = "Sad";
        }else{
            mood = null;
        }
        return mood;
    }

    private void addMoodToDatabase(String mood){
        dbhandler.addMood(mood,null, 1);
    }

    public void onImageButtonClicked(View v){
        ImageButton clickedButton = (ImageButton) v;

        if(selectedImageButton != null){
            selectedImageButton.setSelected(false);
            selectedImageButton.setBackgroundColor(Color.TRANSPARENT);
        }

        selectedImageButton = clickedButton;
        selectedImageButton.setSelected(true);
        selectedImageButton.setBackgroundColor(Color.LTGRAY);

    }
}
