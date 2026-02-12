package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundles {

	private final LottoBundle manualLottos;
	private final LottoBundle autoLottos;

	public LottoBundles(LottoBundle manualLottos, LottoBundle autoLottos) {
		this.manualLottos = manualLottos;
		this.autoLottos = autoLottos;
	}

	public LottoResult rankAll(WinningLotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		ranks.addAll(manualLottos.getRank(winningLotto));
		ranks.addAll(autoLottos.getRank(winningLotto));

		return new LottoResult(ranks);
	}
}
