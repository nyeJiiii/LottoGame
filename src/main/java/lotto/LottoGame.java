package lotto;

import static lotto.output.LottoValue.END_NUMBER_OF_RANGE;
import static lotto.output.LottoValue.LOTTO_SIZE;
import static lotto.output.LottoValue.START_NUMBER_OF_RANGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaser;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.errors.ErrorMessage;

public class LottoGame {

    LottoPurchaser lottoPurchaser = new LottoPurchaser();
    BonusNumber bonusNumber = new BonusNumber();
    Statistics statistics = new Statistics();
    Lotto luckyNumbers = null;
    Lottos lottos = null;

    public void getRightCost() {
        boolean fail;
        do {
            fail = getCost();
        } while (fail);
    }

    private boolean getCost() {
        try {
            lottoPurchaser.setNumberOfLottos(Console.readLine());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void printOutNumberOfLottos() {
        System.out.println(lottoPurchaser.returnNumberOfLottos());
    }

    public Lottos createLottos() {
        lottos = new Lottos(addLottos());
        return lottos;
    }

    public List<Lotto> addLottos() {
        return IntStream.range(0, lottoPurchaser.getNumberOfLottos())
                .mapToObj(i -> new Lotto(getSortedRandomNumber()))
                .collect(Collectors.toList());
    }

    private List<Integer> getSortedRandomNumber() {
        List<Integer> randomNumber = getRandomNumber();
        randomNumber.sort(Comparator.naturalOrder());
        return randomNumber;
    }

    private List<Integer> getRandomNumber() {
        List<Integer> beforeSorted = Randoms.pickUniqueNumbersInRange(
                START_NUMBER_OF_RANGE.getValue(), END_NUMBER_OF_RANGE.getValue(), LOTTO_SIZE.getValue()
        );
        return new ArrayList<>(beforeSorted);
    }

    public void getRightLuckyNumbers() {
        boolean success = false;
        do {
            success = getLuckyNumbers();
        } while (success == false);
    }

    private boolean getLuckyNumbers() {
        try {
            luckyNumbers = new Lotto(Console.readLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void getRightBonusNumber() {
        boolean success;
        do {
            success = getBonusNumber();
        } while (success == false);
    }

    private boolean getBonusNumber() {
        try {
            bonusNumber.setBonusNumber(Console.readLine());
            checkDuplicatedBonusNumber(bonusNumber, luckyNumbers.getNumbers());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void checkDuplicatedBonusNumber(BonusNumber bonusNumber, List<Integer> luckyNumbers) {
        if (luckyNumbers.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber.getBonusNumber()))) {
            bonusNumber.setBonusNumber(null);
            throw new IllegalArgumentException(ErrorMessage.WRONG_BONUS_NUMBER.getMessage());
        }
    }

    public void calculateStatistics() {
        statistics.temp(lottos, luckyNumbers, bonusNumber);
    }

    public void printOutStatistics() {
        statistics.printOutStatistics();
    }

    public void printOutProfitRatio() {
        statistics.printOutProfitRatio(lottoPurchaser.getCost());
    }

}
