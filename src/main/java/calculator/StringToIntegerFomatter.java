package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToIntegerFomatter {

    public StringToIntegerFomatter() {
    }

    public List<String> validator(List<String> input) {
        List<Integer> numbers = parseAll(input);
        validateNoNegative(numbers);
        return input;
    }

    private List<Integer> parseAll(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
        }
    }

    private void validateNoNegative(List<Integer> numbers) {
        if (!hasNegative(numbers)) {
            return;
        }
        throw new IllegalArgumentException("음수가 있습니다.");
    }

    private boolean hasNegative(List<Integer> numbers) {
        return numbers.stream().anyMatch(n -> n < 0);
    }

    public List<String> formatCommaAndColon(String input) {
        return List.of(input.split(",|:"));
    }

    public List<String> formatCustom(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        List<String> tokens = new ArrayList<>();
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = List.of(m.group(2).split(customDelimiter));
        }

        return tokens;
    }

    public List<String> format(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String delimiter = ",|:";

        if (m.find()) {
            delimiter += "|" + m.group(1);
            return List.of(m.group(2).split(delimiter));
        }

        return List.of(input.split(delimiter));
    }
}
