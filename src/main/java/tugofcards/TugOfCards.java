package tugofcards;

import tugofcards.cards.Card;
import tugofcards.cards.CardFactory;
import tugofcards.cards.Deck;
import java.util.ArrayList;
import java.util.List;

public class TugOfCards {
    private final Deck cardDeck;
    private final Deck discardDeck;
    private int ropePosition;
    
    private MatchupStrategy strategy;
    
    //Observer patterns
    private List<GameObserver> observers = new ArrayList<>();

    public TugOfCards(CardFactory cardFactory, MatchupStrategy strategy) {
        this.cardDeck = new Deck(cardFactory);
        this.cardDeck.shuffle();
        this.discardDeck = new Deck();
        this.ropePosition = 0;
        this.strategy = strategy;
    }

    //Observer methods
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    private void notify(String message) {
        for (GameObserver obs : observers) {
            obs.onGameMessage(message);
        }
    }


    public void playTurn() {
        if (isGameOver()) {
            notify("The game is already over!");
            return;
        }

        if (cardDeck.getNumberOfCards() < 2) {
            reshuffleDiscardIntoDeck();
        }

        Card card1 = cardDeck.draw();
        Card card2 = cardDeck.draw();

        notify("\n--- New Turn ---");
        notify("Player 1: " + card1 + " vs Player 2: " + card2);

        evaluateMatchup(card1, card2);

        discardDeck.addCard(card1);
        discardDeck.addCard(card2);

        notify("Rope Position: " + ropePosition);
        checkWinCondition();
    }

    public void evaluateMatchup(Card card1, Card card2) {
        //Strategy
        int movement = strategy.calculateRopeMove(card1, card2);
        
        ropePosition += movement;

        if (movement < 0) {
            notify("Player 1 pulls the rope!");
        } else if (movement > 0) {
            notify("Player 2 pulls the rope!");
        } else {
            notify("It's a tie! Rope stays put.");
        }
    }

    private void reshuffleDiscardIntoDeck() {
        notify("Reshuffling discard pile into main deck...");
        while (discardDeck.getNumberOfCards() > 0) {
            cardDeck.addCard(discardDeck.draw());
        }
        cardDeck.shuffle();
    }

    private void checkWinCondition() {
        //Singleton
        int threshold = GameConfig.getInstance().getWinThreshold();
        
        if (ropePosition <= -threshold) {
            notify(">>> PLAYER 1 WINS THE GAME! <<<");
        } else if (ropePosition >= threshold) {
            notify(">>> PLAYER 2 WINS THE GAME! <<<");
        }
    }

    public boolean isGameOver() {
        //Singleton
        int threshold = GameConfig.getInstance().getWinThreshold();
        return ropePosition <= -threshold || ropePosition >= threshold;
    }

    public String toString() {
        return "Rope: " + ropePosition + " | Cards in Deck: " + cardDeck.getNumberOfCards();
    }


    public TugOfCards(Deck cardDeck, Deck discardDeck, int ropePosition) {
        this.cardDeck = cardDeck;
        this.discardDeck = discardDeck;
        this.ropePosition = ropePosition;
        this.strategy = new StandardMatchupStrategy(); 
    }
    
    public int getCurrentRopePosition() { return ropePosition; }
    public Deck getDeck() { return cardDeck; }
    public Deck getDiscardDeck() { return discardDeck; }
}