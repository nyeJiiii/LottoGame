package lotto.util;

import static lotto.util.LottoValue.END_NUMBER_OF_RANGE;
import static lotto.util.LottoValue.LOTTO_SIZE;
import static lotto.util.LottoValue.START_NUMBER_OF_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomNumber {

    public static List<Integer> getSortedRandomNumber() {
        List<Integer> randomNumber = getRandomNumber();
        randomNumber.sort(Comparator.naturalOrder());
        return randomNumber;
    }

    private static List<Integer> getRandomNumber() {
        List<Integer> beforeSorted = Randoms.pickUniqueNumbersInRange(
                START_NUMBER_OF_RANGE.getValue(), END_NUMBER_OF_RANGE.getValue(), LOTTO_SIZE.getValue()
        );
        return new ArrayList<>(beforeSorted);
    }
}
