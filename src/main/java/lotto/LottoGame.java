package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final LottoService lottoService;

    public LottoGame() {
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            Money money = new Money(InputView.readPurchaseAmount());
            LottoBundle lottos = buyLottos(money);
            WinningLotto winningLotto = makeWinningLotto();
            processResult(lottos, winningLotto, money);
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

    private void processResult(LottoBundle lottos, WinningLotto winningLotto, Money money) {
        LottoResult lottoResult = new LottoResult(lottos.getLottos().stream()
                .map(winningLotto::judge)
                .collect(Collectors.toList()));

        OutputView.printStatisticsHeader();
        OutputView.printResult(lottoResult);
        OutputView.printYield(lottoResult.calculateYield(money));

    }

    private WinningLotto makeWinningLotto() {
        List<LottoNumber> winningNumbers = new ArrayList<>(LottoParser.parseWinningNumbers(
            InputView.readWinningNumbers()));
        Lotto lotto = new Lotto(winningNumbers);
        LottoNumber bonusNumber = new LottoNumber(LottoParser.parseBonusNumber(
            InputView.readingBonusNumber()));

        return new WinningLotto(lotto, bonusNumber);
    }
}
