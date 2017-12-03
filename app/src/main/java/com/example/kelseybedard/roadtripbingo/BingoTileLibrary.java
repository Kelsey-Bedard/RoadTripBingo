package com.example.kelseybedard.roadtripbingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kelseybedard on 11/29/17.
 */

public class BingoTileLibrary {

    List<BingoTile> tiles = new ArrayList<BingoTile>();
    public List<String> catagories;     //list of all the different catagories that items can be organized in
    public List<BingoTile> customCard1;
    public List<BingoTile> customCard2;


    public BingoTileLibrary(){
        catagories = Arrays.asList("Animals","Vehicles","Generic","Stores","Colored Cars", "Free Space");
        tileSetUp();

    }

    //getting Random board
    public List<BingoTile> getRandomBoard(){
        //Want to include in allTiles only those that are of the first 4 catagories, find different way of doing this?
        List <BingoTile> allTiles = new ArrayList<BingoTile>(tiles.subList(0,tiles.size()-6)); //getting all tiles but the free space tile (last one)
        List<BingoTile> randomBoard;
        Collections.shuffle(allTiles);  //randomly shuffles the items in randomBoard
        randomBoard = allTiles.subList(0,24);
        randomBoard.add(12,tiles.get(tiles.size()-5)); //retreiving the free space tile and placing it in middle of board (spot 12)
        return randomBoard;
    }

    //returns custom board based on the value of board
    public List<BingoTile> getCustomCard (int board){
        if (board == 1)
            return customCard1;
        else
            return customCard2;
    }

    public List<BingoTile> getCustomCardEditer (){
        List <BingoTile> board = new ArrayList<BingoTile>();
        for (int i =0; i<24; i++) {
            board.add(tiles.get(tiles.size() - 4));
        }
        board.add(12, tiles.get(tiles.size()-5));
        return board;

    }

    public List<BingoTile> getBlankCard(){
        List <BingoTile> board = new ArrayList<BingoTile>();
        for (int i =0; i<24; i++) {
            board.add(tiles.get(tiles.size() - 1));
        }
        board.add(12, tiles.get(tiles.size()-2));
        return board;

    }

    //returns a list of the catagories
    public List<String> getCatagories (){
        return catagories;
    }

    //setting custom card1
    public void setCustomCard1 (List<BingoTile> card){
        customCard1 = card;
    }

    //Setting custom card2
    public void setCustomCard2 (List<BingoTile> card){
        customCard2 = card;
    }

    //Creates all bingo tiles
    private void tileSetUp(){
        //Animals
        tiles.add(new BingoTile(R.drawable.cow,"Cow",0));
        tiles.add(new BingoTile(R.drawable.horse,"Horse",0));
        tiles.add(new BingoTile(R.drawable.dog,"Dog",0));
        tiles.add(new BingoTile(R.drawable.cat,"Cat",0));
        tiles.add(new BingoTile(R.drawable.bird,"Bird",0));
        tiles.add(new BingoTile(R.drawable.squirrel,"Squirrel",0));
        tiles.add(new BingoTile(R.drawable.duck,"Duck",0));
        tiles.add(new BingoTile(R.drawable.deer,"Deer",0));
        //tiles.add(new BingoTile("R.drawable.coyote","Coyote",0));
        tiles.add(new BingoTile(R.drawable.skunk,"Skunk",0));

        //Vehicles
        tiles.add(new BingoTile(R.drawable.garbage_truck,"Garbage Truck",1));
        tiles.add(new BingoTile(R.drawable.fire_truck,"Fire Truck",1));
        tiles.add(new BingoTile(R.drawable.ambulance,"Ambulance",1));
        tiles.add(new BingoTile(R.drawable.train,"Train",1));
        tiles.add(new BingoTile(R.drawable.police_car,"Police Car",1));
        tiles.add(new BingoTile(R.drawable.rv,"RV",1));
        tiles.add(new BingoTile(R.drawable.semi_truck,"Semi Truck",1));
        tiles.add(new BingoTile(R.drawable.postal_vehicle,"Postal Vehicle",1));
        tiles.add(new BingoTile(R.drawable.airplane,"Airplane",1));
        tiles.add(new BingoTile(R.drawable.motorcycle,"Motorcycle",1));
        tiles.add(new BingoTile(R.drawable.helicopter,"Helicopter",1));
        tiles.add(new BingoTile(R.drawable.moped,"Moped",1));
        tiles.add(new BingoTile(R.drawable.boat,"Boat",1));

        //Generic
        tiles.add(new BingoTile(R.drawable.tree,"Tree",2));
        tiles.add(new BingoTile(R.drawable.fire_hydrant,"Fire Hydrant",2));
        tiles.add(new BingoTile(R.drawable.bridge,"Bridge",2));
        tiles.add(new BingoTile(R.drawable.power_lines,"Power Lines",2));
        tiles.add(new BingoTile(R.drawable.yield_sign,"Yield Sign",2));
        tiles.add(new BingoTile(R.drawable.stop_sign,"Stop Sign",2));
        tiles.add(new BingoTile(R.drawable.mph_sign,"MPH Sign",2));
        tiles.add(new BingoTile(R.drawable.road_cone,"Road Cone",2));
        tiles.add(new BingoTile(R.drawable.flag,"Flag",2));
        tiles.add(new BingoTile(R.drawable.flower,"Flowers",2));
        tiles.add(new BingoTile(R.drawable.mail_dropoff_box,"Mail DropOff Box",2));
        tiles.add(new BingoTile(R.drawable.school,"School",2));

        //Chains/Stores
        tiles.add(new BingoTile(R.drawable.walmart,"Walmart",3));
        tiles.add(new BingoTile(R.drawable.target,"Target",3));
        tiles.add(new BingoTile(R.drawable.mcdonalds,"McDonald's",3));
        tiles.add(new BingoTile(R.drawable.dairy_queen,"Dairy Queen",3));
        tiles.add(new BingoTile(R.drawable.burger_king,"Burger King",3));
        tiles.add(new BingoTile(R.drawable.wendys,"Wendy's",3));
        tiles.add(new BingoTile(R.drawable.subway,"Subway",3));
        tiles.add(new BingoTile(R.drawable.dominos,"Dominos",3));
        tiles.add(new BingoTile(R.drawable.kfc,"KFC",3));
        tiles.add(new BingoTile(R.drawable.arbys,"Arby's",3));
        tiles.add(new BingoTile(R.drawable.pizza_hut,"Pizza Hut",3));
        tiles.add(new BingoTile(R.drawable.applebees,"Applebees",3));
        tiles.add(new BingoTile(R.drawable.buffalo_wild_wings,"Buffalo Wild Wings",3));
        tiles.add(new BingoTile(R.drawable.taco_bell,"Taco Bell",3));
        tiles.add(new BingoTile(R.drawable.chilis,"Chili's",3));

        //Colored Cars
        tiles.add(new BingoTile(R.drawable.red_car,"Red Car",4));
        tiles.add(new BingoTile(R.drawable.blue_car,"Blue Car",4));
        tiles.add(new BingoTile(R.drawable.green_car,"Green Car",4));
        tiles.add(new BingoTile(R.drawable.yellow_car,"Yellow Car",4));
        tiles.add(new BingoTile(R.drawable.purple_car,"Purple Car",4));

        //Free Space
        tiles.add(new BingoTile(R.drawable.free_space,"Free Space",5));
        tiles.add(new BingoTile(R.drawable.question_mark, "Question Mark", 5));
        tiles.add(new BingoTile(R.drawable.black_tile, "Black Tile", 5));
        tiles.add(new BingoTile(R.drawable.x,"X", 5));
        tiles.add(new BingoTile(R.drawable.blank_tile,"Blank Tile", 5));
    }
}
