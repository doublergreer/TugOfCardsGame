package tugofcards;

import tugofcards.cards.Card;
import tugofcards.cards.FaceCard;
import tugofcards.cards.Rank;

public class StandardMatchupStrategy implements MatchupStrategy {

    @Override
    public int calculateRopeMove(Card card1, Card card2) {
        int p1Value = card1.getPointValue();
        int p2Value = card2.getPointValue();

        if (p1Value > p2Value) {
            if (card1.getRank() == Rank.KING && !(card2 instanceof FaceCard)) {
                System.out.println("CRITICAL HIT! King overpowered a numeral card!");
                return -2; // Move 2 left
            }
            return -1; // Move 1 left
        } 
        
        else if (p2Value > p1Value) {
            if (card2.getRank() == Rank.KING && !(card1 instanceof FaceCard)) {
                System.out.println("CRITICAL HIT! King overpowered a numeral card!");
                return 2; // Move 2 right
            }
            return 1; // Move 1 right
        }
    
        // Tie
        return 0;
    }
}