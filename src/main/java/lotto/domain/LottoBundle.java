package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {
	private final List<Lotto> lottos;

	private LottoBundle(List<Lotto> lottos) {
		this.lottos = List.copyOf(lottos);
	}

	public static LottoBundle of(List<Lotto> lottos) {
		return new LottoBundle(lottos);
	}

	public static LottoBundle empty() {
		return new LottoBundle(Collections.emptyList());
	}

	public LottoBundle merge(LottoBundle other) {
		List<Lotto> merged = new ArrayList<>(this.lottos);
		merged.addAll(other.lottos);
		return new LottoBundle(merged);
	}

	public int size() {
		return lottos.size();
	}

	public List<Lotto> asList() {
		return lottos;
	}

	public List<Rank> match(WinningLotto winningLotto) {
		return lottos.stream()
			.map(winningLotto::judge)
			.toList();
	}
}
