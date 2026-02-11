package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean matchBonus;

    Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
		this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.isSatisfiedBy(countOfMatch, matchBonus)) {
                return rank;
            }
        }
        return MISS;
    }

    private boolean isSatisfiedBy(int countOfMatch, boolean matchBonus) {
        if (this.countOfMatch != countOfMatch) {
            return false;
        }

        if (this.matchBonus && !matchBonus) {
            return false;
        }

        return true;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
