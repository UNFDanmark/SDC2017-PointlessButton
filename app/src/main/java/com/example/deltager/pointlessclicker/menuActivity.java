package com.example.deltager.pointlessclicker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import static com.example.deltager.pointlessclicker.Save.loadAdjectivesList;
//import static com.example.deltager.pointlessclicker.Save.loadAdjectivesList;
import java.io.IOException;

import static com.example.deltager.pointlessclicker.insultGenerator.adjective;
import static com.example.deltager.pointlessclicker.insultGenerator.substantiv;

public class menuActivity extends AppCompatActivity {

    public Button backButton;
    public TextView addAdjective;
    public TextView addSubstantiv;
    public Button addAdjectiveButton;
    public Button addSubstantivButton;
    public Toast toast;
    public String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        backButton = (Button) findViewById(R.id.backButton);
        addSubstantiv = (TextView) findViewById(R.id.textAddNoun);
        addAdjective = (TextView) findViewById(R.id.textAddAdjective);
        addAdjectiveButton = (Button) findViewById(R.id.addAdjectiveButt);
        addSubstantivButton = (Button) findViewById(R.id.addSubstantivButt);
    }

    public void addAdjectiveToList(View view) throws IOException, ClassNotFoundException {
        String newAdjective = addAdjective.getText().toString();
        //adjective.add(newAdjective);
        action = newAdjective + " has been added to the dictionary";
        toast = Toast.makeText(this, action, Toast.LENGTH_SHORT);
        toast.show();
        addAdjective.setText("");
        Save.saveFiles(Save.returnSavedFiles(getApplicationContext()), newAdjective, getApplicationContext());
        System.out.println(Save.returnSavedFiles(getApplicationContext()));
    }
    public void addSubstantivToList(View view) {
        String newSubstantiv = addSubstantiv.getText().toString();
        substantiv.add(newSubstantiv);
        action = newSubstantiv + " has been added to the dictionary";
        toast = Toast.makeText(this, action, Toast.LENGTH_SHORT);
        toast.show();
        addSubstantiv.setText("");
        System.out.println(substantiv);
    }

    public void back(View view) {
        finish();
    }

}
