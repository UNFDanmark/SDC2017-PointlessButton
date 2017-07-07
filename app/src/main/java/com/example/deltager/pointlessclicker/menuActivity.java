package com.example.deltager.pointlessclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class menuActivity extends AppCompatActivity {

    public Button backButton;
    public TextView addName;
    public TextView addAdjective;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        backButton = (Button)findViewById(R.id.backButton);
        addName = (TextView)findViewById(R.id.addName);
        addAdjective = (TextView)findViewById(R.id.addAdjective);
    }

    public void back(View view)
    {
        finish();
    }
}
