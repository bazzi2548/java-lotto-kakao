package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    MISS(0, 0, "꽝");

    private final int countOfMatch;
    private final int winningMoney;
    private final String message;

    Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    // 일치 개수와 보너스 볼 여부를 받아 Rank를 반환합니다.
    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }
}