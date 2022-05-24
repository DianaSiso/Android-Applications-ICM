package com.example.homework_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class recyclerView extends AppCompatActivity {
    private ArrayList<City> citiesList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);

        citiesList = new ArrayList<>();
        setCityInfo();
        setAdapter();
    }

    private  void setCityInfo() {
        citiesList.add(new City("Aveiro"));
        citiesList.add(new City("Beja"));
        citiesList.add(new City("Bragança"));
        citiesList.add(new City("Castelo Branco"));
        citiesList.add(new City("Coimbra"));
        citiesList.add(new City("Évora"));
        citiesList.add(new City("Faro"));
        citiesList.add(new City("Guarda"));
        citiesList.add(new City("Leiria"));
        citiesList.add(new City("Lisboa"));
        citiesList.add(new City("Portalegre"));
        citiesList.add(new City("Porto"));
        citiesList.add(new City("Santarém"));
        citiesList.add(new City("Setúbal"));
        citiesList.add(new City("Viana do Castelo"));
        citiesList.add(new City("Viseu"));
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(citiesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }


}