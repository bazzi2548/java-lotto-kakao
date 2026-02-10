package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber).reversed());
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private static void validateSize(List<LottoNumber> lottoNumbers){
        if (lottoNumbers.size() != 6){
            throw new IllegalArgumentException("로또번호가 6개가 아닙니다.");
        }
    }
}
