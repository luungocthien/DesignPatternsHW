package factory_method.tiles;

import factory_method.Tile;

public class ForestTile extends Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }
    @Override
    public String getDescription() {
        return "Forest";
    }
    @Override
    public void action() {} // Placeholder for future implementation
}