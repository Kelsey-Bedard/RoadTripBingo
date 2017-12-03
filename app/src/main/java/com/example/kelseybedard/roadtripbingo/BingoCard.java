package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BingoCard extends AppCompatActivity {

    BingoManager manager = new BingoManager();
    int[] checkMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_card);
        //This is were we will set the card up based on if it was custom or random

        TextView cardText = (TextView) findViewById(R.id.customCardText);
        TextView gameTypeText = (TextView) findViewById(R.id.gameTypeText);

        //SET THE TEXTVIEW ONCE WE CAN PASS THE DATA TO THE ITEM

        //Use this tutorial to add items to grid view
        //https://developer.android.com/guide/topics/ui/layout/gridview.html

        //gridView that contrains x's
        final Button bingoButton = (Button) findViewById(R.id.BingoButton);
        bingoButton.setClickable(false);
        manager.setCardAsBlank();
         checkMarks= manager.card.getImages();
        final GridView xGrid = (GridView)findViewById(R.id.xGridView);
        final ImageAdaptor imageAdaptor = new ImageAdaptor(this, checkMarks);
        xGrid.setAdapter(imageAdaptor);

        //sets bottom gridView to icons
        manager.setCardAsRandom();
        final GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdaptor(this, manager.card.getImages()));

        listener();
    }

    //Player want to exit the game and return to main menu
    public void exitClick (View v){
        Intent intent = new Intent(this,ExitClick.class);
        startActivityForResult(intent,1);
    }

    //https://stackoverflow.com/questions/14292398/how-to-pass-data-from-2nd-activity-to-1st-activity-when-pressed-back-android
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                finish();
            }
        }
    }
    //Player wants to clear their card
    public void clearClick (View v){
        //Add warning that player is clearing card
        for (int i = 0; i<25; i++){
            checkMarks[i] = R.drawable.blank_tile;
        }
        checkMarks[12] = R.drawable.x;
        manager.card.clearCard();
        listener();
    }

    //A player gets a bingo
    public void bingoClick(View v){
        //pop up menu get activated here?
    }

    private void listener (){
        final Button bingoButton = (Button) findViewById(R.id.BingoButton);
        bingoButton.setClickable(false);
        final ImageAdaptor imageAdaptor = new ImageAdaptor(this, checkMarks);
        final GridView xGrid = (GridView)findViewById(R.id.xGridView);
        xGrid.setAdapter(imageAdaptor);
        xGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long itemId) {
                manager.card.toggleSelectedTile(position);
                if (checkMarks[position] != R.drawable.x){
                    checkMarks[position] = R.drawable.x;
                    imageAdaptor.changeImages(checkMarks);
                }
                else {
                    checkMarks[position] = R.drawable.blank_tile;
                    imageAdaptor.changeImages(checkMarks);
                }

                boolean check = manager.card.checkBingo("Line");
                if (check){  //Bingo Button is click on able
                    bingoButton.setClickable(true);
                }
                else {
                    bingoButton.setClickable(false);

                }

            }
        });
    }
}
