package lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    public Set<Integer> generateLotto(){
        Set<Integer> numberSet = new HashSet<>();
        LottoNumber lottoNumber = new LottoNumber();
        while(numberSet.size()<6){
            numberSet.add(lottoNumber.generateNumber());
        }
        return numberSet;
    }
//    public Boolean duplicateNumber(){
//
//    }
}
