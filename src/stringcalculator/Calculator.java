package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String numbers) {
        if(!numbers.isEmpty()){
            List<Integer> num = strArrToIntList(numbers);
            return num.stream().reduce(Integer::sum).orElseThrow(Error::new);
        }
        return 0;
    }

    private static List<Integer> strArrToIntList(String numbers) {
        return Arrays.stream(getSplit(numbers)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] getSplit(String numbers) {
        return numbers.split(",|\n");
    }
}
