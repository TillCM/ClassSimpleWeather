package com.tillster.simpleweather2021;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {
    private static String TAG = "URLWECREATED";
    private static final String BASE_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/305605";
    private static final String PARAM_APIKEY = "apikey";
    private static final String APIKEY = "LIc7QFikePzoVfrT9zOvYqYeO4FS5vtM";
    private static final String PARAM_METRIC = "metric";
    private static final String METRIC_VALUE = "true";

    public static URL createURLforWeather() {
        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_APIKEY, APIKEY)
                .appendQueryParameter(PARAM_METRIC, METRIC_VALUE)
                .build();

        URL url = null;

        try {
            url = new URL(uri.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "createURLforWeather: " + url);

        return url;

    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("//A");
            boolean hasinput = scanner.hasNext();

            if (hasinput) {
                return scanner.next();
            } else {
                return null;
                // Toast.makeText(, "No JSON FOUND", Toast.LENGTH_SHORT).show();
            }

        } finally {
            urlConnection.disconnect();

        }

    }

}
