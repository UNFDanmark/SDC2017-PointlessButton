package com.example.deltager.pointlessclicker;

import android.widget.Toast;

/**
 * Created by deltager on 07-07-17.
 */

public class Toaster {


    insultGenerator insult = new insultGenerator();
    public double chance = 1;
    public Toast toast;



    public static int genRandomNum()   // Generate random number
    {
        int randomNum = (int) (Math.random() * 1000000);
        return randomNum;
    }



    public void makeToast(MainActivity activity) {


        if (genRandomNum() < 100 * chance) {
            if (toast != null) {
                toast.cancel();
            }
            String toastText = insult.getRandomInsult();
            System.out.println(toastText);
            toast = Toast.makeText(activity, toastText, Toast.LENGTH_LONG);
            toast.show();
            toast.show();
            toast.show();
            toast.show();
            chance = 1;

        } else {
            chance *= 1.15;
            if (chance > 1000){
                System.out.println(chance);
            }
        }

    }
}
