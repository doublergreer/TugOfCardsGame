package tugofcards;

import org.junit.jupiter.api.Test;
import tugofcards.cards.Card;
import tugofcards.cards.CardFactory;
import tugofcards.cards.Deck;
import tugofcards.cards.Rank;
import tugofcards.cards.Suit;

import static org.junit.jupiter.api.Assertions.*;

public class GameplayTest {
    CardFactory cardFactory = new CardFactory();
    TugOfCards game = new TugOfCards(cardFactory);

    @Test
    public void testFaceCardAbility() { // tests face card against numerical card matchup rope behavior (should move two pts instead of one)
        int ropePosition = game.getCurrentRopePosition();

        Card card1 = cardFactory.createCard(Suit.SPADES, Rank.KING);
        Card card2 = cardFactory.createCard(Suit.CLUBS, Rank.SEVEN);

        assertTrue(game.evaluateMatchup(card1, card2));
        assertEquals(game.getCurrentRopePosition(), ropePosition-2);
    }

    @Test
    public void testNumeralCardMatchup() {
        int ropePosition = game.getCurrentRopePosition();

        Card card1 = cardFactory.createCard(Suit.SPADES, Rank.SIX);
        Card card2 = cardFactory.createCard(Suit.CLUBS, Rank.SEVEN);

        assertFalse(game.evaluateMatchup(card1, card2));
        assertEquals(game.getCurrentRopePosition(), ropePosition+1);
    }
}
