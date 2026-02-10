package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static Lotto generateLotto() {
        List<LottoNumber> numbers = IntStream.range(1, 46)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        numbers.sort(Comparator.comparingInt(LottoNumber::getNumber).reversed());

        return new Lotto(numbers.subList(0, 6));
    }
}
