package factory_method.maps;

import factory_method.Map;
import factory_method.Tile;
import factory_method.tiles.*;

import java.util.Random;

public class CityMap extends Map {

    Random rand = new Random();

    @Override
    public Tile createTile() {
        int random = rand.nextInt(3);
        switch(random) {
            case 0:
                return new RoadTile();
            case 1:
                return new BuildingTile();
            case 2:
                return new ForestTile();
            default:
                return null;
        }
    }
}
