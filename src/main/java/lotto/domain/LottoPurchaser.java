package lotto.domain;

import lotto.output.OutputView;

public class LottoPurchaser extends Validator {

    private int numberOfLottos;
    private int cost;

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    public int getCost() {
        return cost;
    }

    // TODO 1000변경
    public void setNumberOfLottos(String cost) {
        int integerCost = parseInt(cost);
        isSmallerthanZero(integerCost);
        calculateNumberOfLottos(integerCost);
        this.cost = integerCost;
        this.numberOfLottos = integerCost / 1000;
    }

    public String returnNumberOfLottos() {
        return this.numberOfLottos + OutputView.NUMBER_OF_LOTTOS.getMessage();
    }


}
