package lotto;

public class LottoJudge {
    public static Rank judge(WinningLotto winning, Lotto lotto){
        int count = winning.countMatchingNumbers(lotto);
        boolean matchBonus = winning.matchBonus(lotto);

        return Rank.valueOf(count, matchBonus);
    }
}
