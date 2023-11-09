package lotto.domain;

import static lotto.util.LottoValue.COST_OF_LOTTO;
import static lotto.util.LottoValue.END_NUMBER_OF_RANGE;
import static lotto.util.LottoValue.LOTTO_SIZE;
import static lotto.util.LottoValue.START_NUMBER_OF_RANGE;

import java.util.List;
import java.util.Objects;
import lotto.errors.ErrorMessage;

public class Validator {

    protected void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LUCKY_NUMBER_COUNT.getMessage());
        }
    }

    protected void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NO_DUPLICATED_NUMBER.getMessage());
        }
    }

    protected void validateRangeOfNumbers(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < START_NUMBER_OF_RANGE.getValue() || num > END_NUMBER_OF_RANGE.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    protected void validateRangeOfNumber(int number) {
        if (number < START_NUMBER_OF_RANGE.getValue() || number > END_NUMBER_OF_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    protected int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        }
    }

    protected void isSmallerthanZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
        }
    }

    protected void isRightCost(int input) {
        if (input % COST_OF_LOTTO.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_COST.getMessage());
        }
    }

    protected void checkDuplicatedBonusNumber(int bonusNumber, List<Integer> luckyNumbers) {
        if (luckyNumbers.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_BONUS_NUMBER.getMessage());
        }
    }
}
