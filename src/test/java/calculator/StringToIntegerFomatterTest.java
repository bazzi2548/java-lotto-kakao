package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringToIntegerFomatterTest {

    StringToIntegerFomatter formatter;

    @BeforeEach
    void init(){
        formatter = new StringToIntegerFomatter();
    }


    @Test
    void 쉼표_또는_콜론_구분자() {
        String commaAndColon = "1,2:3";
        List<String> result = formatter.format(commaAndColon);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자() {
        String custom = "//;\n1;2;3";
        List<String> result = formatter.format(custom);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 음수_예외처리() {
        List<String> custom = List.of("10", "-1");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> formatter.validator(custom))
                .withMessage("음수가 있습니다.");
    }

    @Test
    void 문자_예외처리() {
        List<String> custom = List.of("나", "-1");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> formatter.validator(custom))
                .withMessageContaining("숫자가 아닌 값이 있습니다.");
    }

}
