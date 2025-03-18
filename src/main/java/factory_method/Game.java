package factory_method;

import factory_method.maps.*;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        Map map = game.createMap();
        map.display(5,10);
    }
    public Map createMap() {
        return new WildernessMap();
    }
}
