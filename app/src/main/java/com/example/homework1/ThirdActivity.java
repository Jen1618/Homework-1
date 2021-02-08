package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button_gohome;
    private String value;
    private String responses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        linearLayout = findViewById(R.id.second_linear_layout);
        button_gohome = findViewById(R.id.button_gohome);

        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        responses = intent.getStringExtra("responses");

        TextView textView = new TextView(this);
        textView.setText(value);
        linearLayout.addView(textView);

        TextView textView1 = new TextView(this);
        textView1.setText(responses);
        linearLayout.addView(textView1);

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