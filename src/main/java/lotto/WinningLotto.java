package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        validateBonusNumber(lottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(Lotto lotto){
        return lotto.contains(bonusNumber);
    }

    private void validateBonusNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 잘못 되었습니다.");
        }
    }
}
