package com.elisvobs.roots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_about);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showDialog();
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

    private void showDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_about, null);
        mBuilder.setView(dialogView);
        mBuilder.setTitle(getResources().getString(R.string.none))
                .setPositiveButton(R.string.cancel, (dialog, whichButton) -> finish())
                .create().show();
    }

    private void licenseDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_license, null);
        mBuilder.setView(dialogView);
        mBuilder.setTitle(getResources().getString(R.string.license))
                .setPositiveButton(R.string.accept, (dialog, whichButton) -> finish())
                .setNegativeButton(R.string.refuse, (dialog, whichButton) -> finish())
                .create().show();
    }

    private void privacyDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_privacy, null);
        mBuilder.setView(dialogView);
        mBuilder.setTitle(getResources().getString(R.string.policy))
                .setPositiveButton(R.string.accept, (dialog, whichButton) -> finish())
                .setNegativeButton(R.string.refuse, (dialog, whichButton) -> finish())
                .create().show();
    }

    private void creditsDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_credits, null);
        mBuilder.setView(dialogView);
        mBuilder.setTitle(getResources().getString(R.string.copy))
                .setPositiveButton(R.string.thanks, (dialog, whichButton) -> finish())
                .create().show();
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}