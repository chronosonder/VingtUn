import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner kInput;
    Deck gameDeck;
    ArrayList<Player> gamePlayers;
    ArrayList<Player> bustPlayers;
    ArrayList<Player> stuckPlayers;
    Player currentPlayer;
    Dealer gameDealer;
    boolean running;

    // Constructor
    public Game(ArrayList<Player> addPlayers) {
        this.gameDeck = new Deck();
        this.gameDealer = new Dealer();
        this.kInput = new Scanner(System.in);
        this.gamePlayers = addPlayers;
        this.bustPlayers = new ArrayList<>();
        this.stuckPlayers = new ArrayList<>();

        this.running = true;
    }

    //    Main game loop
    public void startGame() {

        initGame();

        while (running) {
            dealerTurn();
            if (gamePlayers.isEmpty()){
                endGame();
            } else {
                for (Player player: gamePlayers){
                    this.currentPlayer = player;
                    playerTurn();
                }
            }
        }//END WHILE
    }

    public void initGame() {
        System.out.println("Game starts...\n");


        for (Player player: gamePlayers){
            player.drawCard(gameDeck.deal());
            System.out.printf("%n%s,you are dealt: %s.%n",player.getName(), player.getHand().get(0).display());
            System.out.printf("Hand value: %d.%n%n", player.getHandValue());
        }
        dealerTurn();

    }

    public void playerTurn() {

        System.out.printf("\n%s, it's your turn:%n", currentPlayer.getName());
        System.out.println("1)Stick     2)Twist");

        if (kInput.nextInt() == 2) {
            currentPlayer.drawCard(gameDeck.deal());
            System.out.printf("%n%s twists, and draws card %s.%n", currentPlayer.getName(), currentPlayer.getHand().get(currentPlayer.getHand().size() - 1).display());

            System.out.print("Your hand: ");
            for (int i = currentPlayer.getHand().size() - 1; i >= 0; i--) {
                System.out.printf("%s%s", currentPlayer.getHand().get(i).display(), (i == 0) ? ".\n" : ", ");
            }

            System.out.printf("Hand value: %d%n", currentPlayer.getHandValue());

            if (playerBust(currentPlayer)) {
                System.out.println("You went bust!");

                gamePlayers.remove(currentPlayer);
                bustPlayers.add(currentPlayer);
            }
        } else {
            System.out.printf("%s sticks with hand value of %d.", currentPlayer.getName(), currentPlayer.getHandValue());

            gamePlayers.remove(currentPlayer);
            stuckPlayers.add(currentPlayer);
        }
    }
    public boolean playerBust(Player currentPlayer) {
        return currentPlayer.getHandValue() > 21;
    }

    public void dealerTurn() {
        if (gameDealer.getHandValue() <= 16) {
            gameDealer.drawCard(gameDeck.deal());
        } else {
            System.out.println("Dealer sticks.");
        }
    }

    public void endGame() {
//        Display bust players
        for (Player player: bustPlayers){
            System.out.printf("\n%s went bust with a hand of %d.", player.getName(), player.getHandValue());
        }

//        Display players hands
        for (Player player: stuckPlayers){
            System.out.printf("\n%s sticks a hand of %d.", player.getName(), player.getHandValue());
        }


//        if (currentPlayer.getHandValue() > gameDealer.getHandValue()) {
//            System.out.printf("%n%s wins!!", currentPlayer.getName());
//        } else {
//            System.out.println("Dealer wins.");
//        }
        running = false;
    }
}
