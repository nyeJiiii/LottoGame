package lotto;

import lotto.output.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame();

        System.out.println(OutputView.INPUT_COST.getMessage());
        lottoGame.getRightCost();

        lottoGame.printOutNumberOfLottos();
        System.out.println(lottoGame.createLottos());

        System.out.println(OutputView.INPUT_LUCKY_NUMBER.getMessage());
        lottoGame.getRightLuckyNumbers();

        System.out.println(OutputView.INPUT_BONUS_NUMBER.getMessage());
        lottoGame.getRightBonusNumber();

        System.out.println(OutputView.STATISTICS.getMessage());
        lottoGame.calculateStatistics();
        lottoGame.printOutStatistics();
        lottoGame.printOutProfitRatio();

    }
}
