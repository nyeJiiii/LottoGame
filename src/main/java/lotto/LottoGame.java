package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.errors.ErrorMessage;

public class LottoGame {

    BonusNumber bonusNumber = new BonusNumber();
    Statistics statistics = new Statistics();
    Lottos allLottos = new Lottos();
    Lotto luckyNumbers = null;

    public void getRightCost() {
        boolean fail;
        do {
            fail = getCost();
        } while (fail);
    }

    private boolean getCost() {
        try {
            allLottos.getInputCost(Console.readLine());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void printOutNumberOfLottos() {
        System.out.println('\n' + allLottos.returnNumberOfLottos());
    }

    public Lottos createLottos() {
        allLottos.setAllLottos();
        return allLottos;
    }

    public void getRightLuckyNumbers() {
        boolean fail;
        do {
            fail = getLuckyNumbers();
        } while (fail);
    }

    private boolean getLuckyNumbers() {
        try {
            luckyNumbers = new Lotto(Console.readLine());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void getRightBonusNumber() {
        boolean fail;
        do {
            fail = getBonusNumber();
        } while (fail);
    }

    private boolean getBonusNumber() {
        try {
            bonusNumber.setBonusNumber(Console.readLine());
            checkDuplicatedBonusNumber(bonusNumber, luckyNumbers.getNumbers());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
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
        statistics.temp(allLottos, luckyNumbers, bonusNumber);
    }

    public void printOutStatistics() {
        statistics.printOutStatistics();
    }

    public void printOutProfitRatio() {
        statistics.printOutProfitRatio(allLottos.getTotalCost());
    }

}
