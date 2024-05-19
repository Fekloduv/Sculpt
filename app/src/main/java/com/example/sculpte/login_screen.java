package com.example.sculpte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class login_screen extends AppCompatActivity {
    private DatabaseConnection databaseConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        Button btn_login = findViewById(R.id.btn_login);
        databaseConnection = new DatabaseConnection(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUsername = findViewById(R.id.et_username);
                EditText etPassword = findViewById(R.id.et_password);

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                int val = databaseConnection.getUserId(username, password);
                if (val != -1)
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}