package stringcalculator;

public class Calculator {

    public static int add(String numbers) {
        if(!numbers.isEmpty()){
            return Integer.parseInt(numbers);
        }
        return 0;
    }
}
