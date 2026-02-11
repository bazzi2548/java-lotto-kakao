package lotto.view;

import java.util.Arrays;
import java.util.Comparator;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoBundle(LottoBundle bundle) {
        bundle.getLottos()
                .forEach(System.out::println);

    }

    public static void printStatisticsHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public static void printResult(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.MISS)
            .sorted(Comparator
                .comparingInt(Rank::getCountOfMatch)
                .thenComparing(Rank::isMatchBonus))
            .forEach(rank -> resultFormat(lottoResult, rank));
    }

    private static void resultFormat(LottoResult lottoResult, Rank rank){
        System.out.printf("%s (%s원) - %d개%n",
            matchDescription(rank),
            rank.getWinningMoney(),
            lottoResult.getCount(rank));
    }

    private static String matchDescription(Rank rank) {
        if (rank == Rank.SECOND) return "5개 일치, 보너스 볼 일치";
        return rank.getCountOfMatch() + "개 일치";
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f입니다.\n", yield);
    }
}
