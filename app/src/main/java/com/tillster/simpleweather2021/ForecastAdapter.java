package com.tillster.simpleweather2021;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ForecastAdapter   extends ArrayAdapter<Forecast> {
    public ForecastAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
