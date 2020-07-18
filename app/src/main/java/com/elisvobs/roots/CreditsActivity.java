package com.elisvobs.roots;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CreditsActivity extends AppCompatActivity {
    private AlertDialog.Builder builder = new AlertDialog.Builder(this);
    private LayoutInflater inflater = this.getLayoutInflater();
    @SuppressLint("InflateParams")
    final View dialogView = inflater.inflate(R.layout.activity_credits, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_credits);

        showDialog();
    }

    private void showDialog() {
        builder.setView(dialogView);
        builder.setTitle(getResources().getString(R.string.copy))
                .setPositiveButton(R.string.thanks, (dialog, whichButton)
                        -> finish()).create().show();
    }

}