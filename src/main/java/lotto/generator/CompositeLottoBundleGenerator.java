package lotto.generator;

import java.util.List;

import lotto.domain.LottoBundle;

public class CompositeLottoBundleGenerator implements LottoBundleGenerator {

	private final List<LottoBundleGenerator> generators;

	public CompositeLottoBundleGenerator(List<LottoBundleGenerator> generators) {
		this.generators = generators;
	}

	@Override
	public LottoBundle generate() {
		return generators.stream()
			.map(LottoBundleGenerator::generate)
			.reduce(LottoBundle.empty(), LottoBundle::merge);
	}
}
