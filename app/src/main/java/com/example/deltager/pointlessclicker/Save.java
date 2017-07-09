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


    public static void saveFiles(ArrayList<String> oldAdjectives, String newAdjective, Context context) throws IOException {
        oldAdjectives.add(newAdjective);
        FileOutputStream saveFile = new FileOutputStream(context.getFilesDir() + "/saveFile.sav");
        ObjectOutputStream save = new ObjectOutputStream(saveFile);
        save.writeObject(oldAdjectives);
        save.close();
    }

    public static ArrayList<String> returnSavedFiles(Context context) {
        try {
            FileInputStream saveFile = new FileInputStream(context.getFilesDir() + "/saveFile.sav");
            ObjectInputStream restore = new ObjectInputStream(saveFile);
            ArrayList<String> savedAdjectives = (ArrayList<String>) restore.readObject();
            restore.close();
            return savedAdjectives;
        } catch (Exception e) {
            return new ArrayList<String>();
        }

    }

//    public static void saveFilesSub(ArrayList<String> oldSub, String newSub, Context context) throws IOException {
//        oldSub.add(newSub);
//        FileOutputStream saveFile = new FileOutputStream(context.getFilesDir() + "/saveFile2.sav");
//        ObjectOutputStream save = new ObjectOutputStream(saveFile);
//        save.writeObject(oldSub);
//        save.close();
//    }
//
//    public static ArrayList<String> returnSavedFilesSub(Context context) throws IOException, ClassNotFoundException {
//        try {
//            FileInputStream saveFile = new FileInputStream(context.getFilesDir() + "/saveFile2.sav");
//            ObjectInputStream restore = new ObjectInputStream(saveFile);
//            ArrayList<String> savedSub = (ArrayList<String>) restore.readObject();
//            restore.close();
//            return savedSub;
//        } catch (EOFException e) {
//            return new ArrayList<String>();
//        }
//
//    }


}

