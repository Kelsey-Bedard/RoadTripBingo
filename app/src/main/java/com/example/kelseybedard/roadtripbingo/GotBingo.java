package com.example.kelseybedard.roadtripbingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class GotBingo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_got_bingo);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.5));
    }
    public void exitClick(View v){
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();

    }
    public void continueClick(View V){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();

    }
}
