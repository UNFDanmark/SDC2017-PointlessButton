package com.example.deltager.pointlessclicker;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
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
        insult = new insultGenerator(getApplicationContext());
        toaster = new Toaster(insult);

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

    public void onStop() {
        super.onStop();
        new CountDownTimer(1000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                notification();
            }

        }.start();
    }

    public void notification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.tabicon_red)
                .setContentTitle("Come back!")


                .setContentText("I really want to keep bugging you!");

        Intent resultIntent = new Intent(this, MainActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());
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