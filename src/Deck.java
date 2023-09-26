import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};

        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 12; rank++) {
                cards.add(new Card(ranks[rank], suits[suit]));
            }
        }

        shuffleDeck();
    }

    public void displayCards() {
        cards.forEach((card) -> System.out.println(card.display()));
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        Card dealtCard = cards.get(0);
        cards.remove(0);

        return dealtCard;
    }
}
