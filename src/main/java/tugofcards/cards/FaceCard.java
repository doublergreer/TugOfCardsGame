package tugofcards.cards;

// Jack, Queen, King, and maybe Joker
public class FaceCard implements Card {
    private final Suit suit;
    private final Rank rank;

    public FaceCard(Suit suit, Rank rank) {
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
