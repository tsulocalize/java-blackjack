package blackjack.domain.card;

import blackjack.domain.card.strategy.CardGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DeckCards {

    private final List<Card> cards;

    private DeckCards(List<Card> cards) {
        this.cards = cards;
    }

    public static DeckCards from(CardGenerator cardGenerator) {
        List<Card> generatedCards = new ArrayList<>(cardGenerator.generate());
        return new DeckCards(generatedCards);
    }

    public List<Card> drawCards(int amount) {
        validateAmount(amount);
        return IntStream.range(0, amount)
                .mapToObj(i -> drawCard())
                .toList();
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("[ERROR] 카드를 모두 사용하였습니다.");
        }
        return cards.remove(cards.size() - 1);
    }

    private void validateAmount(int amount) {
        if (cards.size() < amount) {
            throw new IllegalArgumentException(
                    String.format("[ERROR]덱에 남은 카드 수가 요청한 카드 수보다 적습니다.%n"
                            + "요청 카드 수: %d, 남은 카드 수: %d", amount, cards.size()));
        }
    }
}
