package blackjack.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BlackjackMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-100, 200, 0})
    @DisplayName("성공: 값이 반대인 BlackjackMoney 생성")
    void toNegative(int amount) {
        BlackjackMoney money = new BlackjackMoney(amount);
        BlackjackMoney negativeMoney = money.toNegative();

        assertThat(negativeMoney.getAmount()).isEqualTo(-amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 0})
    @DisplayName("성공: 값이 1.5배인 BlackjackMoney 생성")
    void applyBlackjackMultiple(int amount) {
        BlackjackMoney money = new BlackjackMoney(amount);
        BlackjackMoney blackjackMoney = money.applyMultiple(PlayerState.BLACKJACK.getMultiple());

        assertThat(blackjackMoney.getAmount()).isEqualTo((int) (amount * 1.5));
    }

    @Test
    @DisplayName("성공: 합 연산")
    void add() {
        BlackjackMoney money1 = new BlackjackMoney(100);
        BlackjackMoney money2 = new BlackjackMoney(500);

        BlackjackMoney totalMoney = money1.add(money2);

        assertThat(totalMoney.getAmount()).isEqualTo(600);
    }
}