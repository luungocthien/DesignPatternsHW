package factory_method.tiles;

import factory_method.Tile;

public class BuildingTile extends Tile {
    @Override
    public char getCharacter() {
        return 'B';
    };
    @Override
    public String getDescription() {
        return "Building";
    };
    @Override
    public void action() {}; // Placeholder for future implementation
}
