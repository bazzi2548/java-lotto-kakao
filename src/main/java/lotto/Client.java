package lotto;

import lotto.domain.LottoGame;

public class Client {
    public static void main(String[] args) {
        LottoGame controller = new LottoGame();
        controller.run();
    }
}
