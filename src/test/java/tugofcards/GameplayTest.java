package tugofcards;

import org.junit.jupiter.api.Test;
import tugofcards.cards.Card;
import tugofcards.cards.CardFactory;
import tugofcards.cards.Rank;
import tugofcards.cards.Suit;

import static org.junit.jupiter.api.Assertions.*;

public class GameplayTest {
    CardFactory cardFactory = new CardFactory();
    
    TugOfCards game = new TugOfCardsBuilder().build();

    @Test
    public void testFaceCardAbility() {
        int ropePosition = game.getCurrentRopePosition();

        Card card1 = cardFactory.createCard(Suit.SPADES, Rank.KING);
        Card card2 = cardFactory.createCard(Suit.CLUBS, Rank.SEVEN);


        game.evaluateMatchup(card1, card2);
        

        assertEquals(ropePosition - 2, game.getCurrentRopePosition());
    }

    @Test
    public void testNumeralCardMatchup() {
        int ropePosition = game.getCurrentRopePosition();

        Card card1 = cardFactory.createCard(Suit.SPADES, Rank.SIX);
        Card card2 = cardFactory.createCard(Suit.CLUBS, Rank.SEVEN);

        game.evaluateMatchup(card1, card2);


        assertEquals(ropePosition + 1, game.getCurrentRopePosition());
    }
}