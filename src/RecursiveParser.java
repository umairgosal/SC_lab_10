import java.util.Stack;

public class RecursiveParser {

    // Main method to evaluate an expression
    public static double evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty.");
        }

        return parse(expression.replaceAll("\\s", ""), 0, expression.length() - 1);
    }

    // Recursive function to parse and evaluate the expression
    private static double parse(String expression, int start, int end) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = start;
        while (i <= end) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                // Parse a number (supporting floating-point)
                StringBuilder number = new StringBuilder();
                while (i <= end && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(number.toString()));
                i--; // Adjust back after parsing the number
            } else if (ch == '(') {
                // Handle parentheses by recursive call
                int closeIndex = findClosingParenthesis(expression, i);
                values.push(parse(expression, i + 1, closeIndex - 1));
                i = closeIndex; // Skip to the closing parenthesis
            } else if (isOperator(ch)) {
                // Process operator with precedence
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
                }
                operators.push(ch);
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + ch);
            }
            i++; // Move to the next character
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
        }

        if (values.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format.");
        }

        return values.pop();
    }

    // Helper to find matching closing parenthesis
    private static int findClosingParenthesis(String expression, int openIndex) {
        int balance = 1;
        for (int i = openIndex + 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') balance++;
            if (expression.charAt(i) == ')') balance--;
            if (balance == 0) return i;
        }
        throw new IllegalArgumentException("Mismatched parentheses in expression.");
    }

    // Check if a character is a valid operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Determine operator precedence
    private static int precedence(char operator) {
        return (operator == '+' || operator == '-') ? 1 : 2;
    }

    // Apply an operator to two values
    private static double applyOperator(double b, double a, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero.");
                return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Result: " + evaluateExpression("3 + 5 * 2")); // Expected: 13.0
            System.out.println("Result: " + evaluateExpression("(3 + 5) * 2")); // Expected: 16.0
            System.out.println("Result: " + evaluateExpression("10 / 2 + 3")); // Expected: 8.0
            System.out.println("Result: " + evaluateExpression("2 + 3 * (7 - 2)")); // Expected: 17.0
            System.out.println("Result: " + evaluateExpression("3.5 + 1.5 * 2")); // Expected: 6.5
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
