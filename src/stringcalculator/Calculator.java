package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String numbers) {
        if(!numbers.isEmpty()){
            List<Integer> num = Arrays.stream(numbers.split(",|\n")).map(Integer::parseInt).collect(Collectors.toList());
            return num.stream().reduce(Integer::sum).orElseThrow(Error::new);
        }
        return 0;
    }
}
