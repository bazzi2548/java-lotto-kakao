package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import lotto.generator.LottoGenerator;

public class LottoService {

	public LottoBundle purchaseAuto(int count) {
		List<Lotto> purchasedLottos = IntStream.range(0, count)
				.mapToObj(it -> LottoGenerator.generateLotto())
				.toList();
		return new LottoBundle(purchasedLottos);
	}
}
