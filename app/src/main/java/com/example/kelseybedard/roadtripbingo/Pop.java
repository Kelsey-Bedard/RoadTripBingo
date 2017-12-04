package com.example.kelseybedard.roadtripbingo;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * Created by Tiana on 12/1/2017.
 */

public class Pop extends Activity {

    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));
    }

    //Play Game Button --> Start game
    //Submit game type and card selection
    public void playGame(View v){
        RadioGroup gameTypeGroup = (RadioGroup) findViewById(R.id.gameTypeGroup);
        RadioGroup gameCardGroup = (RadioGroup) findViewById(R.id.gameCardGroup);


        RadioButton gameCardRadioButton = (RadioButton)findViewById(gameCardGroup.getCheckedRadioButtonId());
        String gameCard = gameCardRadioButton.getText().toString();

        RadioButton gameTypeRadioButton = (RadioButton)findViewById(gameTypeGroup.getCheckedRadioButtonId());
        String gameType = gameTypeRadioButton.getText().toString();

            Intent intent = new Intent(this, BingoCard.class);
            intent.putExtra("Game Type", gameType);
            intent.putExtra("Game Card", gameCard);
            startActivity(intent);
            finish();
    }

    //Display selected radio buttons
    public void rbclick(View v){
        /*int radioButtonID = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radioButtonID);

       Toast.makeText(getBaseContext(), rb.getText(), Toast.LENGTH_SHORT).show();*/
    }





}
