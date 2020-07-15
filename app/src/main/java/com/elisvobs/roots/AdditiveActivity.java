package com.elisvobs.roots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.roots.adapters.AdditiveAdapter;
import com.elisvobs.roots.model.Additive;
import com.elisvobs.roots.utils.DataManager;

import java.util.List;

public class AdditiveActivity extends AppCompatActivity {
    AdditiveAdapter adapter;
    ImageSwitcher switcher;
    int[] ADDITIVES = {};
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additive);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Additive> additives = DataManager.getInstance().getAdditives();
        adapter = new AdditiveAdapter(additives);
        recyclerView.setAdapter(adapter);

//        switcher = findViewById(R.id.switcher);
//        switcher.setFactory(() -> {
//            ImageView image = new ImageView(getApplicationContext());
//            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            image.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
//                    ActionBar.LayoutParams.WRAP_CONTENT));
//            return image;
//        });
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

    public void switchImage(View view) {
        int id = view.getId();
//        switch (id) {
//            case R.id.previous:
//                if (currentIndex > 0) {
//                    currentIndex = currentIndex - 1;
//                    switcher.setBackgroundResource(PRODUCTS[currentIndex]);
//                }
//                break;
//
//            case R.id.next:
//                if (currentIndex < PRODUCTS.length - 1) {
//                    currentIndex = currentIndex + 1;
//                    switcher.setBackgroundResource(PRODUCTS[currentIndex]);
//                }
//                break;
//        }
    }

}