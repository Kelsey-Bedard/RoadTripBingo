package com.example.kelseybedard.roadtripbingo;

import android.graphics.Canvas;

import java.util.Arrays;
import java.util.List;

import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

/**
 * Created by kelseybedard on 11/29/17.
 */

public class PlayingBingoCard {

    List<BingoTile> board;       //Set up of twenty four times with a free space (total of 25 items)


    public PlayingBingoCard(List<BingoTile> newTiles){
        board = newTiles;
        board.get(12).isSelected = true;
    }

    //Will check if a bingo has taken place, will happen each time a icon is selected/unselected
    public boolean checkBingo(String gameType){
        if(gameType.equals("Four Corners")){
            return board.get(0).isSelected && board.get(4).isSelected && board.get(20).isSelected && board.get(24).isSelected;
        }
        else if(gameType.equals("Blackout")){
            boolean allSelected = true;
            for(int i = 0; i < 25; i++){
                if(!board.get(i).isSelected){
                    allSelected = false;
                    break;
                }
            }
            return allSelected;
        }
        else if(gameType.equals("Line")){
            int rowCounts[] = {0,0,0,0,0};
            int columnCounts[] = {0,0,0,0,0};
            int diagonalCounts[] = {0,0};

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(board.get((j*5) + i).isSelected){
                        rowCounts[i] += 1;
                        columnCounts[j] += 1;
                        if(i == j){
                            diagonalCounts[0] += 1;
                        }
                        if(i + j == 4){
                            diagonalCounts[1] += 1;
                        }
                    }
                }
            }

            for(int i = 0; i < 5; i++){
                if(rowCounts[i] == 5 || columnCounts[i] == 5){
                    return true;
                }
            }

            if(diagonalCounts[0] == 5 || diagonalCounts[1] == 5){
                return true;
            }

            return false;
        }
        else{
            System.out.println("Invalid Game Type For Bingo Check");
            return false;
        }
    }

    public int[] getImages (){
        int[] images = new int[25];
        for (int i =0; i<board.size(); i++){
            images[i] = board.get(i).getIconImage();
        }
        return images;
    }

    //When a tile is selected, either select or un-select it
    //So far we just toggle the tiles bool, need something to actually change how the image is drawn
    public void toggleSelectedTile (int tileIndex){
        if (tileIndex != 12){
            BingoTile tileOfInterest = board.get(tileIndex);
            boolean toggledBool = !tileOfInterest.isSelected;
            tileOfInterest.isSelected = toggledBool;
        }

    }

    // changes all tiles to un-selected using com.example.kelseybedard.roadtripbingo.BingoTile method selectedFalse
    public void clearCard (){
        for(int i = 0; i < board.size(); i++){
            board.get(i).isSelected = false;
        }
    }
}
