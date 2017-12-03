package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainMenu extends AppCompatActivity {

    //Used to move info between activities
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    //User wishes to play Bingo
    public void playBingoClick (View v){
        //Popup stuff here so we determine what kind of card and game the user wants to play
        Intent intent = new Intent(MainMenu.this,Pop.class);
        startActivity(intent);
    }

    //User wants to create a custom card
    public void customCardClick (View v){
        Intent intent = new Intent(this, CustomCard.class);
        String message ="0";
        switch(v.getId()){  //Used to determine which card was being customized
            case (R.id.customCard1Button):
                message = Integer.toString(1);
                break;
            case (R.id.customCard2Button):
                message = Integer.toString(2);
        }
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
