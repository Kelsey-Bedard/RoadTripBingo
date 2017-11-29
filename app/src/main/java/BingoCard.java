import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kelseybedard on 11/29/17.
 */

public class BingoCard {

    public List<String> catagories;     //list of all the different catagories that items can be organized in
    List<BingoTile> board;       //Set up of twenty four times with a free space (total of 25 items)
    public List<String> gameTypes;     //List of different Bingo games a user can play
    String gameType;            //Game type selected by user


    public BingoCard(){

        catagories = Arrays.asList("Animals","Vehicles","Generic","Stores","Colored Cars");
        gameTypes = Arrays.asList("Line","Blackout","Four Corners");

        //create BingoTileLibrary here

    }

    //Will check if a bingo has taken place, will happen each time a icon is selected/unselected
    public boolean checkBingo(){
        return false;
    }

    //Here we will fill the board with random tiles the middle on being a free space, will return the list of strings for the icon image
    public List<String> generateRandomBoard(){


        return catagories; //Will not be returning this in final product
    }

    //will get the custom board based on what cardNumber is sent and than return the list of string for the icon image
    public List<String> generateCustomCard(int cardNumber){

        return catagories; //will not be returning this in final product
    }

    //When a tile is selected, either select or un-select it
    public void toggleSelectedTile (int tile){

    }

    // changes all tiles to un-selected using BingoTile method selectedFalse
    public void clearCard (){

    }
}
