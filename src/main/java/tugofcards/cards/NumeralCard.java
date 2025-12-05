package tugofcards.cards;

// cards ace->10
public class NumeralCard implements Card {
    private int pointValue;
    private String suit;

    @Override
    public int getPointValue() {
        return pointValue;
    }

    @Override
    public String getSuit() {
        return suit;
    }

    @Override
    public String getRank() {
        if (pointValue == 1) {
            return "Ace";
        } else {
            return Integer.toString(pointValue);
        }
    }
}
