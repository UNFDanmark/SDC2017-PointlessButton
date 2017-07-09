package com.example.deltager.pointlessclicker;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

import static com.example.deltager.pointlessclicker.Save.returnSavedFiles;

public class MainActivity extends AppCompatActivity {
    public long clickCounter;  // Variables
    public static TextView score;
    public TextView textInsult;
    public ImageButton red;
    public ImageButton mute;
    public ImageButton menu;
    insultGenerator insult;
    Toaster toaster;
    public Boolean mutesound = false;
    public double chance = 1;

    // ved app start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insult = new insultGenerator(getApplicationContext());  //Generates random text
        toaster = new Toaster(insult);
        red = (ImageButton) findViewById(R.id.redButt);     // Path to layout objects
        mute = (ImageButton) findViewById(R.id.mute);
        menu = (ImageButton) findViewById(R.id.menuButt);
        score = (TextView) findViewById(R.id.clickText);
        red.setSoundEffectsEnabled(false);
        textInsult = (TextView) findViewById(R.id.textInsult);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 123);
        }

    }

    public void notification() {
        String NotificationText = insult.getRandomNotification();
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.tabicon_red)
                .setContentTitle("Pointless Button")
                .setContentText(NotificationText);

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

    public static int genRandomNum() {   // Generate random number{
        int randomNum = (int) (Math.random() * 1000000);
        return randomNum;
    }

    //click counter
    public void click(View view) throws IOException, ClassNotFoundException {
//        System.out.println(Save.returnSavedFiles(getApplicationContext()));
        updateClickCounter();


        if (mutesound == false) {
            final MediaPlayer sound = MediaPlayer.create(this, R.raw.clicksound);

            sound.setAudioStreamType(AudioManager.STREAM_MUSIC);
            sound.start();
            new CountDownTimer(500, 500) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    sound.release();
                }
            }.start();
        }
        if (genRandomNum() < 100 * chance) { // make 100 for best use

            if (genRandomNum() < 10 * chance) { //Chance to get contact
                String toastTextContact = insult.getRandomContact();
                textInsult.setText(toastTextContact);
                chance = 1;
            } else {
                String toastText = insult.getRandomInsult();
                System.out.println(toastText);
                textInsult.setText(toastText);
                chance = 1;

            }

        } else {
            chance *= 1.15;
            if (chance > 1000) {
                System.out.println(chance);
            }
        }


    }

    public void updateClickCounter()    // UpdateClickCounter
    {
        clickCounter++;
        score.setText(String.valueOf("Clicks: " + clickCounter));
        Save.save(clickCounter, getApplicationContext());
    }

    public void interactMenu(View view) {
        Intent menu = new Intent(this, menuActivity.class);
        startActivity(menu);
    }

    public void onStop() {
        super.onStop();

        int index = (int) (Math.random() * Math.random() * 600);
        new CountDownTimer(index * 60 * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                notification();
            }
        }.start();
    }


    public void onPause() {
        super.onPause();
        Save.save(clickCounter, getApplicationContext());
    }

    public void onResume() {
        super.onResume();
        clickCounter = Save.load(getApplicationContext());
        score.setText(String.valueOf("Clicks: " + clickCounter));
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
        insultGenerator.addAdjectives(Save.returnSavedFiles(getApplicationContext()), getApplicationContext());
        insultGenerator.addAdjectives(Save.returnSavedFiles(getApplicationContext()), getApplicationContext());
        insultGenerator.addSub(Save.returnSavedFilesSub(getApplicationContext()), getApplicationContext());


    }

    public void mutesound(View view) {
        if (mutesound) {
            mute.setImageResource(R.mipmap.unmuted);

        } else {
            mute.setImageResource(R.mipmap.mutedasset);

        }
        mutesound = !mutesound;
    }


}