package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class findTile extends AppCompatActivity {
    int[] tileIcons;
    BingoTile selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tile);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));
        tileIcons = ((BingoManager) this.getApplication()).tileLibrary.getAllTileIcon();
        listener();

    }

    public void exitClick(View v){
        finish();
    }
    public void selectClicked(View v){
        boolean exists = false;
        for( int i =0; i <((BingoManager) this.getApplication()).card.board.size()-1; i++){
           if (((BingoManager) this.getApplication()).card.board.get(i).getIconImage() == selected.getIconImage()){
                TextView text = (TextView) findViewById(R.id.selectText);
                text.setText("Already on Card!");
                exists = true;
            }
        }
        if (!exists) {
            Intent intent = new Intent();
            intent.putExtra("Tile", selected.getIconImage());
            setResult(RESULT_OK, intent);
            finish();
        }

    }

    private void listener (){
        final Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setClickable(false);
        final GridView select = (GridView) findViewById(R.id.selectGridView);
        final ImageAdaptor adaptor = new ImageAdaptor(this,tileIcons);
        select.setAdapter(adaptor);
        select.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long itemId) {
                    clickedOn(position, addButton,adaptor);

            }
        });
    }

        public void clickedOn(int position, Button addButton, ImageAdaptor adaptor) {
             addButton.setClickable(true);
             tileIcons = ((BingoManager) this.getApplication()).tileLibrary.getAllTileIcon();
             TextView text = (TextView) findViewById(R.id.selectText);
             text.setText(((BingoManager) this.getApplication()).tileLibrary.getTileName(position));
             selected = ((BingoManager) this.getApplication()).tileLibrary.tiles.get(position);
             tileIcons[position] = R.drawable.x;
             adaptor.changeImages(tileIcons);

    }

}
