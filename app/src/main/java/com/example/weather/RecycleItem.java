package com.example.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.weather.POJO.ConsolidatedWeather_;

import java.text.ParseException;

public class RecycleItem extends AppCompatActivity {

    String url1="https://www.metaweather.com/static/img/weather/png/64/";
    String url2=".png";
    ConstraintLayout constraintLayout;
    Toolbar toolbar;
    String title;
    CardView cardView;
    ConsolidatedWeather_ consolidatedWeather;
    HelpingFunction d=new HelpingFunction();
    ImageView img_main;
    TextView txt_weatherState,txt_curTemp,txt_minTemp,txt_maxTemp,txt_curDay,
            txt_windDire,txt_windSpeed,txt_predict,txt_humid,txt_visibility,txt_pressure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleitem);

        cardView=findViewById(R.id.dayDetail);
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

        consolidatedWeather= getIntent().getParcelableExtra("Key");
        title=getIntent().getStringExtra("Title");

        toolbar.setTitle(title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        try {
            generateview();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void generateview() throws ParseException {
        constraintLayout.setBackgroundResource(R.drawable.gradient1);
        cardView.setVisibility(View.GONE);
        txt_weatherState.setText(consolidatedWeather.getWeatherStateName());
        Glide.with(this).load(url1+consolidatedWeather.getWeatherStateAbbr()+url2).into(img_main);
        txt_curTemp.setText(""+d.round(consolidatedWeather.getTheTemp(),2)+"°");
        txt_minTemp.setText(""+d.round(consolidatedWeather.getMinTemp(),2)+"°");
        txt_maxTemp.setText(""+d.round(consolidatedWeather.getMaxTemp(),2)+"°");
        txt_curDay.setText(""+d.getDayStringOld(consolidatedWeather.getApplicableDate()));
        txt_windDire.setText(""+consolidatedWeather.getWindDirectionCompass());
        txt_windSpeed.setText(""+d.round(consolidatedWeather.getWindSpeed(),2)+" m/h");
        txt_windDire.setText(""+consolidatedWeather.getWindDirectionCompass());
        txt_predict.setText(""+consolidatedWeather.getPredictability()+"%");
        txt_humid.setText(""+consolidatedWeather.getHumidity()+"%");
        txt_visibility.setText(""+d.round(consolidatedWeather.getVisibility(),2)+" miles");
        txt_pressure.setText(""+consolidatedWeather.getAirPressure()+" mBar");
    }
}
