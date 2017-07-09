package com.example.deltager.pointlessclicker;

import android.os.CountDownTimer;
import android.widget.Toast;

/**
 * Created by deltager on 07-07-17.
 */


public class Toaster {


    private static final int LONG_DELAY = 35000;
    public insultGenerator insult;
    public double chance = 1;
    public Toast toast;

    public Toaster(insultGenerator insult) {
        this.insult = insult;
    }


    public static int genRandomNum()   // Generate random number
    {
        int randomNum = (int) (Math.random() * 1000);
        return randomNum;
    }
}
