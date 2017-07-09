package com.example.deltager.pointlessclicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;



import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by deltager on 08-07-17.
 */

public class Save {

    //static ArrayList newAdjectiveList = new ArrayList<String>();



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
    /*

    public static void saveAdjective(Set<String> newAdjective,Context context) {
        ArrayList newAdjectiveList = new ArrayList<String>();
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);
        newAdjective = sharedPref.getStringSet("adjectives", new HashSet<String>());
        newAdjectiveList.add(newAdjective);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("newAdjectiveList", new HashSet<String>());
        editor.commit();


        //editor.putStringSet("adjectives", adjectives);
    }

    /*public static ArrayList<String> loadAdjectivesList(Context context) {
        // Read from shared Preferences
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);
        return new ArrayList<String>(sharedPref.getStringSet("adjectives", new HashSet<String>()));
    }

    public static ArrayList<String> loadAdjectivesList(Context context) {
        // Read from shared Preferences
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key), Context.MODE_PRIVATE);
        String newAdjective = sharedPref.getString("newAdjective", null);
        newAdjectiveList.add(newAdjective);

        return newAdjectiveList; }*/

    public static void saveFiles(ArrayList<String> oldAdjectives, String newAdjective, Context context) throws IOException {
        oldAdjectives.add(newAdjective);
        FileOutputStream saveFile = new FileOutputStream(context.getFilesDir() + "/saveFile.sav");
        ObjectOutputStream save = new ObjectOutputStream(saveFile);
        save.writeObject(oldAdjectives);
        save.close();
    }

    public static ArrayList<String> returnSavedFiles(Context context) throws IOException, ClassNotFoundException {
        try {
            FileInputStream saveFile = new FileInputStream(context.getFilesDir() + "/saveFile.sav");
            ObjectInputStream restore = new ObjectInputStream(saveFile);
            ArrayList<String> savedAdjectives = (ArrayList<String>) restore.readObject();
            restore.close();
            return savedAdjectives;
        } catch (EOFException e) {
            return new ArrayList<String>();
        }

    }


}

