package com.example.weather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.POJO.ConsolidatedWeather_;
import com.example.weather.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<ConsolidatedWeather_> arrayListWeather;
    private Context context;
    private String title;

    public RecyclerAdapter(ArrayList<ConsolidatedWeather_> arrayListWeather, Context context, String title) {
        this.arrayListWeather = arrayListWeather;
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img_main,img_day1,img_day2,img_day3,img_day4,img_day5;
        ImageView[] imageViews;
        TextView txt_weatherState,txt_curTemp,txt_minTemp,txt_maxTemp,txt_curDay,txt_day1,txt_day2,txt_day3,txt_day4,txt_day5,
                txt_state1,txt_state2,txt_state3,txt_state4,txt_state5,txt_windDire,txt_windSpeed,txt_predict,txt_humid,txt_visibility,txt_pressure;
        TextView[] textState;
        TextView[] textDays;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_main = itemView.findViewById(R.id.img_main);
            txt_weatherState=itemView.findViewById(R.id.txt_weatherState);
            txt_curTemp=itemView.findViewById(R.id.txt_curTemp);
            txt_minTemp=itemView.findViewById(R.id.txt_minTemp);
            txt_maxTemp=itemView.findViewById(R.id.txt_maxTemp);
            txt_curDay=itemView.findViewById(R.id.txt_curDay);
            img_day1=itemView.findViewById(R.id.img_day1);
            txt_day1=itemView.findViewById(R.id.txt_day1);
            txt_state1=itemView.findViewById(R.id.txt_state1);
            img_day2=itemView.findViewById(R.id.img_day2);
            txt_day2=itemView.findViewById(R.id.txt_day2);
            txt_state2=itemView.findViewById(R.id.txt_state2);
            img_day3=itemView.findViewById(R.id.img_day3);
            txt_day3=itemView.findViewById(R.id.txt_day3);
            txt_state3=itemView.findViewById(R.id.txt_state3);
            img_day4=itemView.findViewById(R.id.img_day4);
            txt_day4=itemView.findViewById(R.id.txt_day4);
            txt_state4=itemView.findViewById(R.id.txt_state4);
            img_day5=itemView.findViewById(R.id.img_day5);
            txt_day5=itemView.findViewById(R.id.txt_day5);
            txt_state5=itemView.findViewById(R.id.txt_state5);
            txt_windDire=itemView.findViewById(R.id.txt_windDire);
            txt_windSpeed=itemView.findViewById(R.id.txt_windSpeed);
            txt_predict=itemView.findViewById(R.id.txt_predict);
            txt_humid=itemView.findViewById(R.id.txt_humid);
            txt_visibility=itemView.findViewById(R.id.txt_visibility);
            txt_pressure=itemView.findViewById(R.id.txt_pressure);
            imageViews=new ImageView[]{img_main,img_day1,img_day2,img_day3,img_day4,img_day5};
            textDays=new TextView[]{txt_curDay,txt_day1,txt_day2,txt_day3,txt_day4,txt_day5};
            textState=new TextView[]{txt_weatherState,txt_state1,txt_state2,txt_state3,txt_state4,txt_state5};
            itemView.setTag(this);
        }
    }
}
