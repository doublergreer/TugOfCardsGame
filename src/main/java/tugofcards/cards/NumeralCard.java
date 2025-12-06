package tugofcards.cards;

// cards ace->10
public class NumeralCard implements Card {
    private final Rank rank;
    private final Suit suit;

    public NumeralCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

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

    @Override
    public String toString() {
        return String.format("%s %s", rank, suit);
    }
}
