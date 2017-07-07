package com.example.deltager.pointlessclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private long clickCounter = 0;  // Variables
    public TextView counter;
    public ImageButton red;
    public ImageButton mute;
    public ImageButton menu;
    public EditText addAdjective;
    public EditText addNickName;

    Toaster toaster = new Toaster();

    // ved app start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = (ImageButton) findViewById(R.id.redButt);     // Path to layout objects

        mute = (ImageButton) findViewById(R.id.soundMute);
        menu = (ImageButton) findViewById(R.id.menuButt);
        counter = (TextView) findViewById(R.id.clickText);
        addNickName = (EditText) findViewById(R.id.addNickName);
        addAdjective = (EditText) findViewById(R.id.addAdjective);
    }

    //click counter
    public void click(View view) {
        updateClickCounter();
        toaster.makeToast(this);
    }

    public void updateClickCounter()    // UpdateClickCounter
    {
        clickCounter++;
        counter.setText("Clicks: " + clickCounter);
    }

    public void updateSoundSetting() {

    }


    public void interactMenu() {

    }


}