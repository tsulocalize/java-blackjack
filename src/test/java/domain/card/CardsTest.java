package domain.card;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    @DisplayName("성공: 카드를 한 장 받을 수 있다")
    void receive_NoException() {
        Cards cards = new Cards();
        cards.receive(new Card(Rank.KING, Symbol.DIAMOND));
        Assertions.assertThat(cards.getCards()).hasSize(1);
    }

    @Test
    @DisplayName("성공: 카드를 여러장 받을 수 있다")
    void receive_NoException_SeveralCards() {
        Cards cards = new Cards();
        cards.receive(List.of(
            new Card(Rank.KING, Symbol.DIAMOND),
            new Card(Rank.KING, Symbol.HEART)
        ));
        Assertions.assertThat(cards.getCards()).hasSize(2);
    }

    @Test
    @DisplayName("성공: 카드 점수의 합을 계산(경계값 21점)")
    void calculateScore_NoException_OneKingOneSevenOneFour() {
        Cards cards = new Cards();
        cards.receive(List.of(
            new Card(Rank.KING, Symbol.DIAMOND),
            new Card(Rank.SEVEN, Symbol.HEART),
            new Card(Rank.FOUR, Symbol.CLUB)
        ));
        Assertions.assertThat(cards.calculateScore())
            .isEqualTo(21);
    }

    @Test
    @DisplayName("성공: 카드 점수의 합을 계산(경계값 22점)")
    void calculateScore_NoException_OneKingOneSevenOneFive() {
        Cards cards = new Cards();
        cards.receive(List.of(
            new Card(Rank.KING, Symbol.DIAMOND),
            new Card(Rank.SEVEN, Symbol.HEART),
            new Card(Rank.FIVE, Symbol.CLUB)
        ));
        Assertions.assertThat(cards.calculateScore())
            .isEqualTo(22);
    }

    // 12, 22로 계산될 수 있으나, 21이하 점수 중 최고점인 12을 반환한다.
    @Test
    @DisplayName("성공: 점수 합 계산(ACE 2장 -> 12점)")
    void calculateScore_NoException_TwoAces() {
        Cards cards = new Cards();
        cards.receive(List.of(
            new Card(Rank.ACE, Symbol.DIAMOND),
            new Card(Rank.ACE, Symbol.HEART)
        ));
        Assertions.assertThat(cards.calculateScore())
            .isEqualTo(12);
    }

    // 11, 21, 31으로 계산될 수 있으나, 21이하 점수 중 최고점인 21을 반환한다.
    @Test
    @DisplayName("성공: 점수 합 계산(ACE 2장, NINE 1장 -> 21점)")
    void calculateScore_NoException_TwoAcesOneNine() {
        Cards cards = new Cards();
        cards.receive(List.of(
            new Card(Rank.ACE, Symbol.DIAMOND),
            new Card(Rank.ACE, Symbol.HEART),
            new Card(Rank.NINE, Symbol.CLUB)
        ));
        Assertions.assertThat(cards.calculateScore())
            .isEqualTo(21);
    }
}