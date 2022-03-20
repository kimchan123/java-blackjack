package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class Started implements State {

	protected final Cards cards;

	protected Started(Cards cards) {
		this.cards = cards;
	}

	@Override
	public Cards getCards() {
		return this.cards;
	}
}
