package lotto;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoBundle(LottoBundle bundle) {
        // 일급 컬렉션인 bundle에게 출력을 위한 데이터 가공을 요청하세요.
        bundle.getLottos()
                .forEach(System.out::println);
    }

    public static void printResult(Map<Rank, Integer> statistics, double yield) {
        System.out.println("당첨 통계\n---------");
        // Rank Enum을 순회하며 결과를 출력하는 로직을 작성하세요.
        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }
}