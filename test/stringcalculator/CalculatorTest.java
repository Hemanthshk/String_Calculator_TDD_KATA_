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


}