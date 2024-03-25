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

        //Current Date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String currentDate = String.format("%04d-%02d-%02d", year, month, day);
        dateText.setText(currentDate);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(selectedImageButton != null){
                  int selectedImageId = selectedImageButton.getId();
                  Intent intent = new Intent(MoodInput.this, MoodResults.class);
                  startActivity(intent);
              }
            }
        });

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
