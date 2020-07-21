package com.elisvobs.roots;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    private Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        config = getBaseContext().getResources().getConfiguration();
        String lang = settings.getString("LANG", "");
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            localeConfig(lang, config);
        }
        showLanguageDialog();
    }

    public void showLanguageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        @SuppressLint("InflateParams")
        final View dialogView = inflater.inflate(R.layout.activity_language, null);
        builder.setView(dialogView);
        final RadioGroup radioGroup = dialogView.findViewById(R.id.radioGroup);

        builder.setTitle(getResources().getString(R.string.lang_dialog_title))
                .setPositiveButton(R.string.language_settings, (dialog, whichButton) -> {
                    int languagePosition = radioGroup.getCheckedRadioButtonId();
                    switch(languagePosition) {
                        case R.id.en: //English
                            changeLanguage("en");
                            finish();
                            break;
                        case R.id.sn: //Shona
                            changeLanguage("sn");
                            finish();
                            break;
                        case R.id.nr: //Ndebele
                            changeLanguage("nr");
                            finish();
                            break;
                        default: //By default set to english
                            break;
                    }
                }).setNegativeButton(R.string.cancel,
                (dialog, whichButton) -> finish()).create().show();
    }

    private void changeLanguage(String language) {
        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                edit().putString("LANG", language).apply();
        setLanguage(language);
    }

    public void setLanguage(String language) {
        config = getApplicationContext().getResources().getConfiguration();
        localeConfig(language, config);
    }

    private void localeConfig(String lang, Configuration config) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

}