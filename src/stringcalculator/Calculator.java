package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Calculator {

    static Integer add(String string) {
        if(!string.isEmpty()){
            List<Integer> numbers = strArrToIntList(getSplit(string));
            negatives(numbers);
            return numbers.stream().reduce(Integer::sum).orElseThrow(RuntimeException::new);
        }
        return 0;
    }

    private static int toInt(String number){
    		return Integer.parseInt(number);
    }

    private static void negatives(List<Integer> numbers) throws IllegalArgumentException {
        StringBuilder negativeString = new StringBuilder();
        for (Integer num : numbers) {
            if (num < 0) {
                negativeString.append(num).append(" ");
            }
        }
        if(!negativeString.toString().isEmpty()){
            throw new IllegalArgumentException("Negatives not allowed" + ":"+ negativeString.toString());
        }
    }


    private static List<Integer> strArrToIntList(String[] numArr) {
        return Arrays.stream(numArr).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] getSplit(String string) {
        if (string.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
            if(matcher.matches()){
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new RuntimeException("Wrong custom delimiter format");
        }
        return string.split("[,\n]" );
    }
}
