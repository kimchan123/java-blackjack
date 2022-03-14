package blackjack.domain.participant;

import blackjack.domain.card.Cards;

public class Dealer extends Participant {

    public static final String NAME = "딜러";
    public static final int DRAW_STANDARD = 16;

    public Dealer(Name name, Cards cards) {
        super(name, cards);
    }

    @Override
    public boolean isFinished() {
        return cards.sum() > DRAW_STANDARD || cards.isBlackJack();
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "name=" + name +
                ", cards=" + cards +
                '}';
    }
}
