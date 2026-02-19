package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoTest {
    @Test
    void 숫자_6개_생성_테스트(){
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(lotto.getLottoNumbers().size())
                .isEqualTo(6);
    }

    @Test
    void 숫자_개수_테스트(){
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .withMessage("로또번호가 6개가 아닙니다.");
    }

    @Test
    void 일치하는_개수_반환(){
        Lotto userLotto = testSetLotto(1,7);
        Lotto winningLotto = testSetLotto(4,10);
        var actual = userLotto.countMatchingNumbers(winningLotto);
        Assertions.assertThat(actual).isEqualTo(3);
    }

    @Test
    void 일치_없을때_0_반환(){
        Lotto userLotto = testSetLotto(1,7);
        Lotto winningLotto = testSetLotto(8,14);
        var actual = userLotto.countMatchingNumbers(winningLotto);

        Assertions.assertThat(actual).isEqualTo(0);
    }

    Lotto testSetLotto(int start, int end){
        return new Lotto(IntStream.range(start, end)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
