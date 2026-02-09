package calculator;

import java.util.List;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        StringToIntegerFomatter formatter = new StringToIntegerFomatter();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(input);

        input = input.replace("\\n", "\n");
        List<String> inputList = formatter.validator(formatter.format(input));
        
        int result = calculator.add(inputList);
        System.out.println(result);

    }
}
