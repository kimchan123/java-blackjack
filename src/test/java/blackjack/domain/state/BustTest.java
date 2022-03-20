package blackjack.domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;

class BustTest {

	@Test
	@DisplayName("draw를 실행하면 에러가 발생한다.")
	void draw() {
		Cards cards = new Cards(Arrays.asList(Card.valueOf(Denomination.ACE, Suit.CLOVER),
			Card.valueOf(Denomination.JACK, Suit.CLOVER),
			Card.valueOf(Denomination.ACE, Suit.DIAMOND)));
		Bust bust = new Bust(cards);

		assertThatThrownBy(() -> bust.draw(Card.valueOf(Denomination.ACE, Suit.SPADE)))
			.isInstanceOf(IllegalStateException.class)
			.hasMessageContaining("턴이 종료된 상태입니다.");
	}

	@Test
	@DisplayName("stay를 실행하면 에러가 발생한다.")
	void stay() {
		Cards cards = new Cards(Arrays.asList(Card.valueOf(Denomination.ACE, Suit.CLOVER),
			Card.valueOf(Denomination.JACK, Suit.CLOVER),
			Card.valueOf(Denomination.ACE, Suit.DIAMOND)));
		Bust bust = new Bust(cards);

		assertThatThrownBy(() -> bust.stay())
			.isInstanceOf(IllegalStateException.class)
			.hasMessageContaining("턴이 종료된 상태입니다.");
	}

	@Test
	@DisplayName("턴을 더이상 진행할 수 없다.")
	void is_finished() {
		Cards cards = new Cards(Arrays.asList(Card.valueOf(Denomination.ACE, Suit.CLOVER),
			Card.valueOf(Denomination.JACK, Suit.CLOVER),
			Card.valueOf(Denomination.ACE, Suit.DIAMOND)));
		Bust bust = new Bust(cards);

		assertThat(bust.isFinished()).isTrue();
	}
}
