package com.example.deltager.pointlessclicker;

import android.widget.Toast;

/**
 * Created by deltager on 07-07-17.
 */

public class Toaster {


    insultGenerator insult = new insultGenerator();
    public double chance = 1;
    public Toast toast;



    public int genRandomNum()   // Generate random number
    {
        int randomNum = (int) (Math.random() * 1000000);
        return randomNum;
    }



    public void makeToast(MainActivity activity) {
        String toastText = insult.getRandomInsult();

        if (genRandomNum() < 100 * chance) { // make 100 for best use
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(activity, toastText, Toast.LENGTH_LONG);
            toast.show();
            toast.show();
            toast.show();
            toast.show();
            chance = 1;

        } else {
            chance = chance * 1.15;
            System.out.println(chance);
        }

    }
}
