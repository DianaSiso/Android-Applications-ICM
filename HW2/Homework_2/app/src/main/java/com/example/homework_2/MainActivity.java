package com.example.homework_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner_city=findViewById(R.id.spinner_city);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_city.setAdapter(adapter);
    }

    public void searchCity(View view){
        //get city_name
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_city);
        String text = mySpinner.getSelectedItem().toString();

        Intent intent = new Intent(this, Information.class);
        intent.putExtra("city_name", text);
        startActivity(intent);
    }



    public void recyclerButton(View view){
        //get city_name

        Intent intent = new Intent(this, recyclerView.class);
        startActivity(intent);
    }
}