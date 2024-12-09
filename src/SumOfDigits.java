public class SumOfDigits {

    /**
     * Recursively calculates the sum of the digits of a given integer.
     *
     * @param number the integer whose digits will be summed
     * @return the sum of the digits
     */
    public static int sumOfDigits(int number) {
        // Convert to positive if the number is negative
        number = Math.abs(number);

        // Base case: if the number is 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive step: add the last digit to the sum of the remaining digits
        return number % 10 + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Sum of digits (123): " + sumOfDigits(123)); // 6
        System.out.println("Sum of digits (0): " + sumOfDigits(0)); // 0
        System.out.println("Sum of digits (-456): " + sumOfDigits(-456)); // 15
        System.out.println("Sum of digits (987654321): " + sumOfDigits(987654321)); // 45
    }
}
