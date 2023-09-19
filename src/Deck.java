import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};

        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 12; rank++) {
//                cards.add(ranks[rank] + " of " + suits[suit]);
                cards.add(new Card(ranks[rank], suits[suit]));
            }
        }
    }

    public void displayCards() {
        cards.forEach((card) -> System.out.println(card.display()));
    }

    public int countCards() {
        return cards.size();
    }
}
