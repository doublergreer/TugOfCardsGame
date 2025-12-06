package tugofcards;

import tugofcards.cards.CardFactory;

public class TugOfCardsBuilder {
    private CardFactory cardFactory;
    private MatchupStrategy strategy;

    public TugOfCardsBuilder() {
        this.cardFactory = new CardFactory();
        this.strategy = new StandardMatchupStrategy();
    }

    public TugOfCardsBuilder setStrategy(MatchupStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public TugOfCards build() {
        return new TugOfCards(cardFactory, strategy);
    }
}