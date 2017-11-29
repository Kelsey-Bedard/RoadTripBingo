package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_card);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainMenu.EXTRA_MESSAGE);

        // Message determines which card is being editted
        TextView textView = (TextView) findViewById(R.id.customCardText);
        textView.setText("Edit Custom Card " + message);
    }

    //User wants to exit custom card and return to main menu
    public void exitClick (View view){
        //Add warning that player is leaving without saving
        Intent intent = new Intent(this, BingoCard.class);
        startActivity(intent);
    }

    //User wants to save their custom card and return to main menu
    public void saveAndExitClick (View view){
        //Will save data from board here when before exiting

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
