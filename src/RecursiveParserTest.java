import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveParserTest {

    @Test
    public void testSimpleExpressions() {
        assertEquals(13.0, RecursiveParser.evaluateExpression("3 + 5 * 2"), 0.001);
        assertEquals(16.0, RecursiveParser.evaluateExpression("(3 + 5) * 2"), 0.001);
    }

    @Test
    public void testFloatingPoint() {
        assertEquals(6.5, RecursiveParser.evaluateExpression("3.5 + 1.5 * 2"), 0.001);
    }

    @Test
    public void testParentheses() {
        assertEquals(17.0, RecursiveParser.evaluateExpression("2 + 3 * (7 - 2)"), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> RecursiveParser.evaluateExpression("10 / 0"));
    }

    @Test
    public void testInvalidExpression() {
        assertThrows(IllegalArgumentException.class, () -> RecursiveParser.evaluateExpression("(3 + 5"));
    }
}
