import java.util.ArrayList;

public class Dealer {
    private int dealerHandValue;
    private ArrayList<Card> dealerHand;

    public Dealer() {
        dealerHand = new ArrayList<>();
        dealerHandValue = 0;
    }
    public void drawCard(Card card) {
        dealerHand.add(card);
        evaluateCard(card);
    }

    public int getHandValue() {
        return dealerHandValue;
    }

    public void evaluateCard(Card currentCard) {

        if (currentCard.getRank().matches("King|Queen|Jack")){
            dealerHandValue += 10;
        } else if (currentCard.getRank().equals("Ace")) {
            if (dealerHandValue >= 11){
                dealerHandValue += 1;
            } else {
                dealerHandValue += 11;
            }
        } else {
            dealerHandValue += Integer.parseInt(currentCard.getRank());
        }
    }

}

