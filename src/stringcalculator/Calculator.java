package stringcalculator;

class Calculator {

    static int add(String string){
        if(string.equals("")){
            return 0;
        }
        else{
            String delimiter = ",";
            if(string.matches("//(.*)\n(.*)")){
                delimiter = Character.toString(string.charAt(2));
                string = string.substring(4);
            }

            String[] numList = splitNumbers(string, delimiter + "|\n");
            return sum(numList);
        }
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static String[] splitNumbers(String numbers, String divider){
        return numbers.split(divider);
    }

    private static int sum(String[] numbers){
        int total = 0;
        StringBuilder negString = new StringBuilder();

        for(String number : numbers){
            if(toInt(number) < 0){
                if(negString.toString().equals(""))
                    negString = new StringBuilder(number);
                else
                    negString.append(",").append(number);
            }
            if(toInt(number) > 0) {
                total += toInt(number);
            }
        }

        if(!negString.toString().equals("")){
            throw new IllegalArgumentException("Negatives not allowed: " + negString);
        }

        return total;
    }
}
