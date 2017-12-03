package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class BingoCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_card);
        //This is were we will set the card up based on if it was custom or random

        //Use this tutorial to add items to grid view
        //https://developer.android.com/guide/topics/ui/layout/gridview.html
        BingoManager manager = new BingoManager();
        manager.setCardAsRandom();
        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdaptor(this, manager.card.getImages()));
    }

    //Player want to exit the game and return to main menu
    public void exitClick (View v){
        //Add warning that player is leaving
        finish();
    }

    //Player wants to clear their card
    public void clearClick (View v){
        //Add warning that player is clearing card

    }

    //A player gets a bingo
    public void bingoClick(View v){
        //pop up menu get activated here?
    }
}
