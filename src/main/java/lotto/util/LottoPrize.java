package lotto.util;

public enum LottoPrize {
    FIFTH(3, "개 일치", 5000),
    FOURTH(4, "개 일치", 50000),
    THIRD(5, "개 일치", 1500000),
    SECOND(5, "개 일치, 보너스 볼 일치", 30000000),
    FIRST(6, "개 일치", 2000000000);

    private final int count;
    private final String description;
    private final int prizeAmount;

    LottoPrize(int count, String description, int prizeAmount) {
        this.count = count;
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    @Override
    public String toString() {
        return count + description + " (" + String.format("%,d", prizeAmount) + "원)";
    }
}
