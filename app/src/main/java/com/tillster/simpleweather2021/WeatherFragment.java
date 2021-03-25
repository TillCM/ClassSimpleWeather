package com.tillster.simpleweather2021;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.URL;

import static com.tillster.simpleweather2021.MainActivity.TAG;


public class WeatherFragment extends Fragment {


    public WeatherFragment()
    {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        URL url = NetworkUtil.createURLforWeather();
        new FetchWeatherData().execute(url);

        return view;
    }

         private class FetchWeatherData extends AsyncTask<URL,Void,String>
    {


        @Override
        protected String doInBackground(URL... urls)
        {
            URL weatherUrl = urls[0];
            String weatherData=null;

            try
            {
                weatherData = NetworkUtil.getResponseFromHttpUrl(weatherUrl);
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

            Log.i(TAG, "doInBackground: weather" +weatherData);
            return weatherData;
        }

        

    }
}