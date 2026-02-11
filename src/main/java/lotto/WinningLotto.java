package lotto;

public class WinningLotto {

	private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(Lotto lotto){
        return lotto.contains(bonusNumber);
    }

	public Rank judge(Lotto lotto) {
		int matchCount = winningNumbers.countMatchingNumbers(lotto);
		boolean matchBonus = lotto.contains(bonusNumber);
		return Rank.valueOf(matchCount, matchBonus);
	}

    private void validateBonusNumber(Lotto lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 잘못 되었습니다.");
        }
    }
}
