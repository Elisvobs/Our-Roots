package com.elisvobs.roots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VegetableActivity extends AppCompatActivity {
    private List<Food> foods;
    RecyclerView mRecyclerView;
    FoodRecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        setTitle("Vegetables");

        mRecyclerView = findViewById(R.id.food_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerAdapter);
        listVegetable();
    }

    private void listVegetable() {
        foods = new ArrayList<>();
        foods.add(new Food("Bupwe"));
        foods.add(new Food("Chembere Dzagumhana"));
        foods.add(new Food("Derere rechipudzi"));
        foods.add(new Food("Derere renama"));
        foods.add(new Food("Mashamba"));
        foods.add(new Food("Mowa"));
        foods.add(new Food("Muboora"));
        foods.add(new Food("Mufarinya"));
        foods.add(new Food("Nyamatepo"));
        foods.add(new Food("Nyemba"));
        foods.add(new Food("Nyenje"));
        foods.add(new Food("Nyemba"));
        foods.add(new Food("Nyevhe"));
        foods.add(new Food("Tsunga"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerAdapter.notifyDataSetChanged();
    }
}