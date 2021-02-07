package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button_generate;
    private String receivedMessage;
    private String receivedMessage1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        receivedMessage = intent.getStringExtra("blanks");

        Log.d("Data from Main Activity", receivedMessage);
        String delims = "[,]";
        String[] finalresult = receivedMessage.split(delims);

        linearLayout = findViewById(R.id.first_linear_layout);
        button_generate = findViewById(R.id.button_generate);

        for(int i = 0; i < finalresult.length; i++) {
            EditText editText = new EditText(this);
            TextView textView = new TextView(this);
            textView.setText(finalresult[i]);
            linearLayout.addView(editText);
            linearLayout.addView(textView);
        }

        button_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receivedMessage1 = intent.getStringExtra("value");
                launchNextActivity(v);
            }
        });
    }
    private void launchNextActivity(View view) {

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("value", receivedMessage1);
        startActivity(intent);

    }
}
