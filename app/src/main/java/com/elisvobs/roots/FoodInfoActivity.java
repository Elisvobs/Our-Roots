package com.elisvobs.roots;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.elisvobs.roots.fragments.DualPaneFragment;
import com.elisvobs.roots.fragments.GridFragment;
import com.elisvobs.roots.fragments.ListFragment;
import com.elisvobs.roots.model.Recipes;
import com.elisvobs.roots.utils.ViewPagerFragment;

public class FoodInfoActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {
    private static final String LIST_FRAGMENT = "list_fragment";
    private static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (! isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                ListFragment fragment = new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }
        else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                GridFragment fragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }
        setContentView(R.layout.activity_food_info);
//        setTitle(Recipes.names[index]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment fragment = new DualPaneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//    public void onClick(View view) {
//        int id = view.getId();
//        switch (id){
//            case R.id.veg:
//                startActivity(new Intent(this, VegetableActivity.class));
//                finish();
//                break;
//            case R.id.solid:
//                startActivity(new Intent(this, SolidActivity.class));
//                finish();
//                break;
//            case  R.id.mushroom:
//                startActivity(new Intent(this, MushroomActivity.class));
//                finish();
//                break;
//            case R.id.legume:
//                startActivity(new Intent(this, LegumeActivity.class));
//                finish();
//                break;
//        }
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(this, MainActivity.class));
    }
}