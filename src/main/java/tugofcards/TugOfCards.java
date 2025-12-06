package tugofcards;

import tugofcards.cards.Card;
import tugofcards.cards.CardFactory;
import tugofcards.cards.Deck;

public class TugOfCards {
    private final Deck cardDeck;
    private final Deck discardDeck;
    private int ropePosition;
    
    private MatchupStrategy strategy;

    private static final int PLAYER_1_WIN_POS = -10;
    private static final int PLAYER_2_WIN_POS = 10;

    public TugOfCards(CardFactory cardFactory) {
        this.cardDeck = new Deck(cardFactory);
        this.cardDeck.shuffle();
        this.discardDeck = new Deck();
        this.ropePosition = 0;
        
        this.strategy = new StandardMatchupStrategy();
    }

    public TugOfCards(CardFactory cardFactory, MatchupStrategy strategy) {
        this(cardFactory);
        this.strategy = strategy;
    }

    public TugOfCards(Deck cardDeck, Deck discardDeck, int ropePosition) {
        this.cardDeck = cardDeck;
        this.discardDeck = discardDeck;
        this.ropePosition = ropePosition;
        this.strategy = new StandardMatchupStrategy();
    }

    public void playTurn() {
        if (isGameOver()) {
            System.out.println("The game is already over!");
            return;
        }

        if (cardDeck.getNumberOfCards() < 2) {
            reshuffleDiscardIntoDeck();
        }

        Card card1 = cardDeck.draw();
        Card card2 = cardDeck.draw();

        System.out.println("\n--- New Turn ---");
        System.out.println("Player 1: " + card1 + " vs Player 2: " + card2);

        evaluateMatchup(card1, card2);

        discardDeck.addCard(card1);
        discardDeck.addCard(card2);

        System.out.println("Rope Position: " + ropePosition);
        checkWinCondition();
    }

    public boolean evaluateMatchup(Card card1, Card card2) {
        int movement = strategy.calculateRopeMove(card1, card2);
        
        ropePosition += movement;
        
        if (movement < 0) {
            System.out.println("Player 1 pulls the rope!");
            return true;
        } else if (movement > 0) {
            System.out.println("Player 2 pulls the rope!");
            return false;
        } else {
            System.out.println("It's a tie! Rope stays put.");
            return false;
        }
    }

    private void reshuffleDiscardIntoDeck() {
        System.out.println("Reshuffling discard pile into main deck...");
        while (discardDeck.getNumberOfCards() > 0) {
            cardDeck.addCard(discardDeck.draw());
        }
        cardDeck.shuffle();
    }

    private void checkWinCondition() {
        if (ropePosition <= PLAYER_1_WIN_POS) {
            System.out.println(">>> PLAYER 1 WINS THE GAME! <<<");
        } else if (ropePosition >= PLAYER_2_WIN_POS) {
            System.out.println(">>> PLAYER 2 WINS THE GAME! <<<");
        }
    }

    public boolean isGameOver() {
        return ropePosition <= PLAYER_1_WIN_POS || ropePosition >= PLAYER_2_WIN_POS;
    }

    public String toString() {
        return "Rope: " + ropePosition + " | Cards in Deck: " + cardDeck.getNumberOfCards();
    }

    public int getCurrentRopePosition() { return ropePosition; }
    public Deck getDeck() { return cardDeck; }
    public Deck getDiscardDeck() { return discardDeck; }

    public void setStrategy(MatchupStrategy strategy) {
        this.strategy = strategy;
    }
    
}