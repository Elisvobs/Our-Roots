package com.elisvobs.roots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AdditiveActivity extends AppCompatActivity {
    //    AdditiveAdapter adapter;
    ImageSwitcher switcher;
    int[] ADDITIVES = {
            R.drawable.soda,
            R.drawable.hacha,
            R.drawable.pumpkin,
            R.drawable.tsunga,
            R.drawable.peanut,
            R.drawable.baobab,
            R.drawable.legume_flour
    };
    int[] ADDITIVE_NAMES = {
            R.string.soda,
            R.string.hacha,
            R.string.pumpkin,
            R.string.tsunga_seeds,
            R.string.peanut,
            R.string.baobab,
            R.string.legume_flour
    };
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additive);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        List<Additive> additives = DataManager.getInstance().getAdditiveNames();
//        adapter = new AdditiveAdapter(additives);
//        recyclerView.setAdapter(adapter);

        switcher = findViewById(R.id.switcher);
        switcher.setFactory(() -> {
            ImageView image = new ImageView(getApplicationContext());
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setLayoutParams(new ImageSwitcher.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
                    )
            );
            return image;
        });
    }

    public void switchImage(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.previous:
                if (currentIndex > 0) {
                    currentIndex = currentIndex - 1;
                    switcher.setBackgroundResource(ADDITIVES[currentIndex]);
                    switcher.setLabelFor(ADDITIVE_NAMES[currentIndex]);
                    setTitle(ADDITIVE_NAMES[currentIndex]);
//                    switcher.setBackgroundResource(DataManager.getInstance().getAdditiveImages()[currentIndex]);
                }
                break;

            case R.id.next:
                if (currentIndex < ADDITIVES.length - 1) {
                    currentIndex = currentIndex + 1;
                    switcher.setBackgroundResource(ADDITIVES[currentIndex]);
                    switcher.setLabelFor(ADDITIVE_NAMES[currentIndex]);
                    setTitle(ADDITIVE_NAMES[currentIndex]);
                }
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
        finish();
    }

}