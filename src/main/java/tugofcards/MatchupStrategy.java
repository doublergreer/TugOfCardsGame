package tugofcards;

import tugofcards.cards.Card;

public interface MatchupStrategy {
    int calculateRopeMove(Card card1, Card card2);
}