package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class BingoCard extends AppCompatActivity {


    int[] checkMarks;
    String gameType;
    int gameCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo_card);
        //This is were we will set the card up based on if it was custom or random

        TextView cardText = (TextView) findViewById(R.id.cardTypeText);
        TextView gameTypeText = (TextView) findViewById(R.id.gameTypeText);

        //SET THE TEXTVIEW ONCE WE CAN PASS THE DATA TO THE ITEM
        Intent intent = getIntent();
        cardText.setText("Card: " +  intent.getStringExtra("Game Card"));
        gameTypeText.setText("Game Type: "+  intent.getStringExtra("Game Type"));
        gameType =  intent.getStringExtra("Game Type");
        //Use this tutorial to add items to grid view
        //https://developer.android.com/guide/topics/ui/layout/gridview.html

        //gridView that contrains x's
        final Button bingoButton = (Button) findViewById(R.id.BingoButton);
        bingoButton.setClickable(false);
        ((BingoManager) this.getApplication()).setCardAsBlank();
         checkMarks= ((BingoManager) this.getApplication()).card.getImages();
        final GridView xGrid = (GridView)findViewById(R.id.xGridView);
        final ImageAdaptor imageAdaptor = new ImageAdaptor(this, checkMarks);
        xGrid.setAdapter(imageAdaptor);

        //sets bottom gridView to icons
        if ((intent.getStringExtra("Game Card")).equals("Random")){
            ((BingoManager) this.getApplication()).setCardAsRandom();
        }
        else if ((intent.getStringExtra("Game Card")).equals("Custom Card 1"))
        {
            ((BingoManager) this.getApplication()).setCardAsCustom(1);
        }
        else {
            ((BingoManager) this.getApplication()).setCardAsCustom(2);
        }
        final GridView gridview = (GridView) findViewById(R.id.customGridView);
        gridview.setAdapter(new ImageAdaptor(this, ((BingoManager) this.getApplication()).card.getImages()));

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
        if (requestCode ==2){
            if (resultCode == RESULT_OK){
                finish();
            }
            else{
                for (int i = 0; i<25; i++){
                    checkMarks[i] = R.drawable.blank_tile;
                }
                checkMarks[12] = R.drawable.x;
                ((BingoManager) this.getApplication()).card.clearCard();
                listener();
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
        ((BingoManager) this.getApplication()).card.clearCard();
        listener();
    }

    //A player gets a bingo
    public void bingoClick(View v){
        Intent intent = new Intent(this,GotBingo.class);
        startActivityForResult(intent,2);
    }

    private void listener (){
        final Button bingoButton = (Button) findViewById(R.id.BingoButton);
        bingoButton.setClickable(false);
        final ImageAdaptor imageAdaptor = new ImageAdaptor(this, checkMarks);
        final GridView xGrid = (GridView)findViewById(R.id.xGridView);
        xGrid.setAdapter(imageAdaptor);
        xGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long itemId) {
                iconClick(position,imageAdaptor);


            }
        });
    }
    public void iconClick(int position, ImageAdaptor imageAdaptor) {
        final Button bingoButton = (Button) findViewById(R.id.BingoButton);
        ((BingoManager) this.getApplication()).card.toggleSelectedTile(position);
        if (checkMarks[position] != R.drawable.x) {
            checkMarks[position] = R.drawable.x;
            imageAdaptor.changeImages(checkMarks);
        } else {
            checkMarks[position] = R.drawable.blank_tile;
            imageAdaptor.changeImages(checkMarks);
        }

        boolean check = ((BingoManager) this.getApplication()).card.checkBingo(gameType);
        if (check) {  //Bingo Button is click on able
            bingoButton.setClickable(true);  //Change color of text?
        } else {
            bingoButton.setClickable(false); //Change color of text?

        }

    }
}
