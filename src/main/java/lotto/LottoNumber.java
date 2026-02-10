package lotto;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number){
        validateRangeOfNumber(number);
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    private static void validateRangeOfNumber(int number){
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("숫자 범위를 벗어났습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
