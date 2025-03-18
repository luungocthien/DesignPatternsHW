package factory_method.tiles;

import factory_method.Tile;

public class WaterTile extends Tile {
    @Override
    public char getCharacter() {
        return 'W';
    };
    @Override
    public String getDescription() {
        return "Water";
    };
    @Override
    public void action() {}; // Placeholder for future implementation
}
