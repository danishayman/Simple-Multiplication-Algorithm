/// Java Program to Implement Karatsuba Algorithm

// Importing Random class from java.util package
import java.util.Random;

// Main class
class KaratsubaReal {

    // Initialisation of a counter variable to count primitive operations
    public static int counter = 0;

    // Main driver method
    public static long mult(long x, long y) {

        // Checking only if input is within range
        if (x < 10 && y < 10) {

            // Increment counter for multiplication operation
            counter++;

            // Multiplying the inputs entered
            return x * y;
        }

        // Declaring variables in order to
        // Find length of both integer
        // numbers x and y
        int noOneLength = numLength(x);
        int noTwoLength = numLength(y);

        // Increment counter for the assignment and function calling operations
        counter += 4;

        // Finding maximum length from both numbers
        // using math library max function
        int maxNumLength
                = Math.max(noOneLength, noTwoLength);

        // Increment counter for the assignment and function call operations
        counter += 2;

        // Rounding up the divided Max length
        Integer halfMaxNumLength
                = (maxNumLength / 2) + (maxNumLength % 2);

        // Increment counter for assignment, division, addition and modulo operations
        counter += 4;

        // Multiplier
        long maxNumLengthTen
                = (long)Math.pow(10, halfMaxNumLength);

        // Increment counter for assignment and function call operations
        counter += 2;

        // Compute the expressions
        long a = x / maxNumLengthTen;
        long b = x % maxNumLengthTen;
        long c = y / maxNumLengthTen;
        long d = y % maxNumLengthTen;

        // Increment counter for assignment, division and modulo operations
        counter += 8;

        // Compute all multiplying variables
        // needed to get the multiplication
        long z0 = mult(a, c);
        long z1 = mult(a + b, c + d);
        long z2 = mult(b, d);

        // Increment counter for the assignment, addition and function call operations
        counter += 8;

        long ans = (z0 * (long)Math.pow(10, halfMaxNumLength * 2) +
                ((z1 - z0 - z2) * (long)Math.pow(10, halfMaxNumLength) + z2));

        // Increment counter for the assignment, addition, subtraction and multiplication operations
        counter += 10;

        counter++; // Increment counter for the return statement
        return ans;

    }

    // Method 1
    // To calculate length of the number
    public static int numLength(long n)
    {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
        }

        // Increment counter for the assignment, comparison, increment and division operations
        counter += 5;

        counter++; // Increment counter for the return statement
        // Returning length of number n
        return noLen;
    }

    // Method 2
    // Main driver function
    public static void main(String[] args)
    {
        // Showcasing karatsuba multiplication

        // Case 1: Big integer lengths
        long expectedProduct = 1234 * 5678;
        long actualProduct = mult(1234, 5678);

        // Increment counter for the assignment, multiplication and function call operations
        counter += 4;

        // Printing the expected and corresponding actual product
        System.out.println("Expected 1 : " + expectedProduct);
        System.out.println("Actual 1 : " + actualProduct + "\n\n");

        counter += 2; // Increment counter for the print statements

        assert(expectedProduct == actualProduct);
        counter++; // Increment counter for the comparison operation

        expectedProduct = 102 * 313;
        actualProduct = mult(102, 313);

        // Increment counter for the assignment, multiplication and function call operations
        counter += 4;

        System.out.println("Expected 2 : " + expectedProduct);
        System.out.println("Actual 2 : " + actualProduct + "\n\n");

        counter += 2; // Increment counter for the print statements

        assert(expectedProduct == actualProduct);
        counter++; // Increment counter for the comparison operation

        expectedProduct = 1345 * 63456;
        actualProduct = mult(1345, 63456);
        // Increment counter for the assignment, multiplication and function call operations
        counter += 4;

        System.out.println("Expected 3 : " + expectedProduct);
        System.out.println("Actual 3 : " + actualProduct + "\n\n");
        counter += 2; // Increment counter for the print statements

        assert(expectedProduct == actualProduct);
        counter++; // Increment counter for the comparison operation

        Integer x = null;
        Integer y = null;
        Integer MAX_VALUE = 10000;
        counter += 3; // Increment counter for the assignment operations

        // Boe creating an object of random class
        // inside main() method
        Random r = new Random();
        counter++; // Increment counter for the initialisation of random variable

        for (int i = 0; i < MAX_VALUE; i++) {
            counter += 3; // Increment counter for the loop initialisation, condition and increment

            x = (int) r.nextInt(MAX_VALUE);
            y = (int) r.nextInt(MAX_VALUE);
            counter += 4; // Increment counter for assignment and method call operations

            expectedProduct = x * y;
            counter += 2; // Increment counter for assignment and multiplication operations

            counter++; // Increment counter for the comparison operation
            if (i == 9999) {

                // Prove assertions catch the bad stuff.
                expectedProduct = 1;
                counter++; // Increment counter for assignment operation
            }
            actualProduct = mult(x, y);
            counter += 2; // Increment counter for assignment and function call

            // Again printing the expected and
            // corresponding actual product
            System.out.println("Expected: " + expectedProduct);
            System.out.println("Actual: " + actualProduct + "\n\n");
            counter += 2; // Increment counter for print statements

            assert(expectedProduct == actualProduct);
            counter++; // Increment counter for comparison operation
        }
        System.out.println("Total number of primitive operations = " + counter);
    }
}