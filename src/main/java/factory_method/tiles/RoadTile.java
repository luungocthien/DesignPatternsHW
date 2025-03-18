package factory_method.tiles;

import factory_method.Tile;

public class RoadTile extends Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }
    @Override
    public String getDescription() {
        return "Road";
    }
    @Override
    public void action() {} // Placeholder for future implementation
}