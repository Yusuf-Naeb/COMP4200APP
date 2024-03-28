package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {
    private Database_Func dbhandler;
    private EditText usernameET;
    private EditText passwordET;

    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);
        errorText = findViewById(R.id.error_text);

        Button login = findViewById(R.id.login);

        Button createAccount = findViewById(R.id.createAccount);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve text from the editText
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                //check login credentials
                Database_Func db = new Database_Func(MainActivity.this);
                boolean loggedIn = db.checkLogin(username, password);

                if (loggedIn) {
                    //login successful
                    //navigate to next activity
                    Intent intent = new Intent(MainActivity.this, MoodInput.class);
                    startActivity(intent);
                } else {
                    //login failed
                    errorText.setText("Incorrect username or password");
                    errorText.setTextColor(Color.RED);
                }

            }

        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);


            }

        });

//        dbhandler = new Database_Func(MainActivity.this);
//        dbhandler.addUser("test", "test", "test");
//        dbhandler.addMood("happy", null, 1);
        //test
    }
}

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//
//import java.util.ArrayList;
////This is the main activity for History activity
//public class MainActivity extends AppCompatActivity {
//    RecyclerView recyclerView;
//    Database_Func dbhandler;
//    ArrayList<Mood_His> dataSets = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.his_main);
//        recyclerView = findViewById(R.id.recyclerView);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        //dbhandler = new Database_Func(MainActivity.this);
//
//        //dataSets = dbhandler.getMoodHist(id);
//
//        //For testing, only need to test with database
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
//
//
//        HistoryAdapter myAdapter = new HistoryAdapter(dataSets, MainActivity.this);
//        recyclerView.setAdapter(myAdapter);
//    }
//}
