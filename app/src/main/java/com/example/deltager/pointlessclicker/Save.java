package com.example.deltager.pointlessclicker;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by deltager on 08-07-17.
 */

public class Save {

    public static void save (long currentScore, Context context) {

        // Handle to Shared Preferences
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);

        //Write to shared Preferences
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("score", currentScore);
        editor.commit();
    }

    public static long load (Context context)
    {
        // Read from shared Preferences
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);
        return sharedPref.getLong("score", 0);
    }
}

