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
    void should_throw_exception_for_comma_next_to_new_line() {
        try{
            Calculator.add("1,\n2");
        }
        catch(NumberFormatException e){
            assertEquals(e.getMessage(), "New line after comma not allowed: ,\n");
        }
    }


}