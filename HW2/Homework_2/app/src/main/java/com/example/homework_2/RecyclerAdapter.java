package com.example.homework_2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<City> cityList;

    public RecyclerAdapter(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView city_text;

        public MyViewHolder(final View view) {
            super(view);
            city_text = view.findViewById(R.id.city_name_2);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), Information.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("city_name",  cityList.get(getAdapterPosition()).getCity());
                    view.getContext().startActivity(intent);

                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder myViewHolder, int i) {
        String city_name = cityList.get(i).getCity();
        myViewHolder.city_text.setText(city_name);
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }
}
