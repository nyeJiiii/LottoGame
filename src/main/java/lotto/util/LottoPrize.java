package lotto.util;

public enum LottoPrize {
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000);

    private final String description;
    private final int prizeAmount;

    LottoPrize(String description, int prizeAmount) {
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    @Override
    public String toString() {
        return description + " (" + String.format("%,d", prizeAmount) + "원)";
    }
}
