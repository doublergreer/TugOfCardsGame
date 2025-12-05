package tugofcards;

import tugofcards.cards.Card;
import tugofcards.cards.CardFactory;
import tugofcards.cards.Deck;
import tugofcards.cards.FaceCard;
import tugofcards.cards.Rank;

public class TugOfCards {
    private final Deck cardDeck;
    private final Deck discardDeck;
    private int ropePosition;

    private static final int PLAYER_1_WIN_POS = -10;
    private static final int PLAYER_2_WIN_POS = 10;


    public TugOfCards(CardFactory cardFactory) {
        this.cardDeck = new Deck(cardFactory);
        this.cardDeck.shuffle();
        this.discardDeck = new Deck();
        this.ropePosition = 0;
    }

    public TugOfCards(Deck cardDeck, Deck discardDeck, int ropePosition) {
        this.cardDeck = cardDeck;
        this.discardDeck = discardDeck;
        this.ropePosition = ropePosition;
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
        int p1Value = card1.getPointValue();
        int p2Value = card2.getPointValue();

        if (p1Value > p2Value) {
            int pullStrength = 1;
            
            // Special Ability: King vs Non-Face Card
            if (card1.getRank() == Rank.KING && !(card2 instanceof FaceCard)) {
                pullStrength = 2;
                System.out.println("CRITICAL HIT! King overpowered a numeral card!");
            }
            
            ropePosition -= pullStrength;
            return true;

        } else if (p2Value > p1Value) {
            int pullStrength = 1;
            
            // Special Ability: King vs Non-Face Card
            if (card2.getRank() == Rank.KING && !(card1 instanceof FaceCard)) {
                pullStrength = 2;
                System.out.println("CRITICAL HIT! King overpowered a numeral card!");
            }
            
            ropePosition += pullStrength;
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


    public String toString() { // returns current game state to help with debugging
        return "Rope: " + ropePosition + " | Cards remaining: " + cardDeck.getNumberOfCards();
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
