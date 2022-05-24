package com.example.homework_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Information extends AppCompatActivity {
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    private final String apikey = "23a94ed8a528d2ab1aaa9afdedfddc76";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        String city_name = getIntent().getStringExtra("city_name");
        Log.d("City Name", city_name);
        TextView city = findViewById(R.id.city_name);
        city.setText(city_name);

        String tempUrl = url + "?q=" + city_name + "," + "Portugal" + "&appid=" + apikey;
        Log.d("Url", tempUrl);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                    JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                    String description = jsonObjectWeather.getString("description");
                    JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                    double temp = Math.round(jsonObjectMain.getDouble("temp") - 273.15);
                    double temp_min = Math.round(jsonObjectMain.getDouble("temp_min") - 273.15);
                    double temp_max = Math.round(jsonObjectMain.getDouble("temp_max") - 273.15);
                    float pressure = jsonObjectMain.getInt("pressure");
                    int humidity = jsonObjectMain.getInt("humidity");
                    JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                    String wind = jsonObjectWind.getString("speed");

                    //set values
                    TextView temp_value = findViewById(R.id.temp_value);
                    TextView temp_max_value = findViewById(R.id.temp_max_value);
                    TextView temp_min_value = findViewById(R.id.temp_min_value);
                    TextView humidity_value = findViewById(R.id.humidity_value);
                    TextView pressure_value = findViewById(R.id.pressure_value);
                    TextView wind_value = findViewById(R.id.wind_value);


                    temp_value.setText("Temperature\n" + temp + " ºC");
                    temp_max_value.setText("Temperature Max.\n" + temp_max + " ºC");
                    temp_min_value.setText("Temperature Min.\n" + temp_min + " ºC");
                    humidity_value.setText("Humidity\n" + humidity);
                    wind_value.setText("Wind\n" + wind);
                    pressure_value.setText("Pessure\n" + pressure);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString().trim() , Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }

}