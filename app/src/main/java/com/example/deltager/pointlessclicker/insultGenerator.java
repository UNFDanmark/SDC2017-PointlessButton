package com.example.deltager.pointlessclicker;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by deltager on 06-07-17.
 */

public class insultGenerator {
    //Hent context. Skal bruges i getContact
    private Context context;

    public Boolean onetime = false;
    public double chanceadd = 1;


    static ArrayList<String> startSentence = new ArrayList<String>();

    static {
        startSentence.add("You look like ");
        startSentence.add("You smell of ");
        startSentence.add("Your mother is ");
        startSentence.add("Your house smells of ");
        startSentence.add("Did you know that your girlfriend looks like ");
        startSentence.add("Please, just leave me alone. I don't want to talk to ");
        startSentence.add("God, go away, I don't want to be seen with ");
        startSentence.add("Your room probably looks like ");
        startSentence.add("Your right foot smells like ");
        startSentence.add("I bet you run like ");
        startSentence.add("You avoid responsibilities like ");
        startSentence.add("You act like ");
        startSentence.add("You cut grass like ");
        startSentence.add("You eat like ");
        startSentence.add("You sleep like ");
        startSentence.add("I bet you make love like ");
        startSentence.add("You hit like ");
        startSentence.add("You kiss like ");
        startSentence.add("You Program code like ");
        startSentence.add("Your dog probably eats ");
        startSentence.add("I bet your cat likes licking ");
        startSentence.add("Your planning is just as bad as ");
        startSentence.add("OH yeah, click me harder! OH, daddy, click me like ");
    }

    public String getRandomStartSentence() {
        int randomStartSentence = (int) (Math.random() * startSentence.size());
        return startSentence.get(randomStartSentence);
    }

    static ArrayList<String> adjective = new ArrayList<String>();

    static {
        adjective.add("a fat ");
        adjective.add("an ugly ");
        adjective.add("a smelly ");
        adjective.add("a useless ");
        adjective.add("an ignorant ");
        adjective.add("a sloppy ");
        adjective.add("a disastrous ");
        adjective.add("a lazy ");
        adjective.add("a boring ");
        adjective.add("an retarded ");
        adjective.add("a weird looking ");
        adjective.add("an awkward ");
        adjective.add("a bossy ");
        adjective.add("a compulsive ");
        adjective.add("a fussy ");
        adjective.add("a gullible ");
        adjective.add("an irresponsible ");
        adjective.add("a moody ");
        adjective.add("a narrow-minded ");
        adjective.add("an overemotional ");
        adjective.add("a sarcastic ");
        adjective.add("an unreliable ");
        adjective.add("a moist ");
    }

    public String getRandomAdjective() {

        int randomAdjective = (int) (Math.random() * adjective.size());
        return adjective.get(randomAdjective);
    }

    static ArrayList<String> substantiv = new ArrayList<String>();

    static {
        substantiv.add("lawnmower!");
        substantiv.add("washing machine");
        substantiv.add("dishwasher");
        substantiv.add("monkey");
        substantiv.add("lazy, yet delightful woman");
        substantiv.add("idiot!");
        substantiv.add("retard!");
        substantiv.add("soap gobbler");
        substantiv.add("muggle!");
        substantiv.add("piece of cupcake fill, that no one even bothers to check in on. Really, you should go outside");
        substantiv.add("white piece of slightly rotten bread");
        substantiv.add("soul sucking dementor from Harry Potter.");
        substantiv.add("stuck-up, half-witted, scruffy-looking nerf herder!");
        substantiv.add("leather hat!");
        substantiv.add("shroomwad");
        substantiv.add("piece of paper");
        substantiv.add("jerkbucket");
        substantiv.add("fartface");
        substantiv.add("elderberry");
        substantiv.add("fartnugget");
        substantiv.add("fishface");
        substantiv.add("fudgefiller");
        substantiv.add("cupcake");
        substantiv.add("doodledood");
        substantiv.add("Harry Potter looking fellow");

    }

    public String getRandomSubstantiv() {

        int randomSubstantiv = (int) (Math.random() * substantiv.size());
        return substantiv.get(randomSubstantiv);
    }

    public String getRandomInsult() {

        // time
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        // time end  (use hour as int, number 0-23)
        if (hour >= 20 && onetime == false && Toaster.genRandomNum() < 800 * chanceadd
                || hour <= 3 && onetime == false && Toaster.genRandomNum() < 800 * chanceadd) {

            String insult = "You should go to sleep you " + getRandomSubstantiv();
            onetime = true;
            return insult;
        } else {
            if (hour < 20 || hour > 3) {
                onetime = false;
            }
            chanceadd *= 1.25;

            String insult = getRandomStartSentence() + getRandomAdjective() + getRandomSubstantiv();
            return insult;
        }

    }


    public void addSubstantiv(String addedSubstantiv) {
        // when user writes
        // add string X to Arraylist
        substantiv.add(addedSubstantiv);


    }

    public String getContact(MainActivity activity) {
        Cursor managedCursor = activity.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int size = managedCursor.getCount();


        String contactName = "contactName";

        return contactName;
    }


}
