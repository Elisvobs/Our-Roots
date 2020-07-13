package com.elisvobs.roots;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.roots.adapters.AdditiveAdapter;
import com.elisvobs.roots.model.Additive;
import com.elisvobs.roots.utils.DataManager;

import java.util.List;

public class AdditiveActivity extends AppCompatActivity {
    AdditiveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additive);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Additive> additives = DataManager.getInstance().getAdditives();
        adapter = new AdditiveAdapter(additives);
        recyclerView.setAdapter(adapter);
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
        finish();
    }

}