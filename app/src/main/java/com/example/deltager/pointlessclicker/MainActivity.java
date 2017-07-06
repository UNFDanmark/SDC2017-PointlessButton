package com.example.deltager.pointlessclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Variables
    private long clickCounter = 0;
    TextView counter;
    ImageButton red;

    // ved app start
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Path to layout objects
        red = (ImageButton) findViewById(R.id.redButt);
        counter = (TextView) findViewById(R.id.clickText);
    }

    public int genRandomNum()                                               // Generate random number
    {
        int randomNum = (int) (Math.random() * 1000);
        System.out.println(randomNum);                                      // Print out the value of randomNum
        return randomNum;
    }

    public void updateClickCounter()                                        // UpdateClickCounter
    {
        clickCounter ++;
        counter.setText("Clicks: " + clickCounter);
    }

    // Click counter
    public void click (View view)
    {
        updateClickCounter();
        makeToast();
    }

    public void makeToast () {
        String toastText = "Cancer";

        if (genRandomNum() < 200) {
            Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        }
    }
}
