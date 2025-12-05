package tugofcards.cards;

// cards ace->10
public class NumeralCard implements Card {
    private Rank rank;
    private Suit suit;

    @Override
    public int getPointValue() {
        return rank.getPointValue();
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }
}
