package lotto.output;

public enum OutputView {
    INPUT_COST("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTOS("개를 구매했습니다.");

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
