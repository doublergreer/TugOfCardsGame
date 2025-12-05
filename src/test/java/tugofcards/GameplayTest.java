package tugofcards;

import org.junit.jupiter.api.Test;
import tugofcards.cards.Card;
import tugofcards.cards.CardFactory;
import tugofcards.cards.Deck;
import tugofcards.cards.Rank;
import tugofcards.cards.Suit;

import static org.junit.jupiter.api.Assertions.*;

public class GameplayTest {
    TugOfCards tugOfCards = new TugOfCards();
    CardFactory cardFactory = new CardFactory();

    @Test
    public void testFaceCardAbility() { // tests face card against numerical card matchup rope behavior (should move two pts instead of one)
        int ropePosition = tugOfCards.getCurrentRopePosition();

        Card card1 = cardFactory.createCard(suit.SPADES, Rank.KING);
        Card card2 = cardFactory.createCard(Suit.CLUBS, Rank.SEVEN);

        assertTrue(tugOfCards.evaluateMatchup(card1, card2));
        assertEquals(tugOfCards.getCurrentRopePosition(), ropePosition-2);
    }

    @Test
    public void testNumeralCardMatchup() {
        int ropePosition = tugOfCards.getCurrentRopePosition();

        Card card1 = cardFactory.createCard(suit.SPADES, Rank.SIX);
        Card card2 = cardFactory.createCard(Suit.CLUBS, Rank.SEVEN);

        assertFalse(tugOfCards.evaluateMatchup(card1, card2));
        assertEquals(tugOfCards.getCurrentRopePosition(), ropePosition+1);
    }
}
