import java.util.Arrays;
import java.util.List;

/**
 * Created by kelseybedard on 11/29/17.
 */

public class BingoTileLibrary {

    List<BingoTile> tiles;
    public List<String> catagories;     //list of all the different catagories that items can be organized in


    public BingoTileLibrary(){
        catagories = Arrays.asList("Animals","Vehicles","Generic","Stores","Colored Cars");
        tileSetUp();

    }

    private void tileSetUp(){
        //Animals
        tiles.add(new BingoTile("link","Cow",0));
        tiles.add(new BingoTile("link","Horse",0));
        tiles.add(new BingoTile("link","Dog",0));
        tiles.add(new BingoTile("link","Cat",0));
        tiles.add(new BingoTile("link","Bird",0));
        tiles.add(new BingoTile("link","Squirrel",0));
        tiles.add(new BingoTile("link","Duck",0));
        tiles.add(new BingoTile("link","Deer",0));
        tiles.add(new BingoTile("link","Coyote",0));
        tiles.add(new BingoTile("link","Skunk",0));

        //Vehicles
        tiles.add(new BingoTile("link","Garbage Truck",1));
        tiles.add(new BingoTile("link","Fire Truck",1));
        tiles.add(new BingoTile("link","Ambulance",1));
        tiles.add(new BingoTile("link","Train",1));
        tiles.add(new BingoTile("link","Police Car",1));
        tiles.add(new BingoTile("link","RV",1));
        tiles.add(new BingoTile("link","Semi Truck",1));
        tiles.add(new BingoTile("link","Postal Vehicle",1));
        tiles.add(new BingoTile("link","Airplane",1));
        tiles.add(new BingoTile("link","Motorcycle",1));
        tiles.add(new BingoTile("link","Helicopter",1));
        tiles.add(new BingoTile("link","Moped",1));
        tiles.add(new BingoTile("link","Boat",1));

        //Generic
        tiles.add(new BingoTile("link","Tree",2));
        tiles.add(new BingoTile("link","Fire Hydrant",2));
        tiles.add(new BingoTile("link","Bridge",2));
        tiles.add(new BingoTile("link","Power Lines",2));
        tiles.add(new BingoTile("link","Yield Sign",2));
        tiles.add(new BingoTile("link","Stop Sign",2));
        tiles.add(new BingoTile("link","MPH Sign",2));
        tiles.add(new BingoTile("link","Road Cone",2));
        tiles.add(new BingoTile("link","Flag",2));
        tiles.add(new BingoTile("link","Flowers",2));
        tiles.add(new BingoTile("link","Mail Drop Off Box",2));
        tiles.add(new BingoTile("link","School",2));

        //Chains/Stores
        tiles.add(new BingoTile("link","Walmart",3));
        tiles.add(new BingoTile("link","Target",3));
        tiles.add(new BingoTile("link","McDonald's",3));
        tiles.add(new BingoTile("link","Dairy Queen",3));
        tiles.add(new BingoTile("link","Burger King",3));
        tiles.add(new BingoTile("link","Wendy's",3));
        tiles.add(new BingoTile("link","Subway",3));
        tiles.add(new BingoTile("link","Dominos",3));
        tiles.add(new BingoTile("link","KFC",3));
        tiles.add(new BingoTile("link","Arby's",3));
        tiles.add(new BingoTile("link","Pizza Hut",3));
        tiles.add(new BingoTile("link","Applebees",3));
        tiles.add(new BingoTile("link","Buffalo Wild Wings",3));
        tiles.add(new BingoTile("link","Taco Bell",3));
        tiles.add(new BingoTile("link","Chili's",3));

        //Colored Cars
        tiles.add(new BingoTile("link","Red Car",4));

    }
}
