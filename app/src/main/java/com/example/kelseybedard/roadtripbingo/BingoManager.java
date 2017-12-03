package com.example.kelseybedard.roadtripbingo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leighton on 12/2/2017.
 */

public class BingoManager {

    public PlayingBingoCard card;
    public BingoTileLibrary tileLibrary;
    public List<String> gameTypes;     //List of different Bingo games a user can play
    String gameType;            //Game type selected by user

    public BingoManager(){//default constructor
        //init bingo manager in here
        gameTypes = Arrays.asList("Line","Blackout","Four Corners");

        tileLibrary = new BingoTileLibrary();
        gameType = gameTypes.get(0);
        setCardAsRandom();

    }

    public void setCardAsRandom(){
        PlayingBingoCard newCard;
        List<BingoTile> randomTiles = tileLibrary.getRandomBoard();
        newCard = new PlayingBingoCard(randomTiles);
        card = newCard;
    }

    public void setCardAsCustom(int customCard){
        if(customCard == 0){
            card = new PlayingBingoCard(tileLibrary.customCard1);
        }
        else if(customCard == 1){
            card = new PlayingBingoCard(tileLibrary.customCard1);
        }
        else{
            System.out.println("Improper custom card integer passed to BingoManager");
        }
    }

    public void setCardAsBlank (){
        card = new PlayingBingoCard(tileLibrary.getBlankCard());
    }

    public void createNewGame(int bingoType, int boardType){

        if(boardType == 0){
           this.setCardAsRandom();
        }
        else if(boardType == 1){
            this.card = new PlayingBingoCard(tileLibrary.customCard1);
        }
        else if(boardType == 2){
            this.card = new PlayingBingoCard(tileLibrary.customCard2);
        }
        else{
            System.out.println("Improper board type integer passed to BingoManager");
        }

        //setting the type of game we are getting
        switch (bingoType){
            case 1: gameType = gameTypes.get(0); //line
                break;
            case 2: gameType = gameTypes.get(1); //4 corners
                break;
            case 3: gameType = gameTypes.get(2); //blackout
                break;
        }
    }

    //if there was more to reset other than the card we would put that in this method
    public void resetGame(){
        card.clearCard();
    }

    //This is where the code should go to play sounds, modify the card fields, and change how images are drawn
    public void selectTile(int tileIndex){
        card.toggleSelectedTile(tileIndex);//for now just changing the cards fields
    }

    //Method called when the user presses the check bingo button, if we decide to have one, could use this as a helper method and use it inside
    //select tile if you want it to be run automatically for the user
    public void checkBingo(){
       if(card.checkBingo(gameType)){
           //DO THE BINGO THINGS
       }
       else{
           //TELL THE USER THEY DON'T HAVE THE BINGO THINGS
       }
    }







}
