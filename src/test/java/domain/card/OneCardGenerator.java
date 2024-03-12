package domain.card;

import blackjack.domain.card.Card;
import blackjack.domain.card.Rank;
import blackjack.domain.card.Symbol;
import blackjack.domain.card.strategy.CardGenerator;

import java.util.ArrayList;
import java.util.List;

public class OneCardGenerator implements CardGenerator {

    @Override
    public List<Card> generate() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.KING, Symbol.CLUB));

        return cards;
    }
}
