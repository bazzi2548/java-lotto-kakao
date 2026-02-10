package lotto;

import java.util.List;

public class LottoJudge {
    public Rank judge(WinningLotto winning, Lotto lotto){
        int count = winning.countMatchingNumbers(lotto);
        boolean matchBonus = winning.matchBonus(lotto);

        return Rank.valueOf(count, matchBonus);
    }
}
