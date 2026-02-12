package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

	public LottoBundle purchaseAuto(int count) {
		List<Lotto> purchasedLottos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			purchasedLottos.add(LottoGenerator.generateLotto());
		}
		return new LottoBundle(purchasedLottos);
	}
}
