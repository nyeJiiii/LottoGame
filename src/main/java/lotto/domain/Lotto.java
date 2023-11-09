package lotto.domain;

import static lotto.domain.Validator.parseInt;
import static lotto.domain.Validator.validate;
import static lotto.domain.Validator.validateDuplicatedNumber;
import static lotto.domain.Validator.validateRangeOfNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String luckyNumber) {
        List<Integer> numbers = splitLuckyNumber(luckyNumber);
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> splitLuckyNumber(String luckyNumber) {
        return Arrays.stream(luckyNumber.trim().split("\\s*,\\s*"))
                .map(s -> parseInt(s))
                .toList();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
