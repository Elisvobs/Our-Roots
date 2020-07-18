package com.elisvobs.roots;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    private AlertDialog.Builder builder = new AlertDialog.Builder(this);
    private LayoutInflater inflater = this.getLayoutInflater();
    private View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_about);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showDialog();
    }

    @SuppressLint("InflateParams")
    private void showDialog() {
        dialogView = inflater.inflate(R.layout.activity_about, null);
        builder.setView(dialogView);

        builder.setTitle(getResources().getString(R.string.app_name))
                .setPositiveButton(R.string.eula, (dialog, whichButton) -> {
                    licenseDialog();
                })
                .setNegativeButton(R.string.privacy, (dialog, whichButton) -> {
                    privacyDialog();
                })
                .create().show();
    }

    @SuppressLint("InflateParams")
    private void licenseDialog() {
        dialogView = inflater.inflate(R.layout.dialog_license, null);
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
        dialogView = inflater.inflate(R.layout.dialog_privacy, null);
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

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(this, MainActivity.class));
//        finish();
//    }

}