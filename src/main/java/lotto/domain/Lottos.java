package lotto.domain;

import static lotto.util.RandomNumber.getSortedRandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.OutputView;

public class Lottos extends Validator {

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

    public void setNumberOfLottos(String input) {
        int cost = parseInt(input);
        this.totalCost = cost;
        isSmallerthanZero(cost);
        // TODO 메서드 이름, 메서드 분리
        calculateNumberOfLottos(cost);
        this.numberOfLottos = cost / 1000;
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