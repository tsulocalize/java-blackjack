package blackjack.domain.game;

public class BlackjackMoney {

    public static final double BlackjackMultiple = 1.5;
    private final int amount;

    public BlackjackMoney() {
        this.amount = 0;
    }

    public BlackjackMoney(int amount) {
        this.amount = amount;
    }

    public BlackjackMoney toNegative() {
        return new BlackjackMoney(-amount);
    }

    public BlackjackMoney applyMultiple(double multiple) {
        return new BlackjackMoney((int) (amount * multiple));
    }

    public BlackjackMoney applyBlackjackMultiple() {
        return new BlackjackMoney((int) (amount * BlackjackMultiple));
    }

    public BlackjackMoney add(BlackjackMoney money) {
        return new BlackjackMoney(amount + money.amount);
    }

    public int getAmount() {
        return amount;
    }
}
