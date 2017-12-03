package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
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

        //Use this tutorial to add items to grid view
        //https://developer.android.com/guide/topics/ui/layout/gridview.html
        BingoManager manager = new BingoManager();
        manager.setCardAsEditor();
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdaptor(this,manager.card.getImages()));
    }

    //User wants to exit custom card and return to main menu
    public void exitClick (View view){
        Intent intent = new Intent(this,ExitClick.class);
        startActivityForResult(intent,2);
    }

    //https://stackoverflow.com/questions/14292398/how-to-pass-data-from-2nd-activity-to-1st-activity-when-pressed-back-android
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if(resultCode == RESULT_OK) {
                finish();
            }
        }
    }

    //User wants to save their custom card and return to main menu
    public void saveAndExitClick (View view){
        //Will save data from board here when before exiting
        finish();
    }
}
