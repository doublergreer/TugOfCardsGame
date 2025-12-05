package tugofcards.cards;

// Jack, Queen, King, and maybe Joker
public class FaceCard implements Card {
    private Suit suit;
    private Rank rank;

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
