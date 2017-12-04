package com.example.kelseybedard.roadtripbingo;

/**
 * Created by kelseybedard on 11/29/17.
 */

public class BingoTile {
    public int iconImage;  //link to image in drawables folder
    public String name;   //name of link (ex. red car)
    public int catagory;   //the catagory that icon is in
    public boolean isSelected;  //whether the tile has been selected or not

    //constructor for each BingoTile
    public BingoTile(int link, String tileName, int typeOfTile){
        iconImage= link;
        name = tileName;
        catagory = typeOfTile;
        isSelected= false;
    }

    //Changes the isSelected to opposite of what it was
    public void setSelected(){
        isSelected = !isSelected;
    }
    public int getIconImage(){
        return iconImage;
    }
    public String getName (){
        return name;
    }
    public int getCatagory(){
        return catagory;
    }
}
