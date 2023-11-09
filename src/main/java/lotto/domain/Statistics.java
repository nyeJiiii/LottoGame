package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class Statistics {

    LottoPurchaser lottoPurchaser = LottoPurchaser.getInstance();

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private static final int firstPrize = 2000000000;
    private static final int secondPrize = 30000000;
    private static final int thirdPrize = 1500000;
    private static final int fourthPrize = 50000;
    private static final int fifthPrize = 5000;

    public void temp(Lottos lottos, Lotto lotto, BonusNumber bonusNumber) {
        List<Lotto> allLottos = lottos.getAllLottos();
        for (Lotto temp : allLottos) {
            int matchedNumber = countMatchingNumbers(temp.getNumbers(), lotto.getNumbers());
            countRank(matchedNumber, temp.getNumbers(), bonusNumber);
        }
    }

    private void checkBonusNumber(List<Integer> numbers, BonusNumber bonusNumber) {
        if (numbers.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber.getBonusNumber()))) {
            second++;
            third--;
        }
    }

    private void countRank(int matchedNumber, List<Integer> numbers, BonusNumber bonusNumber) {
        if (matchedNumber == 3) {
            fifth++;
        }
        if (matchedNumber == 4) {
            fourth++;
        }
        if (matchedNumber == 5) {
            third++;
            checkBonusNumber(numbers, bonusNumber);
        }
        if (matchedNumber == 6) {
            first++;
        }
    }

    private int countMatchingNumbers(List<Integer> numbers1, List<Integer> numbers2) {
        return (int) numbers1.stream()
                .filter(numbers2::contains)
                .count();
    }

    public int calculateprofits() {
        int profits = 0;
        profits += (first * firstPrize +
                second * secondPrize +
                third * thirdPrize +
                fourth * fourthPrize +
                fifth * fifthPrize
        );
        return profits;
    }

    public double calculateProfitRatio() {
        int profit = calculateprofits();
        double profitRatio = ((double) profit / (lottoPurchaser.getCost())) * 100;
        BigDecimal bd = new BigDecimal(profitRatio);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        return "3개 일치 (" + String.format("%,d", fifthPrize) + "원) - " + fifth + "개" + '\n' +
                "4개 일치 (" + String.format("%,d", fourthPrize) + "원) - " + fourth + "개" + '\n' +
                "5개 일치 (" + String.format("%,d", thirdPrize) + "원) - " + third + "개" + '\n' +
                "5개 일치, 보너스 볼 일치 (" + String.format("%,d", secondPrize) + "원) - " + second + "개" + '\n' +
                "6개 일치 (" + String.format("%,d", firstPrize) + "원) - " + first + "개";
    }
}
