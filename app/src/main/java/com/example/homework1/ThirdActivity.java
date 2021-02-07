package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button_gohome;
    private String receivedMessage1;
    private String[] receivedMessage2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        linearLayout = findViewById(R.id.second_linear_layout);
        button_gohome = findViewById(R.id.button_gohome);

        Intent intent = getIntent();
        receivedMessage1 = intent.getStringExtra("value");
        TextView textView = new TextView(this);
        textView.setText(receivedMessage1);
        linearLayout.addView(textView);

        receivedMessage2 = intent.getStringArrayExtra("info");
        TextView textView1 = new TextView(this);
        Log.d("info","Val " + String.valueOf(receivedMessage2));
        textView1.setText(String.valueOf(receivedMessage2));
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