// RegistrationActivity.java
package com.example.comp4200group;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextName = findViewById(R.id.editTextName);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        TextView errorText = findViewById(R.id.errorText);

        buttonSubmit.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();
            String name = editTextName.getText().toString();

            Database_Func db = new Database_Func(this);
            boolean exists = db.exists(username);

            if(exists) {
                errorText.setText("This account already exists");
                errorText.setTextColor(Color.RED);
            }

            else {
                db.addUser(username, password, name);
                finish();
            }

        });
    }
}

