package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.generator.LottoGenerator;

public class LottoGeneratorTest {
    @Test
    void 숫자_6개_생성_테스트() {
        LottoGenerator generator = new LottoGenerator();
        Lotto numbers = generator.generate();
        Assertions.assertThat(numbers.getLottoNumbers().size())
                .isEqualTo(6);
    }
}
