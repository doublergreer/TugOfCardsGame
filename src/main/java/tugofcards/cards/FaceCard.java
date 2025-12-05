package tugofcards.cards;

// Jack, Queen, King, and maybe Joker
public class FaceCard implements Card {
    private int pointValue;
    private String suit;
    private String rank;

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
        return rank;
    }
}
