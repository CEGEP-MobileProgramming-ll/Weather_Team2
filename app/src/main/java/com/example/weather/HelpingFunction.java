package com.example.weather;

import android.annotation.SuppressLint;
import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpingFunction {


    public static String getDayStringOld(String date1) throws ParseException {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String FromDate = null;
        try {
            date = dateformat.parse(date1);
            @SuppressLint("SimpleDateFormat") DateFormat dayFormate=new SimpleDateFormat("EEEE");
            FromDate=dayFormate.format(date);
            Log.d("asd", "----------:: "+FromDate);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return FromDate;
    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
