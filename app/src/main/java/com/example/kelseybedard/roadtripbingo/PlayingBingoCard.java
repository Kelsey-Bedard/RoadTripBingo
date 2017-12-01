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


    public PlayingBingoCard(){

        gameTypes = Arrays.asList("Line","Blackout","Four Corners");

        //create com.example.kelseybedard.roadtripbingo.BingoTileLibrary here

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

    //Here we will fill the board with random tiles the middle on being a free space, will return the list of strings for the icon image
    public List<String> generateRandomBoard(){


        return gameTypes; //Will not be returning this in final product
    }

    //will get the custom board based on what cardNumber is sent and than return the list of string for the icon image
    public List<String> generateCustomCard(int cardNumber){

        return gameTypes; //will not be returning this in final product
    }

    //When a tile is selected, either select or un-select it
    public void toggleSelectedTile (int tile){

    }

    // changes all tiles to un-selected using com.example.kelseybedard.roadtripbingo.BingoTile method selectedFalse
    public void clearCard (){

    }
}
