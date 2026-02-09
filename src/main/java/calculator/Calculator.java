package calculator;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Calculator {
    public Calculator() {
    }

    public int add(List<String> numberList){
        return numberList.stream().mapToInt(Integer::parseInt).sum();
    }
}
