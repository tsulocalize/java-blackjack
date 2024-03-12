package domain.game;

import blackjack.domain.game.BlackjackGame;
import blackjack.domain.participant.Name;
import blackjack.domain.participant.Participants;
import blackjack.domain.participant.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import blackjack.domain.card.strategy.RandomCardGenerator;

import java.util.List;

class BlackjackGameTest {

    @Test
    @DisplayName("성공: 모든 참가자에게 시작 카드를 분배")
    void distributeStartingCards() {
        Player player1 = new Player(new Name("name1"));
        Player player2 = new Player(new Name("name2"));
        Participants participants = Participants.createWithDealer(List.of(player1, player2));
        BlackjackGame game = new BlackjackGame(participants, new RandomCardGenerator());

        game.distributeStartingCards();

        Assertions.assertThat(player1.getCards()).hasSize(2);
        Assertions.assertThat(player2.getCards()).hasSize(2);
        Assertions.assertThat(game.getDealer().getCards()).hasSize(2);
    }

    @Test
    @DisplayName("성공: 참가자에게 카드 한장 주기")
    void giveOneCard() {
        Player player = new Player(new Name("name"));
        Participants participants = Participants.createWithDealer(List.of(player));
        BlackjackGame game = new BlackjackGame(participants, new RandomCardGenerator());

        game.giveOneCard(player);

        Assertions.assertThat(player.getCards()).hasSize(1);
    }
}
