package com.elisvobs.roots;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.elisvobs.roots.fragments.DualPaneFragment;
import com.elisvobs.roots.fragments.GridFragment;
import com.elisvobs.roots.fragments.ListFragment;
import com.elisvobs.roots.fragments.ViewPagerFragment;
import com.elisvobs.roots.utils.MyPreferences;

public class Home extends AppCompatActivity implements
        ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        boolean isFirstTime = MyPreferences.isFirst(this);
        if (isFirstTime) {
                show(this);
        }

        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (! isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                ListFragment fragment = new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.place_holder, fragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }
        else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                GridFragment fragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.place_holder, fragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }
    }

    public static void show (Context context) {
        context.startActivity(new Intent(context, OnBoarding.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.place_holder, fragment, VIEWPAGER_FRAGMENT);
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
        fragmentTransaction.replace(R.id.place_holder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_additive) {
            startActivity(new Intent(this, Additive.class));
            return true;
//        } else if (id == R.id.action_settings) {
//            startActivity(new Intent(this, Language.class));
//            return true;
        } else if (id == R.id.action_about) {
            startActivity(new Intent(this, About.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}