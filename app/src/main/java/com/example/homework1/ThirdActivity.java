package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button_gohome;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        linearLayout = findViewById(R.id.second_linear_layout);
        button_gohome = findViewById(R.id.button_gohome);

        Intent intent = getIntent();

        button_gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });
    }
    private void launchNextActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);

    }
}
