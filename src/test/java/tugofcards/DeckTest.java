package tugofcards;

import org.junit.jupiter.api.Test;
import tugofcards.cards.*;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    CardFactory cardFactory = new CardFactory();

    @Test
    public void testDeckCycling() { // when deck length is 0, playing a turn should move discard deck into deck & shuffle
        Deck deck = new Deck();
        Deck discardDeck = new Deck();

        Card ace = cardFactory.createCard(Suit.DIAMONDS, Rank.ACE);
        Card queen = cardFactory.createCard(Suit.DIAMONDS, Rank.QUEEN);

        discardDeck.addCard(ace);
        discardDeck.addCard(queen);

        TugOfCards game = new TugOfCards(deck, discardDeck, 2);

        game.playTurn();

        assertEquals(game.getDeck().getNumberOfCards(), discardDeck.getNumberOfCards());
    }
}
