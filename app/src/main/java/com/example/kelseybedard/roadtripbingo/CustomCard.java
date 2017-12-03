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
        ((BingoManager) this.getApplication()).setCardAsEditor();
        adaptor.changeImages(((BingoManager) this.getApplication()).card.getImages());
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
                ((BingoManager) this.getApplication()).addTile(changed,changedLocation);
                adaptor.changeImages(((BingoManager) this.getApplication()).card.getImages());
            }
        }
    }

    //User wants to save their custom card and return to main menu
    public void saveAndExitClick (View view){
        //Will save data from board here when before exiting
        finish();
    }

    private void listener (){
        GridView gridview = (GridView) findViewById(R.id.customGridView);
        gridview.setAdapter(adaptor);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long itemId) {
                changedLocation = position;
                popUp();



            }
        });
    }
    public void popUp(){
        Intent intent = new Intent(this,findTile.class);
        startActivityForResult(intent,2);
    }
}
