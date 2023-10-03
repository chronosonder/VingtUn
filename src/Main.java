import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Player cat = new Player("Cat");
        Player philip = new Player("Philip");

        ArrayList<Player> gamePlayers = new ArrayList<>();

        gamePlayers.add(cat);
        gamePlayers.add(philip);

        Game newGame = new Game(gamePlayers);

        newGame.startGame();
    }
}