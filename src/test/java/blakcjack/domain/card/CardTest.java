package blakcjack.domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @DisplayName("카드 객체 생성 성공")
    @Test
    void create() {
        final Card card = Card.of(CardSymbol.HEART, CardNumber.ACE);
        assertThat(card).isEqualTo(Card.of(CardSymbol.HEART, CardNumber.ACE));
    }

    @DisplayName("캐싱 확인")
    @Test
    void cache() {
        assertThat(Card.of(CardSymbol.HEART, CardNumber.ACE))
                .isSameAs(Card.of(CardSymbol.HEART, CardNumber.ACE));
    }
}
