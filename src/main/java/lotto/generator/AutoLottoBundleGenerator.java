package lotto.generator;

import java.util.stream.IntStream;

import lotto.domain.LottoBundle;

public class AutoLottoBundleGenerator implements LottoBundleGenerator {

	private final int count;
	private final LottoGenerator lottoGenerator;

	public AutoLottoBundleGenerator(int count, LottoGenerator lottoGenerator) {
		this.count = count;
		this.lottoGenerator = lottoGenerator;
	}

	@Override
	public LottoBundle generate() {
		return LottoBundle.of(IntStream.range(0, count)
			.mapToObj(i -> lottoGenerator.generate())
			.toList());
	}
}
