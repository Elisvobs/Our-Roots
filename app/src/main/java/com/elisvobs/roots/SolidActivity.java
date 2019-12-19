package com.elisvobs.roots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SolidActivity extends AppCompatActivity {
    FoodRecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        setTitle("Solids");

        listSolids();
    }

    private void listSolids() {
        final List<Food> foods  = new ArrayList<>();
        final RecyclerView mRecyclerView = findViewById(R.id.food_list);

        foods.add(new Food("Mabumbe"));
        foods.add(new Food("Makwaya"));
        foods.add(new Food("Manhanga"));
        foods.add(new Food("Mashamba"));
        foods.add(new Food("Mutakura"));
        foods.add(new Food("Nhopi"));

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