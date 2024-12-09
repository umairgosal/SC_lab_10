import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumOfDigitsTest {

    @Test
    public void testPositiveNumbers() {
        assertEquals(6, SumOfDigits.sumOfDigits(123));
        assertEquals(15, SumOfDigits.sumOfDigits(456));
    }

    @Test
    public void testZero() {
        assertEquals(0, SumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(6, SumOfDigits.sumOfDigits(-123));
        assertEquals(15, SumOfDigits.sumOfDigits(-456));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(45, SumOfDigits.sumOfDigits(987654321));
    }
}
