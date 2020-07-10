package com.elisvobs.roots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VegetableActivity extends AppCompatActivity {
    FoodRecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        setTitle("Vegetables");
        listVegetable();
    }

    private void listVegetable() {
        final RecyclerView mRecyclerView = findViewById(R.id.food_list);
        final List<Food> foods = new ArrayList<>();

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
        foods.add(new Food("Nyevhe"));
        foods.add(new Food("Tsunga"));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new FoodRecyclerViewAdapter(foods);
        mRecyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, FoodInfoActivity.class));
        finish();
    }
}