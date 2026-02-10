package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            Money money = new Money(InputView.readPurchaseAmount());
            LottoBundle lottos = buyLottos(money);
            processResult(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run(); // 예외 발생 시 재시도 로직
        }
    }

    private LottoBundle buyLottos(Money money) {
        int count = money.calculateLottoCount();
        OutputView.printPurchaseCount(count);
        LottoBundle bundle = lottoService.purchase(count); // 앞서 논의한 Service 활용
        OutputView.printLottoBundle(bundle);
        return bundle;
    }

    private void processResult(LottoBundle lottos) {
        // 당첨 번호 입력 -> 판정 -> 수익률 계산 -> 결과 출력 흐름을 구현하세요.
        String numbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readingBonusNumber();
        WinningLotto winningLotto = makeWinningLotto(numbers, bonusNumber);
//        LottoJudge.judge()
//        judge판단 후에 모든 것을 종합해서
    }

    private WinningLotto makeWinningLotto(String winningNumbers, int bonusNumber) {
        return new WinningLotto(Arrays.stream(winningNumbers.split(", "))
                .map((String number) -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));

    }
}