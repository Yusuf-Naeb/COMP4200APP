package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {
    private EditText usernameET;
    private EditText passwordET;
    private TextView errorText;
    public static User userInfo;

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
                    userInfo = db.getUser(username, password);
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
