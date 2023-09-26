import java.util.Scanner;

public class Game {

    Scanner kInput  = new Scanner(System.in);
    Deck gameDeck = new Deck();
    Player gamePlayer = new Player("Cat");
    Dealer gameDealer = new Dealer();
    int round = 0;

    public void startGame() {

        while(round >= 0) {
            if (round == 0){
                System.out.println("Game starts...\n");

                gamePlayer.drawCard(gameDeck.deal());
                dealerTurn();
                System.out.printf("%nYou are dealt: %s%n", gamePlayer.getHand().get(0).display());
                System.out.printf("Hand value: %d%n", gamePlayer.getHandValue());

                round ++;
            } else {
                System.out.printf("%n-- Round %d --%n", round);
                dealerTurn();

                System.out.println("Your turn:");
                System.out.println("1)Stick     2)Twist");

                if (kInput.nextInt() == 2) {
                    gamePlayer.drawCard(gameDeck.deal());
                    System.out.printf("%n%s twists, and draws card %s.%n", gamePlayer.getName(), gamePlayer.getHand().get(gamePlayer.getHand().size() - 1).display());

                    System.out.print("Your hand: ");
                    for (int i = gamePlayer.getHand().size() - 1; i >= 0; i--){
                        System.out.printf("%s%s",gamePlayer.getHand().get(i).display(),(i == 0)?".\n":", ");
                    }

                    System.out.printf("Hand value: %d%n", gamePlayer.getHandValue());

                    if (playerBust(gamePlayer)) {
                        System.out.println("You went bust!");
                        round = -1;
                    } else {
                        round ++;
                    }
                } else {
                    System.out.printf("%s sticks with hand value of %d.", gamePlayer.getName(), gamePlayer.getHandValue());
                    System.out.printf("%nDealer hand value: %d.%n", gameDealer.getHandValue());

                    round = -1;
                    endGame();
                }
            }
        } //END WHILE
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

    public void playerTurn() {
        System.out.println("It's your turn:");

    }

    public void endGame() {
        if (gamePlayer.getHandValue() > gameDealer.getHandValue()) {
            System.out.printf("%n%s wins!!", gamePlayer.getName());
        } else {
            System.out.println("Dealer wins.");
        }
    }
}
