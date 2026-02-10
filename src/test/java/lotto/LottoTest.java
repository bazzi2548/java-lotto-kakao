package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTest {
    @Test
    void 숫자_6개_생성_테스트(){
        var numbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);

        Assertions.assertThat(lotto.getLottoNumbers().size())
                .isEqualTo(6);
    }

    @Test
    void 중복_테스트(){
        var numbers = IntStream.range(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또번호가 6개가 아닙니다.");
    }
}
