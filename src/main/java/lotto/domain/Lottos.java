package lotto.domain;

import static lotto.exception.Validator.isRightCost;
import static lotto.exception.Validator.isSmallerthanZero;
import static lotto.exception.Validator.parseInt;
import static lotto.util.RandomNumber.getSortedRandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.LottoValue;
import lotto.util.OutputView;

public class Lottos {

    private List<Lotto> allLottos;
    private int numberOfLottos;
    private int totalCost;

    public List<Lotto> getAllLottos() {
        return allLottos;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setAllLottos() {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, numberOfLottos)
                .forEach(i -> lottos.add(new Lotto(getSortedRandomNumber())));
        this.allLottos = lottos;
    }

    public void getInputCost(String input) {
        setNumberOfLottos(setTotalCost(input));
    }

    public int setTotalCost(String input) {
        this.totalCost = parseInt(input);
        return totalCost;
    }

    public void setNumberOfLottos(int cost) {
        isSmallerthanZero(cost);
        isRightCost(cost);
        this.numberOfLottos = cost / LottoValue.COST_OF_LOTTO.getValue();
    }

    public String returnNumberOfLottos() {
        return this.numberOfLottos + OutputView.NUMBER_OF_LOTTOS.getMessage();
    }

    @Override
    public String toString() {
        return allLottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}