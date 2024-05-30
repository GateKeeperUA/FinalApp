package com.example.app;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

public class AppPreferences {

    private static final String PREF_COLOR_KEY = "color_scheme";

    public static boolean isDaltonismEnabled(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(PREF_COLOR_KEY, false);
    }

    public static void setDaltonismEnabled(Context context, boolean isEnabled) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PREF_COLOR_KEY, isEnabled);
        editor.apply();
    }
}
