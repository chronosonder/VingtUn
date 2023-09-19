public class Card {

   private final String suit;
   private String rank;

//    Card Class constructor for initialisation
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String display() {
        return rank + " of " + suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

}
