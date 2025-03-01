package com.example.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.POJO.ConsolidatedWeather;
import com.example.weather.POJO.ConsolidatedWeather_;
import com.example.weather.adapter.RecyclerAdapter;
import com.example.weather.retrofit.GetDataService;
import com.example.weather.retrofit.RetrofitClientInstance;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ConsolidatedWeather_> wArrayList;
    private boolean connected;
    String title;
    int a=R.id.c_montreal;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()!=null){
            a=getArguments().getInt("Country");
        }
        Log.d("MainFragment","id="+a);
        decision(a);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void decision(int b) {
        if(checkInternetConnection()){
            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<ConsolidatedWeather> call;
            Log.d("MainFragment","decision="+b);
            switch (b){
                case R.id.c_montreal: call = service.getMontrealWeatherData();
                    Log.d("MainFragment","idmon="+"getMon");
                    loadJson(call);
                    break;
                case R.id.c_london:  call = service.getLondonWeatherData();
                    Log.d("MainFragment","idlon="+"getLondon");
                    loadJson(call);
                    break;
                case R.id.c_abd:  call = service.getAhmedabadWeatherData();
                    Log.d("MainFragment","idlon="+"getLondon");
                    loadJson(call);
                    break;
                case R.id.c_ny:  call = service.getNewyorkWeatherData();
                    Log.d("MainFragment","Ny="+"getLondon");
                    loadJson(call);
                    break;
                case R.id.c_toronto:  call = service.getTorontoWeatherData();
                    Log.d("MainFragment","idlon="+"getToronto");
                    loadJson(call);
                    break;
                case R.id.c_vancouver:  call = service.getVancouverWeatherData();
                    Log.d("MainFragment","idlon="+"getVancouver");
                    loadJson(call);
                    break;
                case R.id.c_mumbai:  call = service.getMumbaiWeatherData();
                    Log.d("MainFragment","idlon="+"getMumbai");
                    loadJson(call);
                    break;
                case R.id.c_surat:  call = service.getSuratWeatherData();
                    Log.d("MainFragment","idlon="+"getSurat");
                    loadJson(call);
                    break;
                case R.id.c_chicago:  call = service.getChicagoWeatherData();
                    Log.d("MainFragment","idlon="+"getLondon");
                    loadJson(call);
                    break;
            }
        }else{
            noInternetConnection();
        }

    }

    private void noInternetConnection() {
        final Snackbar snackbar = Snackbar.make(getActivity().findViewById(R.id.fragMain),"No Internet Connection!!!",Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Retry!", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInternetConnection()){
                    snackbar.dismiss();
                    decision(a);
                }else {
                    noInternetConnection();
                }
            }
        }).show();
    }



    public boolean checkInternetConnection() {

        //Check internet connection:
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        //Means that we are connected to a network (mobile or wi-fi)
        connected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;

        return connected;
    }

    public void loadJson(Call<ConsolidatedWeather> call){
        call.enqueue(new Callback<ConsolidatedWeather>() {
            @Override
            public void onResponse(Call<ConsolidatedWeather> call, Response<ConsolidatedWeather> response) {
                System.out.println("Response From URL :" + response.body());
                try {
                    ConsolidatedWeather weather = response.body();
                    wArrayList = new ArrayList<>(weather.getConsolidatedWeather());
                    title=weather.getTitle();
                    Log.d("main Fragment","jsond"+title);
                    ((MainActivity) getActivity())
                            .setActionBarTitle(title);
                    generateView(wArrayList,title);

                }catch (NullPointerException e)
                {
                    System.out.println("Nullpointer Exception :"+e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ConsolidatedWeather> call, Throwable t) {

                System.out.println("In Failure :" + t.getMessage());

            }
        });
    }

    public void generateView(ArrayList<ConsolidatedWeather_> weatherS, String title)
    {

        recyclerAdapter = new RecyclerAdapter(weatherS, getActivity().getApplicationContext(),title);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView = getView().findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }


}