import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner kInput = new Scanner(System.in);
    private String name;
    private int handValue;
    private ArrayList<Card> hand;
    private ArrayList<Integer> stakes;
    private int balance;

//    Constructor
    public Player(String playerName) {
        this.name = playerName;
        hand = new ArrayList<>();
        handValue = 0;
        balance = 1000;
        stakes = new ArrayList<>();
    }


//    Getters
    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getHandValue() {
        return handValue;
    }
    public int getBalance() {
        return balance;
    }
    public int getStakes() {
        int totalStake = 0;

        for (Integer stake : stakes){
            totalStake += stake;
        }

        return totalStake;
    }

//    Setters
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void drawCard(Card card) {
        hand.add(card);
        evaluateCard(card);
    }
    public void setStakes(int stake) {
        this.stakes.add(stake);
    }


    //    Method evaluates each drawn card and adds its value to handValue
    public void evaluateCard(Card currentCard) {
        int aceChoice;

        if (currentCard.getRank().matches("King|Queen|Jack")){
            handValue += 10;
        } else if (currentCard.getRank().equals("Ace")) {
            System.out.println("You were dealt an Ace. You get to choose its value when you add it to your hand.");
            System.out.println("1)Ace value 1       2)Ace value 11");

            aceChoice = kInput.nextInt();
            handValue += (aceChoice == 1) ? 1 : 11;
        } else {
            handValue += Integer.parseInt(currentCard.getRank());
        }
    }
}
