package lotto.output;

public enum OutputView {
    INPUT_COST("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTOS("개를 구매했습니다."),
    INPUT_LUCKY_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    STATISTICS("\n당첨 통계\n" + "---"),
    TOTAL_PROFIT_RATIO("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
