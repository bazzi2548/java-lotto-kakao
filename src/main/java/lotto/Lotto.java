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

    public int countMatchingNumbers(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other::contains) // 아래 contains 메서드 활용
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private static void validateSize(List<LottoNumber> lottoNumbers){
        if (lottoNumbers.size() != 6){
            throw new IllegalArgumentException("로또번호가 6개가 아닙니다.");
        }
    }
}
