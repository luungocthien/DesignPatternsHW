package template_method;

public class Main {
    public static void main(String[] args) {
        Game game = new DiceGame();
        game.play(3);
    }
}

