package com.example.deltager.pointlessclicker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public long clickCounter;  // Variables
    public static TextView score;
    public ImageButton red;
    public ImageButton mute;
    public ImageButton menu;

    insultGenerator insult;
    Toaster toaster;

    // ved app start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = (ImageButton) findViewById(R.id.redButt);     // Path to layout objects
        mute = (ImageButton) findViewById(R.id.soundMute);
        menu = (ImageButton) findViewById(R.id.menuButt);
        score = (TextView) findViewById(R.id.clickText);

        insult   =  new insultGenerator(getApplicationContext());
        toaster  =  new Toaster(insult);

    }

    //click counter
    public void click(View view) {
        updateClickCounter();
        toaster.makeToast(this);
    }

    public void updateClickCounter()    // UpdateClickCounter
    {
        clickCounter++;
        score.setText(String.valueOf("Clicks: " + clickCounter));

    }

    public void interactMenu(View view) {
        Intent menu = new Intent(this, menuActivity.class);
        startActivity(menu);
    }

    public void onPause(){
        super.onPause();
        Save.save(clickCounter, getApplicationContext());
    }


    public void onResume(){
        super.onResume();
        clickCounter = Save.load(getApplicationContext());
        score.setText(String.valueOf("Clicks: " + clickCounter));

    }
}