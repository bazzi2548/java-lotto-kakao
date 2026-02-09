package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init(){
        calculator = new Calculator();
    }

    @Test
    void 더하기_테스트(){
        List<String> numberList = List.of("1","2","4");
        int result = calculator.add(numberList);
        assertThat(result).isEqualTo(7);
    }

}
