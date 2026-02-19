package lotto.generator;

import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;

    public static Lotto generateLotto() {
        List<LottoNumber> numbers = LottoNumber.getAvailableNumbers();
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, LOTTO_SIZE));
    }
}
