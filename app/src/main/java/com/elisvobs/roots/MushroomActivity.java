package com.elisvobs.roots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MushroomActivity extends AppCompatActivity {
    private List<Food> foods;
    RecyclerView mRecyclerView;
    FoodRecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        setTitle("Mushrooms");

//        mRecyclerView = findViewById(R.id.food_list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setAdapter(recyclerAdapter);
//        listMushroom();
    }

    private void listMushroom() {
        foods = new ArrayList<>();
        foods.add(new Food("Howa"));
        foods.add(new Food("Nhedzi"));
    }

    @Override
    protected void onResume() {
        super.onResume();
//        recyclerAdapter.notifyDataSetChanged();
    }
}