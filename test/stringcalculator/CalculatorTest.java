package stringcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {
    @Test
    void should_return_zero_for_empty_string() {
        assertEquals(0, Calculator.add(""));
    }
}