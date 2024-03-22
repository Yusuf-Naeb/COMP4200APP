package com.example.comp4200group;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Database_Func dbhandler;
    private EditText usernameET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve text from the editText
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                //Some sort of authenticator method
            }
        });

         dbhandler = new Database_Func(MainActivity.this);
         dbhandler.addUser("test", "test", "test");
         dbhandler.addMood("happy", null, 1);
        //test
    }
}
