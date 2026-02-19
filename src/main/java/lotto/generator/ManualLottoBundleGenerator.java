package lotto.generator;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public class ManualLottoBundleGenerator implements LottoBundleGenerator {

	private final List<Lotto> manualLottos;

	public ManualLottoBundleGenerator(List<Lotto> manualLottos) {
		this.manualLottos = manualLottos;
	}

	@Override
	public LottoBundle generate() {
		return LottoBundle.of(manualLottos);
	}
}
