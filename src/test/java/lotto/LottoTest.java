package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class LottoTest {
    @Test
    void 숫자_6개_생성_테스트(){
        Lotto lotto = new Lotto();
        Set<Integer> numbers = lotto.generateLotto();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 중복_테스트(){
        Lotto lotto = new Lotto();
        Set<Integer> numbers = lotto.generateLotto();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }
}
