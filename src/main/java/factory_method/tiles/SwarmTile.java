package factory_method.tiles;

import factory_method.Tile;

public class SwarmTile extends Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }
    @Override
    public String getDescription() {
        return "Swarm";
    }
    @Override
    public void action() {} // Placeholder for future implementation
}