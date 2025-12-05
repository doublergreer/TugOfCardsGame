package tugofcards.cards;

import java.util.List;

import static tugofcards.cards.Rank.*;

public class CardFactory {
    private static final List<Rank> FACE_CARDS = List.of(JACK, QUEEN, KING);

    public Card createCard(Suit suit, Rank rank) {
        if (FACE_CARDS.contains(rank)) {
            return new FaceCard(suit, rank);
        } else {
            return new NumeralCard(suit, rank);
        }
    }
}
