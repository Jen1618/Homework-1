package com.example.homework1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button_goHome;
    private String value;
    private String responses;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        linearLayout = findViewById(R.id.second_linear_layout);
        button_goHome = findViewById(R.id.button_gohome);

        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        responses = intent.getStringExtra("responses");

        ArrayList<String> test = new ArrayList<String>(Arrays.asList(value.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)));
        ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(responses.split(",")));

        String outputValue = swap(test, inputs);
        String[] finalArray = outputValue.split("");

        for(int i = 0; i < finalArray.length; i++) {
            finalArray[i] = finalArray[i].replace("\"", "");
            finalArray[i] = finalArray[i].replace("[", "");
            finalArray[i] = finalArray[i].replace("]", "");
        }

        String finalValue = String.join("",finalArray);

        TextView textView = new TextView(this);
        textView.setText(finalValue);
        textView.setTextSize(30);
        linearLayout.addView(textView);

        button_goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });
    }

    public String swap(ArrayList<String> text, ArrayList<String> inputs){
        String temp="";
        String [] string1= change(text);
        String [] string2= change(inputs);
        int size = string2.length;
        for(int i=0;i<size;i++){
            temp = temp + string1[i]+ string2[i];
        }
        return temp;
    }

    public String [] change(ArrayList<String> sample){
        String [] newString =new String [sample.size()];
        for(int i= 0; i< sample.size();i++){
            newString[i]=sample.get(i);
        }
        return newString;
    }

    private void launchNextActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);
    }
}