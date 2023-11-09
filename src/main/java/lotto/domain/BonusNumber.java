package lotto.domain;

import static lotto.domain.Validator.checkDuplicatedBonusNumber;
import static lotto.domain.Validator.parseInt;
import static lotto.domain.Validator.validateRangeOfNumber;

import java.util.List;

public class BonusNumber {

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
