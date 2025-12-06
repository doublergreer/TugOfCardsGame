package tugofcards.cards;

public interface Card {
    int getPointValue();
    Suit getSuit();
    Rank getRank();
    String toString();
}
