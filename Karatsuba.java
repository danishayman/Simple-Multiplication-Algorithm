import java.util.Random;

class GFG {

    // Counter to count the number of primitive operations
    public static long counter = 0;

    // Main driver method
    public static long mult(long x, long y) {
        // Increment counter for checking input range
        counter++;

        // Checking only if input is within range
        if (x < 10 && y < 10) {
            // Increment counter for multiplication operation
            counter++;
            // Multiplying the inputs entered
            return x * y;
        }

        // Increment counter for variable declaration
        counter += 2;

        // Declaring variables in order to
        // Find length of both integer
        // numbers x and y
        int noOneLength = numLength(x);
        int noTwoLength = numLength(y);

        // Increment counter for Math.max() operation
        counter++;

        // Finding maximum length from both numbers
        // using math library max function
        int maxNumLength = Math.max(noOneLength, noTwoLength);

        // Increment counter for assignment
        counter++;

        // Rounding up the divided Max length
        int halfMaxNumLength = (maxNumLength / 2) + (maxNumLength % 2);

        // Increment counter for assignment and math.pow()
        counter += 2;

        // Multiplier
        long maxNumLengthTen = (long)Math.pow(10, halfMaxNumLength);

        // Increment counter for assignment
        counter++;

        // Compute the expressions
        long a = x / maxNumLengthTen;
        long b = x % maxNumLengthTen;
        long c = y / maxNumLengthTen;
        long d = y % maxNumLengthTen;

        // Increment counter for arithmetic operations
        counter += 4;

        // Compute all multiplying variables
        // needed to get the multiplication
        long z0 = mult(a, c);
        long z1 = mult(a + b, c + d);
        long z2 = mult(b, d);

        // Increment counter for assignment and arithmetic operations
        counter += 7;

        long ans = (z0 * (long)Math.pow(10, halfMaxNumLength * 2) +
                ((z1 - z0 - z2) * (long)Math.pow(10, halfMaxNumLength) + z2));

        // Increment counter for arithmetic operations
        counter += 6;

        // Increment counter for return statement
        counter++;

        return ans;

    }

    // Method 1
    // To calculate length of the number
    public static int numLength(long n) {
        // Increment counter for variable initialization
        counter++;
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
            // Increment counter for arithmetic operations and loop iteration
            counter += 2;
        }
        // Increment counter for return statement
        counter++;
        // Returning length of number n
        return noLen;
    }

    // Main driver function
    public static void main(String[] args) {
        // Showcasing karatsuba multiplication

        // Change the number of digits here
        int n = 1;

        // Case 1: Big integer lengths
        long expectedProduct = 1234 * 5678;
        long actualProduct = mult(1234, 5678);

        // Printing the expected and corresponding actual product
        System.out.println("Expected 1 : " + expectedProduct);
        System.out.println("Actual 1 : " + actualProduct + "\n\n");

        // Increment counter for print statements
        counter += 4;

        assert(expectedProduct == actualProduct);

        expectedProduct = 102 * 313;
        actualProduct = mult(102, 313);

        System.out.println("Expected 2 : " + expectedProduct);
        System.out.println("Actual 2 : " + actualProduct + "\n\n");

        // Increment counter for print statements
        counter += 4;

        assert(expectedProduct == actualProduct);

        expectedProduct = 1345 * 63456;
        actualProduct = mult(1345, 63456);

        System.out.println("Expected 3 : " + expectedProduct);
        System.out.println("Actual 3 : " + actualProduct + "\n\n");

        // Increment counter for print statements
        counter += 4;

        assert(expectedProduct == actualProduct);

        Integer x = null;
        Integer y = null;
        Integer MAX_VALUE = 1;

        // Boe creating an object of random class
        // inside main() method
        Random r = new Random();

        for (int i = 0; i < MAX_VALUE; i++) {
            x = r.nextInt((int)Math.pow(10, n));
            y = r.nextInt((int)Math.pow(10, n));

            expectedProduct = x * y;

            if (i == 9999) {
                // Prove assertions catch the bad stuff.
                expectedProduct = 1;
            }
            actualProduct = mult(x, y);

            // Again printing the expected and
            // corresponding actual product
            System.out.println("Value 1: " + x + "\nValue 2: " + y);
            System.out.println("Expected: " + expectedProduct);
            System.out.println("Actual: " + actualProduct + "\n\n");

            // Increment counter for print statements
            counter += 4;

            assert(expectedProduct == actualProduct);
        }

        // Print total number of primitive operations
        System.out.println("Total number of primitive operations: " + counter);
    }
}
