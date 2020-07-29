package com.elisvobs.roots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.elisvobs.roots.utils.DataManager;

public class Additive extends AppCompatActivity {
    //    AdditiveAdapter adapter;
    ImageSwitcher switcher;
    int currentIndex = -1;
    private int[] mAdditiveImages = DataManager.getInstance().getAdditiveImages();
    private int[] mAdditiveNames = DataManager.getInstance().getAdditiveNames();

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
        switcher.setFactory(this::makeView);
    }

    private View makeView() {
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setLayoutParams(new ImageSwitcher.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT));
        return image;
    }

    public void switchImage(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.previous:
                if (currentIndex > 0) {
                    currentIndex = currentIndex - 1;
//                    switcher.setBackgroundResource(ADDITIVES[currentIndex]);
//                    switcher.setLabelFor(ADDITIVE_NAMES[currentIndex]);
//                    setTitle(ADDITIVE_NAMES[currentIndex]);
                    switcher.setBackgroundResource(mAdditiveImages[currentIndex]);
                    switcher.setLabelFor(mAdditiveNames[currentIndex]);
                    setTitle(mAdditiveNames[currentIndex]);
                }
                break;

            case R.id.next:
                if (currentIndex < mAdditiveImages.length - 1) {
                    currentIndex = currentIndex + 1;
                    switcher.setBackgroundResource(mAdditiveImages[currentIndex]);
                    switcher.setLabelFor(mAdditiveNames[currentIndex]);
                    setTitle(mAdditiveNames[currentIndex]);
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
        startActivity(new Intent(this, Home.class));
        finish();
    }

}