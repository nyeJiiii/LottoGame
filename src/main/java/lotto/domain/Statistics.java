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

    public void setStatistics(Lottos lottos, Lotto luckyNumber, BonusNumber bonusNumber) {
        for (Lotto allLottos : lottos.getAllLottos()) {
            int matchedNumber = countMatchingNumbers(allLottos.getNumbers(), luckyNumber.getNumbers());
            countRank(matchedNumber, allLottos.getNumbers(), bonusNumber);
        }
    }

    private int countMatchingNumbers(List<Integer> allLottos, List<Integer> luckyNumber) {
        return (int) allLottos.stream()
                .filter(luckyNumber::contains)
                .count();
    }

    private void countRank(int matchedNumber, List<Integer> allLottos, BonusNumber bonusNumber) {
        if (matchedNumber == LottoPrize.FIFTH.getCount()) {
            fifth++;
        }
        if (matchedNumber == LottoPrize.FOURTH.getCount()) {
            fourth++;
        }
        if (matchedNumber == LottoPrize.THIRD.getCount()) {
            third++;
            checkBonusNumber(allLottos, bonusNumber);
        }
        if (matchedNumber == LottoPrize.FIRST.getCount()) {
            first++;
        }
    }

    private void checkBonusNumber(List<Integer> allLottos, BonusNumber bonusNumber) {
        if (allLottos.stream()
                .anyMatch(number -> Objects.equals(number, bonusNumber.getBonusNumber()))) {
            second++;
            third--;
        }
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

    private double calculateProfitRatio(int cost) {
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

    public void printOutProfitRatio(int cost) {
        System.out.printf(OutputView.TOTAL_PROFIT_RATIO.getMessage(), calculateProfitRatio(cost));
    }
}