package com.example.openweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    private  static final String  API =  "d557f33ee79b5560aaa93940b2603d33";
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.temp_txt);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=London,uk&units=metric&APPID="+API);

    }
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
        @Override
        public void OnResponse(String response){
            txtView.setText("Temp is: " + response.substring(0));
        }
    },new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error){
            txtView.setText("That didn't work!");
        }
    });
    queue.add(stringRequest);
}