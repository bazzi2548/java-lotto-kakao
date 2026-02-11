package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoJudgeTest {

    private final Lotto lotto = testSetLotto();

    @Test
    @DisplayName("일치하는 개수 판단")
    void 일치개수_테스트() {
        var winning = new WinningLotto(testSetWinning(20, 26), new LottoNumber(40));
        Assertions.assertThat(LottoJudge.judge(winning, lotto)).isEqualTo(Rank.MISS);
    }

    @Test
    void 일등_테스트() {
        var winning = new WinningLotto(testSetWinning(1, 7), new LottoNumber(40));

        Assertions.assertThat(LottoJudge.judge(winning, lotto)).isEqualTo(Rank.FIRST);
    }

    Lotto testSetLotto() {
        return new Lotto(IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    List<LottoNumber> testSetWinning(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
