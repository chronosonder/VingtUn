import java.util.ArrayList;

public class Player {
    private String name;
    private int handValue;
    private ArrayList<Card> hand;

    public Player(String playerName) {
        this.name = playerName;
        hand = new ArrayList<>();
        handValue = 0;
    }


    public void drawCard(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public  String getName() {
        return name;
    }

    public void evaluateCard(Card currentCard) {
//        hand.forEach((card) -> card.getRank().matches("King|Queen|Jack"));

        if (currentCard.getRank().matches("King|Queen|Jack")){
            handValue += 10;
        } else if (currentCard.getRank().equals("Ace")) {
            System.out.println("You were dealt an Ace. You get to choose its value when you add it to your hand.");
            System.out.println("1)Ace value 1       2)Ace value 11");


//            Left here
        }

//        for (Card card:
//             hand) {
//            if (card.getRank().matches("King|Queen|Jack")) {
//                handValue += 10;
//            }
//        }
    }

}
