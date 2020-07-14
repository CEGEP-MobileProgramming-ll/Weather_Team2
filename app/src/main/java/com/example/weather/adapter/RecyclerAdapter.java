package com.example.weather.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather.HelpingFunction;
import com.example.weather.POJO.ConsolidatedWeather_;
import com.example.weather.R;
import com.example.weather.RecycleItem;

import java.text.ParseException;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<ConsolidatedWeather_> arrayListWeather;
    private Context context;
    private String title;
    HelpingFunction d=new HelpingFunction();
    String url1="https://www.metaweather.com/static/img/weather/png/64/";
    String url2=".png";

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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.txt_curTemp.setText(""+d.round(arrayListWeather.get(position).getTheTemp(),2)+"°");
        holder.txt_minTemp.setText(""+d.round(arrayListWeather.get(position).getMinTemp(),2)+"°");
        holder.txt_maxTemp.setText(""+d.round(arrayListWeather.get(position).getMaxTemp(),2)+"°");
        holder.txt_windDire.setText(""+arrayListWeather.get(position).getWindDirectionCompass());
        holder.txt_windSpeed.setText(""+d.round(arrayListWeather.get(position).getWindSpeed(),2)+" m/h");
        holder.txt_windDire.setText(""+arrayListWeather.get(position).getWindDirectionCompass());
        holder.txt_predict.setText(""+arrayListWeather.get(position).getPredictability()+"%");
        holder.txt_humid.setText(""+arrayListWeather.get(position).getHumidity()+"%");
        holder.txt_visibility.setText(""+d.round(arrayListWeather.get(position).getVisibility(),2)+" miles");
        holder.txt_pressure.setText(""+arrayListWeather.get(position).getAirPressure()+" mbar");

        for(int i=0;i<6;i++){
            holder.textState[i].setText(arrayListWeather.get(i).getWeatherStateName());
            Glide.with(context).load(url1+arrayListWeather.get(i).getWeatherStateAbbr()+url2).into(holder.imageViews[i]);
            Log.d("Adapter","state"+arrayListWeather.get(i).getWeatherStateAbbr());
            try {
                holder.textDays[i].setText(d.getDayStringOld(arrayListWeather.get(i).getApplicableDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            holder.textDays[i].setOnClickListener(detailData);
            holder.textState[i].setOnClickListener(detailData);
            holder.imageViews[i].setOnClickListener(detailData);
        }
    }

    View.OnClickListener detailData = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(v.getContext(), RecycleItem.class);
            Bundle bundle=new Bundle();
            bundle.putString("Title",title);
            switch (v.getId()){
                case R.id.txt_day1: case R.id.txt_state1: case R.id.img_day1:
                    Log.d("Adapter","txt1 pressed");
                    bundle.putParcelable("Key",arrayListWeather.get(1));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    break;
                case R.id.txt_day2: case R.id.txt_state2: case R.id.img_day2:
                    Log.d("Adapter","txt2 pressed");
                    bundle.putParcelable("Key",arrayListWeather.get(2));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    break;
                case R.id.txt_day3: case R.id.txt_state3: case R.id.img_day3:
                    Log.d("Adapter","txt3 pressed");
                    bundle.putParcelable("Key",arrayListWeather.get(3));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    break;
                case R.id.txt_day4: case R.id.txt_state4: case R.id.img_day4:
                    Log.d("Adapter","txt4 pressed");
                    bundle.putParcelable("Key",arrayListWeather.get(4));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    break;
                case R.id.txt_day5: case R.id.txt_state5: case R.id.img_day5:
                    Log.d("Adapter","txt5 pressed");
                    bundle.putParcelable("Key",arrayListWeather.get(5));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    break;
            }
        }
    };



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
