package com.elisvobs.roots;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_about);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showDialog();
    }

    @SuppressLint("InflateParams")
    private void showDialog() {
        builder = new AlertDialog.Builder(this);
        inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_about, null);
        builder.setView(dialogView);

        builder.setTitle("")
//                .setPositiveButton(R.string.eula, (dialog, whichButton) -> {
//                    licenseDialog();
//                })
//                .setNegativeButton(R.string.privacy, (dialog, whichButton) -> {
//                    privacyDialog();
//                })
                .create().show();
    }

    @SuppressLint("InflateParams")
    private void licenseDialog() {
        builder = new AlertDialog.Builder(this);
        final View dialogView = inflater.inflate(R.layout.dialog_license, null);
        builder.setView(dialogView);

        builder.setTitle(getResources().getString(R.string.license))
                .setPositiveButton(R.string.accept, (dialog, whichButton) -> {
                    finish();
                })
                .setNegativeButton(R.string.refuse, (dialog, whichButton) -> {
                    finish();
                })
                .create().show();
    }

    @SuppressLint("InflateParams")
    private void privacyDialog() {
        builder = new AlertDialog.Builder(this);
        final View dialogView = inflater.inflate(R.layout.dialog_privacy, null);
        builder.setView(dialogView);

        builder.setTitle(getResources().getString(R.string.policy))
                .setPositiveButton(R.string.accept, (dialog, whichButton) -> {
                    finish();
                })
                .setNegativeButton(R.string.refuse, (dialog, whichButton) -> {
                    finish();
                })
                .create().show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}