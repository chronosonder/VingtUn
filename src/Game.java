import java.util.Scanner;

public class Game {

    Scanner kInput  = new Scanner(System.in);
    Deck gameDeck = new Deck();
    Player gamePlayer = new Player("Cat");
    int round = 0;

    public void startGame() {

        while(round >= 0) {
            if (round == 0){
                System.out.println("Game starts...\n");

                gamePlayer.drawCard(gameDeck.deal());
                System.out.printf("%nYou are dealt: %s%n", gamePlayer.getHand().get(0).display());
                System.out.printf("Hand value: %d%n", gamePlayer.getHandValue());

                round ++;
            } else {
                System.out.printf("%n-- Round %d --%n", round);
                System.out.println("Your decision:");
                System.out.println("1)Stick     2)Twist");
                if (kInput.nextInt() == 2) {
                    gamePlayer.drawCard(gameDeck.deal());
                    System.out.printf("%n%s twists, and draws card %s.%n", gamePlayer.getName(), gamePlayer.getHand().get(gamePlayer.getHand().size() - 1).display());

//                    System.out.printf("%nYou are dealt: %s%n", gamePlayer.getHand().get(gamePlayer.getHand().size() - 1).display());

                    System.out.print("Your hand: ");
                    for (int i = gamePlayer.getHand().size() - 1; i >= 0; i--){
                        System.out.printf("%s%s",gamePlayer.getHand().get(i).display(),(i == 0)?".\n":", ");
                    }
                    System.out.printf("Hand value: %d%n", gamePlayer.getHandValue());

                    round ++;
                } else {
                    System.out.printf("%s sticks.%n", gamePlayer.getName());
                    System.out.printf("Hand value: %d%n", gamePlayer.getHandValue());

                    round =  -1;
                }
            }
        } //END WHILE
    }
}
