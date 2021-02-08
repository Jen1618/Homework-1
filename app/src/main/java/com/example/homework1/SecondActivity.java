package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button_generate;
    private String receivedMessage;
    private String receivedMessage1;
    private ArrayList<String> temp;
    String[] responses;
    private String finalResponses;


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

        List<EditText> alledittexts = new ArrayList<>();
        temp = new ArrayList<String>();


        for(int i = 0; i < finalresult.length; i++) {
            finalresult[i] = finalresult[i].replace("\"", "");
            finalresult[i] = finalresult[i].replace("[", "");
            finalresult[i] = finalresult[i].replace("]", "");
            EditText editText = new EditText(this);
            TextView textView = new TextView(this);
            textView.setText(finalresult[i]);
            linearLayout.addView(editText);
            linearLayout.addView(textView);
            alledittexts.add(editText);
        }

        String[] responses = new String[alledittexts.size()];

        button_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int counter = 0;

                for (int i = 0; i < alledittexts.size(); i++) {
                    if (!alledittexts.get(i).getText().toString().equals("")) {
                        counter++;
                    }
                }

                if (counter == alledittexts.size()) {
                    for (int j = 0; j < alledittexts.size(); j++) {
                        temp.add(alledittexts.get(j).getText().toString());
                        responses[j] = temp.get(j);
                    }
                    Log.d("info", Arrays.toString(responses));
                    receivedMessage1 = intent.getStringExtra("value");
                    finalResponses = Arrays.toString(responses);
                    launchNextActivity(v);
                }
                else {
                    sayError(v);
                }
            }
        });
    }

    public void sayError(View view){
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void launchNextActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("responses", finalResponses);
        intent.putExtra("value", receivedMessage1);
        startActivity(intent);

    }
}