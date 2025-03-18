package factory_method;

public abstract class Tile {
    public char getCharacter() {
        return 'T';
    };
    public String getDescription() {
        return "Tile";
    };
    public abstract void action(); // Placeholder for future implementation
}
