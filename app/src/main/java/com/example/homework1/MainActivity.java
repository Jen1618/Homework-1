package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button button_getstarted;
    private TextView textView_startmessage;

    private static final String api_url = "http://madlibz.herokuapp.com/api/random";
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_getstarted = findViewById(R.id.button_getstarted);
        textView_startmessage = findViewById(R.id.button_getstarted);

        button_getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchNextActivity(v);
            }
        });


    }

    private void launchNextActivity(View view) {
        client.addHeader("Accept", "application/json");
        client.get(api_url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("api response", new String(responseBody));
                try {
                    JSONObject json = new JSONObject(new String(responseBody));
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("blanks", json.getString("blanks"));
                    intent.putExtra("value", json.getString("value"));
                    intent.putExtra("title", json.getString("title"));
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("api error", new String(responseBody));
            }
        });
    }
}