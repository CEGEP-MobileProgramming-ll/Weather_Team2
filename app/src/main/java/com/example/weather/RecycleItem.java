package com.example.weather;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RecycleItem extends AppCompatActivity {

    String url1="https://www.metaweather.com/static/img/weather/png/64/";
    String url2=".png";
    ConstraintLayout constraintLayout;
    Toolbar toolbar;
    String title;
    ImageView img_main;
    TextView txt_weatherState,txt_curTemp,txt_minTemp,txt_maxTemp,txt_curDay,
            txt_windDire,txt_windSpeed,txt_predict,txt_humid,txt_visibility,txt_pressure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleitem);

        constraintLayout=findViewById(R.id.constraintLayout);
        toolbar=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.VISIBLE);

        txt_weatherState=findViewById(R.id.txt_weatherState);
        img_main = findViewById(R.id.img_main);
        txt_weatherState=findViewById(R.id.txt_weatherState);
        txt_curTemp=findViewById(R.id.txt_curTemp);
        txt_minTemp=findViewById(R.id.txt_minTemp);
        txt_maxTemp=findViewById(R.id.txt_maxTemp);
        txt_curDay=findViewById(R.id.txt_curDay);
        txt_windDire=findViewById(R.id.txt_windDire);
        txt_windSpeed=findViewById(R.id.txt_windSpeed);
        txt_predict=findViewById(R.id.txt_predict);
        txt_humid=findViewById(R.id.txt_humid);
        txt_visibility=findViewById(R.id.txt_visibility);
        txt_pressure=findViewById(R.id.txt_pressure);
    }

    private void generateview(){


    }
}
