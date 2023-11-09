package lotto;

import lotto.domain.LottoPurchaser;
import lotto.output.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoPurchaser lottoPurchaser = LottoPurchaser.getInstance();
        LottoGame lottoGame = new LottoGame();

        System.out.println(OutputView.INPUT_COST.getMessage());
        lottoGame.getRightCost();

        System.out.println("\n" + lottoPurchaser.printOutNumberOfLottos());
        System.out.println(lottoGame.createLottos());

        System.out.println(OutputView.INPUT_LUCKY_NUMBER.getMessage());
        lottoGame.getRightLuckyNumbers();

        System.out.println(OutputView.INPUT_BONUS_NUMBER.getMessage());
        lottoGame.getRightBonusNumber();

        System.out.println(OutputView.STATISTICS.getMessage());
        lottoGame.calculateStatistics();
        lottoGame.print();

        lottoGame.printOutProfitRatio();
    }
}
