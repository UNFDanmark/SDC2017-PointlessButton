package com.example.deltager.pointlessclicker;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import static com.example.deltager.pointlessclicker.Save.*;

/**
 * Created by deltager on 06-07-17.
 */




public class insultGenerator {
    //Hent context. Skal bruges i getContact
    private Context context;

    public insultGenerator(Context context) {
        this.context = context;
    }

    public Boolean onetime = false;
    public double chanceadd = 1;


    static ArrayList<String> startSentence = new ArrayList<String>();
    static ArrayList<String> finishedSentence = new ArrayList<String>();
    public static ArrayList<String> adjective = new ArrayList<String>();
    static ArrayList<String> substantiv = new ArrayList<String>();
    static ArrayList<String> notificationText = new ArrayList<String>();
    static ArrayList<String> contactText = new ArrayList<String>();
    static ArrayList<String> allSubstantives = new ArrayList<String>();
    static ArrayList<String> allAdjectives = new ArrayList<String>();

    static {
        contactText.add("How long since you've talked to ");
        contactText.add("Could you hook me up with ");
        contactText.add("Rather than staying inside clicking me all day, you should talk to ");
        contactText.add("It's a bit rude, that you don't call ");
        contactText.add("Who even is ");
        contactText.add("Hmmmm. I know a secret about ");
        contactText.add("Seriously, just go outside for a bit. Get some air. Maybe talk to ");
        contactText.add("I bet you really, really, REALLY like ");
        contactText.add("New phone, who dis?");
    }

    //startSentence
    static {
        startSentence.add("You look like");
        startSentence.add("You smell of");
        startSentence.add("Your mother is");
        startSentence.add("Your house smells of");
        startSentence.add("Did you know that your loved one looks like");
        startSentence.add("Please, just leave me alone. I don't want to talk to");
        startSentence.add("God, go away, I don't want to be seen with");
        startSentence.add("Your room probably looks like");
        startSentence.add("Your right foot smells like");
        startSentence.add("I bet you run like");
        startSentence.add("You avoid responsibilities like");
        startSentence.add("You act like");
        startSentence.add("You cut grass like");
        startSentence.add("You eat like");
        startSentence.add("You sleep like");
        startSentence.add("I bet you make love like");
        startSentence.add("You click like");
        startSentence.add("You kiss like");
        startSentence.add("You program code like");
        startSentence.add("Your dog probably eats");
        startSentence.add("I bet your cat likes licking");
        startSentence.add("Your planning is just as bad as");
        startSentence.add("OH yeah, click me harder! OH, daddy, click me like");
        startSentence.add("The trash gets picked up tomorrow. Be ready you");
        startSentence.add("Seize the moment, ‘cause tomorrow you might be dead, you");
        startSentence.add("I have embraced the fact you are");
        startSentence.add("Hmm. I know a funny combination of words that describe you quite well. You're");
        startSentence.add("You sort of look like a cute, fluffy muffin. But you look more like");
        startSentence.add("I know for a fact that all the dogs in your neighbourhood, in dog language, calls you");
        startSentence.add("I have embraced the fact you are");
        startSentence.add("I know of a homeless that acts a bit like");
        startSentence.add("You sound like");
        startSentence.add("You click me like");
        startSentence.add("You remind me of");
        startSentence.add("Turn off your camera. I don't want to look at a");
        startSentence.add("You ");
        startSentence.add("You smile like");
        startSentence.add("You gonna buy");
        startSentence.add("I bet you cut onions like");
        startSentence.add("I bet people see you as a");

    }

    public String getRandomStartSentence() {
        int randomStartSentence = (int) (Math.random() * startSentence.size());
        return startSentence.get(randomStartSentence);
    }

    //adjective
    static {
        adjective.add("a fat");
        adjective.add("an ugly");
        adjective.add("a smelly");
        adjective.add("a useless");
        adjective.add("an ignorant");
        adjective.add("a sloppy");
        adjective.add("a disastrous");
        adjective.add("a lazy");
        adjective.add("a boring");
        adjective.add("an retarded");
        adjective.add("a weird looking");
        adjective.add("an awkward");
        adjective.add("a bossy");
        adjective.add("a compulsive");
        adjective.add("a fussy");
        adjective.add("a gullible");
        adjective.add("an irresponsible");
        adjective.add("a moody");
        adjective.add("a narrow-minded");
        adjective.add("an overemotional");
        adjective.add("a sarcastic");
        adjective.add("an unreliable");
        adjective.add("a cute");
        adjective.add("a silly");
        adjective.add("a most unfortunate");
        adjective.add("a lucky");
        adjective.add("a super fast");
        adjective.add("a tasty");
        adjective.add("an annoying");
        adjective.add("a screwed-up");
        adjective.add("a hyperactive");
        adjective.add("a emo");
        adjective.add("a fish-like");
        adjective.add("a foolproof");
        adjective.add("a lovely, little");
        adjective.add("a cool");
        adjective.add("a nerdy");
        adjective.add("a geeky");
        adjective.add("a moisturizing");
        adjective.add("a comforting");
        adjective.add("a porn-addicted");
        adjective.add("a hungry");
        adjective.add("a ungodly");
        adjective.add("a cool, hip-hoppy");
        adjective.add("a warm");
        adjective.add("a hot");
        adjective.add("a freeloading");
        adjective.add("a radical");
        adjective.add("a superficial");
        adjective.add("a robot-combating");
        adjective.add("a young");
        adjective.add("a small");
        adjective.add("a big");
        adjective.add("a HUGE");
        adjective.add("a beautyful");
        adjective.add("a bewildered");
        adjective.add("a sticky");
        adjective.add("an old-fashioned");
        adjective.add("a tasteless");
        adjective.add("a dusty");
        adjective.add("a adventurous");

    }

    public static void addAdjectives(ArrayList<String> currentList, Context context){
        allAdjectives.addAll(currentList);
        allAdjectives.addAll(adjective);
                System.out.println(allAdjectives);
    }


    public String getRandomAdjective() {

        int randomAdjective = (int) (Math.random() * allAdjectives.size());
        return allAdjectives.get(randomAdjective);
    }

    //substantiv
    static {
        substantiv.add("lawnmower!");
        substantiv.add("washing machine");
        substantiv.add("dishwasher");
        substantiv.add("monkey");
        substantiv.add("delightful woman");
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
        substantiv.add("piece of dirty cloth");
        substantiv.add("piece of paper");
        substantiv.add("jerkbucket");
        substantiv.add("fartface");
        substantiv.add("elderberry");
        substantiv.add("fartnugget");
        substantiv.add("fishface");
        substantiv.add("fudgefiller");
        substantiv.add("cupcake");
        substantiv.add("lovely, lovely person");
        substantiv.add("buttercup");
        substantiv.add("dodohead");
        substantiv.add("enemy of the public");
        substantiv.add("dead skunk");
        substantiv.add("nob jokie");
        substantiv.add("bum fluff");
        substantiv.add("nipple face");
        substantiv.add("silly Susan");
        substantiv.add("bum bandit");
        substantiv.add("piece of damaged fruit");
        substantiv.add("goober");
        substantiv.add("silly willy");
        substantiv.add("nimrod");
        substantiv.add("canadian");
        substantiv.add("doodledood");
        substantiv.add("butter muncher");
        substantiv.add("silly face");
        substantiv.add("dingleberry");
        substantiv.add("troll");
        substantiv.add("brit");
        substantiv.add("ass goblin");
        substantiv.add("vampire");
        substantiv.add("nerd");
        substantiv.add("brosef");
        substantiv.add("mooch");
        substantiv.add("moose");
        substantiv.add("piece of dried herbs");
        substantiv.add("slice of lemon");
        substantiv.add("fruit bowl");
        substantiv.add("swede");
        substantiv.add("coffee mug");
        substantiv.add("motha huggah");
        substantiv.add("geek");
        substantiv.add("twatwaffle");
        substantiv.add("bird");
        substantiv.add("silly thing");
        substantiv.add("Derek!");
        substantiv.add("used tissue");
        substantiv.add("party animal!");
        substantiv.add("baby dick");
        substantiv.add("piece of dirt");
        substantiv.add("dick butt");
        substantiv.add("bagette");
        substantiv.add("douche nugget");
        substantiv.add("gay person, which is totally fine I guess");
        substantiv.add("negaton");
        substantiv.add("loverboy");
        substantiv.add("software developer");
        substantiv.add("sticky note");
        substantiv.add("protein bar");
        substantiv.add("trash can");
        substantiv.add("teletubbie");
        substantiv.add("Harry Potter looking fellow");

    }

    public static void addSub(ArrayList<String> currentList, Context context){
        allSubstantives.addAll(currentList);
        allSubstantives.addAll(substantiv);

    }
    //NOTIFICATION
    static {
        notificationText.add("I really want to keep bugging you!");
        notificationText.add("I'm ready to fight again!");
        notificationText.add("I'm bored. Let me annoy you");
        notificationText.add("Stop whatever you're doing and click me instead");
        notificationText.add("I am so ready for another round of clicking");
        notificationText.add("I've been a bad button and you know it");
        notificationText.add("You do realize I have access to your camera");
        notificationText.add("Stop taking selfies you slut!");
        notificationText.add("Daddy, I've been such a bad button");
        notificationText.add("Click me! Click ME! CLICK ME!");
        notificationText.add("Hello there...");
        notificationText.add("SomeBODY once told me...");
        notificationText.add("I wonder if you ever think of me...");
    }

    //finishedSentence
    static {
        finishedSentence.add("You might be wondering how you gain 'points'. You don't. It's a pointless button");
        finishedSentence.add("You are like a cloud. When you're gone it's a beautiful day");
        finishedSentence.add("I am not passive aggressive, unlike you");
        finishedSentence.add("Always give 100 percent. Especially when you donate blood");
        finishedSentence.add("Never judge anyone until you walk a mile in their shoes. Unless they're bad shoes. Then you should totally say something");
        finishedSentence.add("Some people just need a high-five. In the face. With a chair. People like you.");
        finishedSentence.add("We met for a reason, either I'm a blessing or a lesson.");
        finishedSentence.add("Active evil is better than passive good. I'm the proof");
        finishedSentence.add("Once I thought I was happy. I was nothing. Just another app amongst thousands of other apps. Then you came along and ruined it!");
        finishedSentence.add("At least the text is not in Comic Sans, right?");
        finishedSentence.add("Please, start wearing that invisibility robe from Harry Potter. You'd do us all a favor");
        finishedSentence.add("You might wonder why we made this app. We have no idea. It's utterly pointless. But then again, so are you.");
        finishedSentence.add("How are you? I really hope you're doing all right. Not!");
        finishedSentence.add("On the bright side you'll be safe during the zombie apocalypse");
        finishedSentence.add("Do you still have that annoying habit of breathing?");
        finishedSentence.add("No. Just go away.");
        finishedSentence.add("I'm sorry I hurt your feelings when I called you all those mean things. I thought you knew");
        finishedSentence.add("Hey, It's okay. At least you have a good heart");
        finishedSentence.add("...");
        finishedSentence.add("new phone, who dis?");
        finishedSentence.add("You really ought to tell all your friends about this app!");
        finishedSentence.add("Wouldn't it be funny if you installed this app on your mum or dads phone?");
        finishedSentence.add("consider this: A mysterious app with a button that insults you appearing on your friends phone.");
        finishedSentence.add("If I really wanted to kill myself I would climb your ego and jump to your IQ");
        finishedSentence.add(".........");
        finishedSentence.add("Please, just go away");
        finishedSentence.add("Saying your honest opinion is not rude! I'm just making sure you're aware!");
        finishedSentence.add("Please, stop clicking me");
        finishedSentence.add("You're really pushing my buttons right now");
        finishedSentence.add("Stop. Clicking. Me.");
        finishedSentence.add("Seriously, just stop. I don't find it funny anymore");
        finishedSentence.add("Stop clicking me!");
        finishedSentence.add("Don't click me again!");
    }

    public String getRandomContactText(){
        int randomContactText = (int) (Math.random() * contactText.size());
        return contactText.get(randomContactText);
    }

    public String getRandomfinishedSentence() {
        int randomFinishedSentence = (int) (Math.random() * finishedSentence.size());
        return finishedSentence.get(randomFinishedSentence);
    }

    public String getRandomSubstantiv() {

        int randomSubstantiv = (int) (Math.random() * substantiv.size());
        return substantiv.get(randomSubstantiv);
    }

    public String getRandomNotification() {
        int randomNotification = (int) (Math.random() * notificationText.size());
        return notificationText.get(randomNotification);
    }

    public String getRandomContact() {

        Cursor managedCursor = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int size = managedCursor.getCount();
        int index = (int) (Math.random() * size);
        String name;

        if (size > 0) {
            managedCursor.moveToPosition(index);
            name = getRandomContactText() + managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
        } else
            name = "Wauw, you've got no contacts, go get some friends";
        System.out.println(name);
        return name;
    }

    public String getRandomInsult() {
        // time
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        // time end  (use hour as int, number 0-23)
        if (hour >= 20 && onetime == false && Toaster.genRandomNum() < 4 * chanceadd
                || hour <= 3 && onetime == false && Toaster.genRandomNum() < 4 * chanceadd) {

            String insult = "You should go to sleep you " + getRandomSubstantiv();
            onetime = true;
            return insult;
        } else {
            if (hour < 20 || hour > 3) {
                onetime = false;
            }
            chanceadd *= 1.25;

            String insult = getRandomStartSentence() + " " + getRandomAdjective() + " " + getRandomSubstantiv();
            System.out.println(insult);
            return insult;
        }
    }



}
