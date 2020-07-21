package com.elisvobs.roots;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.elisvobs.roots.fragments.DualPaneFragment;
import com.elisvobs.roots.fragments.GridFragment;
import com.elisvobs.roots.fragments.ListFragment;
import com.elisvobs.roots.utils.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {
    private static final String LIST_FRAGMENT = "list_fragment";
    private static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Bundle bundle = new Bundle();
    private FragmentTransaction fragmentTransaction;
    private AlertDialog.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.trad);

        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (! isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                ListFragment fragment = new ListFragment();
                transact(fragment);
            }
        }
        else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                GridFragment fragment = new GridFragment();
                transact(fragment);
            }
        }

    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        transactRecipe(index, fragment);
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment fragment = new DualPaneFragment();
        transactRecipe(index, fragment);
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
            startActivity(new Intent(this, AdditiveActivity.class));
            return true;
        } else if (id == R.id.action_settings) {
            startActivity(new Intent(this, LanguageActivity.class));
            return true;
        } else if (id == R.id.action_about) {
            showDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void transact(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.place_holder, fragment, LIST_FRAGMENT);
        fragmentTransaction.commit();
    }

    private void transactRecipe(int index, Fragment fragment) {
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.place_holder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.lic:
                licenseDialog();
                break;
            case R.id.priv:
                privacyDialog();
                break;
            case R.id.cred:
                creditsDialog();
                break;
        }
    }

    private void build(int p) {
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(p, null);
        mBuilder.setView(dialogView);
    }

    private void dialogComponents(int p) {
        mBuilder.setTitle(getResources().getString(p))
                .setPositiveButton(R.string.accept, (dialog, whichButton) -> showDialog())
                .setNegativeButton(R.string.refuse, (dialog, whichButton) -> showDialog())
                .create().show();
    }

    private void showDialog() {
        mBuilder = new AlertDialog.Builder(this);
        build(R.layout.dialog_about);
        mBuilder.setTitle(getResources().getString(R.string.none))
                .setPositiveButton(R.string.cancel, (dialog, whichButton)
                -> onBackPressed())
                .create().show();
    }

    private void licenseDialog() {
        mBuilder = new AlertDialog.Builder(this);
        build(R.layout.dialog_license);
        dialogComponents(R.string.license);
    }

    private void privacyDialog() {
        mBuilder = new AlertDialog.Builder(this);
        build(R.layout.dialog_privacy);
        dialogComponents(R.string.policy);
    }

    private void creditsDialog() {
        mBuilder = new AlertDialog.Builder(this);
        build(R.layout.dialog_credits);
        mBuilder.setTitle(getResources().getString(R.string.copy))
                .setPositiveButton(R.string.thanks, (dialog, whichButton)
                        -> showDialog()).create().show();
    }

}