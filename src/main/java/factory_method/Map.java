package factory_method;

public abstract class Map {
    public void display(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() +" ");
            }
            System.out.println("");
        }
    };
    public abstract Tile createTile();
}
