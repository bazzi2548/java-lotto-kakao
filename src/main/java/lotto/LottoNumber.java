package lotto;

import java.util.Random;

public class LottoNumber {
    public int generateNumber(){
        Random random = new Random();
        return random.nextInt(45) + 1;
    }
}
