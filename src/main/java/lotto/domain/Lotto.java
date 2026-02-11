package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber).reversed());
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(int... values) {
        this(Arrays.stream(values)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList())
        );
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

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber) // LottoNumber 객체에서 숫자(int)만 추출
                .sorted()                    // 오름차순 정렬 (요구사항)
                .toList()
                .toString();                 // [1, 2, 3, 4, 5, 6] 형태로 반환
    }
}
