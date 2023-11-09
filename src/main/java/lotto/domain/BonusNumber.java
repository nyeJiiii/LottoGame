package lotto.domain;

import java.util.List;

public class BonusNumber extends Validator {

    private Integer bonusNumber;

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String input, List<Integer> luckyNumbers) {
        int bonusNumber = parseInt(input);
        validateRangeOfNumber(bonusNumber);
        checkDuplicatedBonusNumber(bonusNumber, luckyNumbers);
        this.bonusNumber = bonusNumber;
    }
}
