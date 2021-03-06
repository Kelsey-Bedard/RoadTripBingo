package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class CustomCard extends AppCompatActivity {
   BingoTile changed;
    int changedLocation;
    ImageAdaptor adaptor = new ImageAdaptor(this);

    //Not super proud of these fields... but it works?????
    PlayingBingoCard cardWeAreEditing;
    private String message;
    Integer customCardNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_card);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        message = intent.getStringExtra(MainMenu.EXTRA_MESSAGE);
        customCardNumber = Integer.parseInt(message);
        // Message determines which card is being editted
        TextView textView = (TextView) findViewById(R.id.customCardText);
        textView.setText("Edit Custom Card " + message);



        //Setting up which card to display in the grid view
        GridView gridview = (GridView) findViewById(R.id.customGridView);

        //cardWeAreEditing = new PlayingBingoCard(((BingoManager) this.getApplication()).tileLibrary.getCustomCardEditer());//give the user a fresh card to edit


       if( customCardNumber == 1){
            if(((BingoManager) this.getApplication()).tileLibrary.customCard1 == null){//if custom card 1 has not been created before
                cardWeAreEditing = new PlayingBingoCard(((BingoManager) this.getApplication()).tileLibrary.getCustomCardEditer());//give the user a fresh card to edit
                //((BingoManager) this.getApplication()).card = ((BingoManager) this.getApplication()).tileLibrary.getCustomCardEditer();
            }
            else{
                cardWeAreEditing = new PlayingBingoCard(((BingoManager) this.getApplication()).tileLibrary.customCard1);//load their old card
            }
        }
        else {//customCardNumber == 2, we are going to edit custom card 2
            if (((BingoManager) this.getApplication()).tileLibrary.customCard2 == null) {//if custom card 2 has not been created before
                cardWeAreEditing = new PlayingBingoCard(((BingoManager) this.getApplication()).tileLibrary.getCustomCardEditer());//give the user a fresh card to edit
            } else {
                cardWeAreEditing = new PlayingBingoCard(((BingoManager) this.getApplication()).tileLibrary.customCard2);//load their old card
            }
        }
        adaptor.changeImages(cardWeAreEditing.getImages());
        ((BingoManager) this.getApplication()).card = cardWeAreEditing;
        listener();
    }
    //User wants to exit custom card and return to main menu
    public void exitClick (View view){
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
        if (requestCode ==2){  //if we came from selecting an icon
            if(resultCode ==RESULT_OK){
                int icon = data.getIntExtra("Tile",0);//Icon contains icon location
                changed = ((BingoManager) this.getApplication()).tileLibrary.getTilebyImage(icon);
                cardWeAreEditing.addTile(changed,changedLocation);
                adaptor.changeImages(cardWeAreEditing.getImages());
            }
        }
    }

    //User wants to save their custom card and return to main menu
    public void saveAndExitClick (View view){
       //Will save data from board here when before exiting
        if( ((BingoManager) this.getApplication()).isValidCard(cardWeAreEditing) && customCardNumber == 1){
            ((BingoManager) this.getApplication()).tileLibrary.customCard1 = cardWeAreEditing.board;
            finish();
        }
        else if( ((BingoManager) this.getApplication()).isValidCard(cardWeAreEditing) && customCardNumber == 2){
            ((BingoManager) this.getApplication()).tileLibrary.customCard2 = cardWeAreEditing.board;
            finish();
        }
        else{
            Intent intent = new Intent(this,WarningPage.class);
            startActivity(intent);
        }

    }


    private void listener (){
        GridView gridview = (GridView) findViewById(R.id.customGridView);
        gridview.setAdapter(adaptor);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long itemId) {
                if (position == 12) {
                    //Warn they can't change free space

                }
                else {
                    changedLocation = position;
                    popUp();
                }



            }
        });
    }
    public void popUp(){
        Intent intent = new Intent(this,findTile.class);
        startActivityForResult(intent,2);
    }
}
