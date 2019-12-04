package com.elisvobs.roots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SolidsActivity extends AppCompatActivity {
    private List<Food> foods;
    RecyclerView mRecyclerView;
    FoodRecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        setTitle("Solids");

        mRecyclerView = findViewById(R.id.food_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerAdapter);
        listSolids();
    }

    private void listSolids() {
        foods = new ArrayList<>();
        foods.add(new Food("Mabumbe"));
        foods.add(new Food("Makwaya"));
        foods.add(new Food("Manhanga"));
        foods.add(new Food("Mashamba"));
        foods.add(new Food("Mutakura"));
        foods.add(new Food("Nhopi"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerAdapter.notifyDataSetChanged();
    }
}