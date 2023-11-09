package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import lotto.util.LottoPrize;
import lotto.util.OutputView;

public class Statistics {

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    // TODO 메서드 이름 변경
    public void temp(Lottos lottos, Lotto lotto, BonusNumber bonusNumber) {
        List<Lotto> allLottos = lottos.getAllLottos();
        for (Lotto temp : allLottos) {
            int matchedNumber = countMatchingNumbers(temp.getNumbers(), lotto.getNumbers());
            countRank(matchedNumber, temp.getNumbers(), bonusNumber);
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

    private void checkBonusNumber(List<Integer> numbers, BonusNumber bonusNumber) {
        if (numbers.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber.getBonusNumber()))) {
            second++;
            third--;
        }
    }

    private int countMatchingNumbers(List<Integer> numbers1, List<Integer> numbers2) {
        return (int) numbers1.stream()
                .filter(numbers2::contains)
                .count();
    }

    public int calculateprofits() {
        int profits = 0;
        profits += (first * LottoPrize.FIRST.getPrizeAmount() +
                second * LottoPrize.SECOND.getPrizeAmount() +
                third * LottoPrize.THIRD.getPrizeAmount() +
                fourth * LottoPrize.FOURTH.getPrizeAmount() +
                fifth * LottoPrize.FIFTH.getPrizeAmount()
        );
        return profits;
    }

    public void printOutProfitRatio(int cost) {
        System.out.printf(OutputView.TOTAL_PROFIT_RATIO.getMessage(), calculateProfitRatio(cost));
    }

    public double calculateProfitRatio(int cost) {
        int profit = calculateprofits();
        double profitRatio = ((double) profit / (cost)) * 100;
        BigDecimal bd = new BigDecimal(profitRatio);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void printOutStatistics() {
        System.out.println(LottoPrize.FIFTH + " - " + fifth + "개");
        System.out.println(LottoPrize.FOURTH + " - " + fourth + "개");
        System.out.println(LottoPrize.THIRD + " - " + third + "개");
        System.out.println(LottoPrize.SECOND + " - " + second + "개");
        System.out.println(LottoPrize.FIRST + " - " + first + "개");
    }
}