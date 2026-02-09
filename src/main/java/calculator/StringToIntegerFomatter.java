package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToIntegerFomatter {

    public StringToIntegerFomatter() {
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
