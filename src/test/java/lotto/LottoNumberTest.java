package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("1부터 45사이의 숫자 확인")
    @Test
    void 숫자_생성_테스트(){
        LottoNumber lottoNumber = new LottoNumber();
        int number = lottoNumber.generateNumber();
        Assertions.assertThat(number).isBetween(1, 45);
    }
}
