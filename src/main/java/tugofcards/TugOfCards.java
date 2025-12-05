package tugofcards;

import tugofcards.cards.CardFactory;
import tugofcards.cards.Deck;
import tugofcards.cards.FaceCard;

public class TugOfCards {
    private final Deck cardDeck;
    private final Deck discardDeck;
    private int ropePosition;

    public TugOfCards(CardFactory cardFactory) {
        this.cardDeck = new Deck(cardFactory);
        this.discardDeck = new Deck();
        this.ropePosition = 0;
    }

    public TugOfCards(Deck cardDeck, Deck discardDeck, int ropePosition) {
        this.cardDeck = cardDeck;
        this.discardDeck = discardDeck;
        this.ropePosition = ropePosition;
    }

    public void playTurn() {}

    // returns true if focal player (card1) wins, and false otherwise. evaluate based on card.getPointValue()
    public boolean evaluateMatchup(Card card1, Card card2) {}

    public String toString() {
        return "";
    }

    public int getCurrentRopePosition() {
        return ropePosition;
    }

    public Deck getDeck() {
        return cardDeck;
    }

    public Deck getDiscardDeck() {
        return discardDeck;
    }
}
