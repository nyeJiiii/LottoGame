package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    BonusNumber bm = new BonusNumber();
    List<Integer> luckyNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @ValueSource(strings = {"k", "1.2"})
    @DisplayName("보너스 번호: 정수가 아닌 숫자가 들어올 때 예외처리")
    void test_setBonusNumber_1(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber, luckyNumbers))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("보너스 번호: Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setBonusNumber_2(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber, luckyNumbers))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스 번호: 1~45 범위를 벗어나는 숫자일 때 예외처리")
    void test_setBonusNumber_3(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber, luckyNumbers))
                .withMessage(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3"})
    @DisplayName("보너스 번호: 당첨 번호와 중복되는 숫자일 때 예외처리")
    void test_setBonusNumber_4(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber, luckyNumbers))
                .withMessage(ErrorMessage.WRONG_BONUS_NUMBER.getMessage());
    }
}