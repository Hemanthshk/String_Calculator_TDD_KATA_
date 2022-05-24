package stringcalculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    void should_return_zero_for_empty_string() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    void should_return_number_for_one_number() {
        assertEquals(4, Calculator.add("4"));
    }

    @Test
    void should_return_sum_of_two_numbers() {
        assertEquals(4, Calculator.add("1,3"));
    }

    @Test
    void should_return_sum_of_unknown_amount_of_numbers() {
        assertEquals(8, Calculator.add("1,3,4"));
    }

    @Test
    void should_return_sum_of_numbers_split_by_commas_and_new_lines() {
        assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    void should_return_sum_of_numbers_split_by_custom_delimiter() {
        assertEquals(7, Calculator.add("//;\n1;2;4"));
    }

    @Test
    void Should_return_sum__testNewLine(){
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    void test_Negative_Number(){
        try {
            Calculator.add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed:-1");
        }

        try {
            Calculator.add("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed:-4,-5");
        }
    }
}