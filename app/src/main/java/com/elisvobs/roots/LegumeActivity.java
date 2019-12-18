package com.elisvobs.roots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LegumeActivity extends AppCompatActivity {
    private List<Food> foods;
    RecyclerView mRecyclerView;
    FoodRecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        setTitle("Legumes & Pulses");

        mRecyclerView = findViewById(R.id.food_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerAdapter);
        listLegumes();
    }

    private void listLegumes() {
        foods = new ArrayList<>();
        foods.add(new Food("Nyemba"));
        foods.add(new Food("Nyimo"));
        foods.add(new Food("Rupiza"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerAdapter.notifyDataSetChanged();
    }
}