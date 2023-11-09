package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    Lottos lottos = new Lottos();

    @ParameterizedTest
    @ValueSource(strings = {"k", "1.2"})
    @DisplayName("구입금액: 정수가 아닌 숫자가 들어올 때 예외처리")
    void test_setNumberOfLottos_1(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottos.getInputCost(inputCost))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("구입금액: Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setNumberOfLottos_2(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottos.getInputCost(inputCost))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2001"})
    @DisplayName("구입금액: 1000의 배수가 아닌 숫자가 들어올 때 예외처리")
    void test_setNumberOfLottos_3(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottos.getInputCost(inputCost))
                .withMessage(ErrorMessage.WRONG_COST.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-5"})
    @DisplayName("구입금액: 숫자 0이 들어올 때 예외처리")
    void test_setNumberOfLottos_4(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottos.getInputCost(inputCost))
                .withMessage(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "21000", "512000"})
    @DisplayName("구입금액: 적절한 값이 들어올 때 테스트 통과")
    void test_setNumberOfLottos_5(String inputCost) {
        assertThatCode(() -> lottos.getInputCost(inputCost))
                .doesNotThrowAnyException();
    }

}