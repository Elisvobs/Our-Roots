package com.elisvobs.roots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FoodInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.veg:
                startActivity(new Intent(this, VegetableActivity.class));
                finish();
                break;
            case R.id.solid:
                startActivity(new Intent(this, SolidActivity.class));
                finish();
                break;
            case  R.id.mushroom:
                startActivity(new Intent(this, MushroomActivity.class));
                finish();
                break;
            case R.id.legume:
                startActivity(new Intent(this, LegumeActivity.class));
                finish();
                break;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}