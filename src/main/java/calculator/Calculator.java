package calculator;

import java.util.List;

public class Calculator {
    public Calculator() {
    }

    public int add(List<String> numberList){
        return numberList.stream().mapToInt(Integer::parseInt).sum();
    }
}
