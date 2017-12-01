package com.example.kelseybedard.roadtripbingo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kelseybedard on 11/29/17.
 */

public class PlayingBingoCard {

    List<BingoTile> board;       //Set up of twenty four times with a free space (total of 25 items)
    public List<String> gameTypes;     //List of different Bingo games a user can play
    String gameType;            //Game type selected by user


    public PlayingBingoCard(int type, int board){

        gameTypes = Arrays.asList("Line","Blackout","Four Corners");

        //setting the type of game we are getting
        switch (type){
            case 1: gameType = gameTypes.get(1);
                    break;
            case 2: gameType = gameTypes.get(2);
                    break;
            case 3: gameType = gameTypes.get(3);
                    break;
        }

        //setting which board we are using
        switch (board){
            case 1: //is random board
                break;
            case 2: //is custom board 1
                break;
            case 3: //is custom board 2
                break;
        }


    }

    //Will check if a bingo has taken place, will happen each time a icon is selected/unselected
    public boolean checkBingo(){
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

    //When a tile is selected, either select or un-select it
    public void toggleSelectedTile (int tile){

    }

    // changes all tiles to un-selected using com.example.kelseybedard.roadtripbingo.BingoTile method selectedFalse
    public void clearCard (){

    }
}
