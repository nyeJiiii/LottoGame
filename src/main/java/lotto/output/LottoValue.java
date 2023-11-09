package lotto.output;

public enum LottoValue {

    LOTTO_SIZE(6),
    START_NUMBER_OF_RANGE(1),
    END_NUMBER_OF_RANGE(45),
    COST_OF_LOTTO(1000);

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}