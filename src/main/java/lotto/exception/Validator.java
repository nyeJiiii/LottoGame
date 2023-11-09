package lotto.exception;

import static lotto.util.LottoValue.COST_OF_LOTTO;
import static lotto.util.LottoValue.END_NUMBER_OF_RANGE;
import static lotto.util.LottoValue.LOTTO_SIZE;
import static lotto.util.LottoValue.START_NUMBER_OF_RANGE;

import java.util.List;
import java.util.Objects;

public class Validator {

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LUCKY_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NO_DUPLICATED_NUMBER.getMessage());
        }
    }

    public static void validateRangeOfNumbers(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < START_NUMBER_OF_RANGE.getValue() || num > END_NUMBER_OF_RANGE.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateRangeOfNumber(int number) {
        if (number < START_NUMBER_OF_RANGE.getValue() || number > END_NUMBER_OF_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        }
    }

    public static void isSmallerthanZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
        }
    }

    public static void isRightCost(int input) {
        if (input % COST_OF_LOTTO.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_COST.getMessage());
        }
    }

    public static void checkDuplicatedBonusNumber(int bonusNumber, List<Integer> luckyNumbers) {
        if (luckyNumbers.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_BONUS_NUMBER.getMessage());
        }
    }
}
