package lotto;
import java.util.*;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(List<Rank> ranks) {
        this.result = summarize(ranks);
    }

    private Map<Rank, Integer> summarize(List<Rank> ranks) {
        Map<Rank, Integer> summary = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> summary.put(rank, 0));

        for (Rank rank : ranks) {
            summary.put(rank, summary.get(rank) + 1);
        }
        return summary;
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public double calculateYield(Money purchaseMoney) {
        long totalPrize = Arrays.stream(Rank.values())
                .mapToLong(rank -> (long) rank.getWinningMoney() * result.get(rank))
                .sum();

        return YieldCalculator.calculate(totalPrize, purchaseMoney.getMoney());
    }
}