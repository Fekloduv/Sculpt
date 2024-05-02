package com.example.sculpte;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prof_button = findViewById(R.id.prof_button);
        Button btn_login_button = findViewById(R.id.btn_login_button);
        prof_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Запуск новой активити с макетом profile_window.xml
                Intent intent = new Intent(MainActivity.this, profile.class);
                startActivity(intent);
            }
        });

        btn_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Запуск окна login
                Intent apintent = new Intent(MainActivity.this, login_screen.class);
                startActivity(apintent);
            }
        });
    }
}