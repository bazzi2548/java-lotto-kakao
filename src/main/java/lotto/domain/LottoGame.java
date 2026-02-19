package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import lotto.generator.AutoLottoBundleGenerator;
import lotto.generator.CompositeLottoBundleGenerator;
import lotto.generator.LottoBundleGenerator;
import lotto.generator.LottoGenerator;
import lotto.generator.ManualLottoBundleGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

	public void run() {
		try {
			Money money = new Money(InputView.readPurchaseAmount());
			LottoBundle lottos = buyLotto(money);
			WinningLotto winningLotto = makeWinningLotto();

			processResult(lottos, winningLotto, money);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			run(); // 예외 발생 시 재시도 로직
		}
	}

	private LottoBundle buyLotto(Money money) {
		LottoPurchaseAmount amount = new LottoPurchaseAmount(money, InputView.readManualCount());
		var manualGenerator = new ManualLottoBundleGenerator(askManualLottos(amount.getManualCount()));
		var autoGenerator = new AutoLottoBundleGenerator(amount.getAutoCount(), new LottoGenerator());

		OutputView.printPurchaseCount(amount);

		LottoBundleGenerator composite =
			new CompositeLottoBundleGenerator(List.of(manualGenerator, autoGenerator));

		LottoBundle purchased = composite.generate();
		OutputView.printLottoBundle(purchased); // 전체 출력(수동+자동)로 바뀜
		return purchased;
	}

	private List<Lotto> askManualLottos(int count) {
		OutputView.purchaseManual();

		return IntStream.range(0, count)
			.mapToObj(i -> repeatUntilSuccess(this::createManualLotto))
			.toList();
	}

	private Lotto createManualLotto() {
		String input = InputView.readManualNumbers();
		List<LottoNumber> lottoNumbers = LottoParser.parseLottoNumbers(input);
		return new Lotto(lottoNumbers);
	}

	private void processResult(LottoBundle lottos, WinningLotto winningLotto, Money money) {
		LottoResult lottoResult = new LottoResult(lottos.match(winningLotto));
		OutputView.printStatisticsHeader();
		OutputView.printResult(lottoResult);
		OutputView.printYield(lottoResult.calculateYield(money));
	}

	private WinningLotto makeWinningLotto() {
		List<LottoNumber> winningNumbers = LottoParser.parseLottoNumbers(
			InputView.readWinningNumbers());
		Lotto lotto = new Lotto(winningNumbers);
		LottoNumber bonusNumber = LottoNumber.valueOf(LottoParser.parseBonusNumber(
			InputView.readingBonusNumber()));

		return new WinningLotto(lotto, bonusNumber);
	}

	private <T> T repeatUntilSuccess(Supplier<T> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return repeatUntilSuccess(supplier);
		}
	}

}
