package com.example.kelseybedard.roadtripbingo;

import android.app.Application;

import java.util.Arrays;
import java.util.List;
import android.media.MediaPlayer;

/**
 * Created by leighton on 12/2/2017.
 */

public class BingoManager extends Application{

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

    public void setCardAsEditor (){
        card = new PlayingBingoCard(tileLibrary.getCustomCardEditer());
    }

    public void setCardAsBlank(){
        card = new PlayingBingoCard(tileLibrary.getBlankCard());
    }

    //if there was more to reset other than the card we would put that in this method
    public void resetGame(){
        card.clearCard();
    }

    //This is where the code should go to play sounds, modify the card fields, and change how images are drawn
    public void selectTile(int tileIndex){
        card.toggleSelectedTile(tileIndex);//for now just changing the cards fields
    }

    //checks whether a card being edited is a card that could be played in the game
    public boolean isValidCard(PlayingBingoCard cardToCheck){
        boolean isValid = true;

        for(int i = 0; i < cardToCheck.board.size(); i++){
            if(cardToCheck.board.get(i).name.equals("Question Mark")){
                isValid = false;
                break;
            }
        }
        return isValid;

    }

}
