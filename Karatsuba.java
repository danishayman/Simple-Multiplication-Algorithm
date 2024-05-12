/// Java Program to Implement Karatsuba Algorithm

// Importing Random class from java.util package
import java.util.Random;

// Main class
class Karatsuba {

    // Counter to count the number of primitive operations
    public static int counter = 0;

    // Main driver method
    public static long mult(long x, long y) {

        // Checking only if input is within range
        // Increment counter for the comparison operations
        counter += 3;
        if (x < 10 && y < 10) {

            // Multiplying the inputs entered
            // Increment counter for the multiplication operation & return statement
            counter += 2;
            return x * y;
        }

        // Declaring variables in order to
        // Find length of both integer
        // numbers x and y
        int noOneLength = numLength(x);
        // Increment counter for the assignment and function calling operations
        counter += 2;
        int noTwoLength = numLength(y);
        // Increment counter for the assignment and function calling operations
        counter += 2;

        // Finding maximum length from both numbers
        // using math library max function
        int maxNumLength = Math.max(noOneLength, noTwoLength);
        // Increment counter for the assignment and function call operations
        counter += 2;

        // Rounding up the divided Max length
        Integer halfMaxNumLength = (maxNumLength / 2) + (maxNumLength % 2);
        // Increment counter for the assignment, division, addition and modulo
        // operations
        counter += 4;

        // Multiplier
        long maxNumLengthTen = (long) Math.pow(10, halfMaxNumLength);
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
        // Increment counter for assignment and function call operations
        counter += 8;

        long ans = (z0 * (long) Math.pow(10, halfMaxNumLength * 2) +
                ((z1 - z0 - z2) * (long) Math.pow(10, halfMaxNumLength) + z2));
        // Increment counter for the assignment, addition, subtraction and
        // multiplication operations
        counter += 10;

        counter++; // Increment counter for the return statement
        return ans;

    }

    // Method 1
    // To calculate length of the number
    public static int numLength(long n) {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
        }

        // Increment counter for the assignment, comparison, increment and division
        // operations
        counter += 5;

        counter++; // Increment counter for the return statement
        // Returning length of number n
        return noLen;
    }

    // Method 2
    // Main driver function
    public static void main(String[] args) {

        // Initialisation of variables
        long expectedProduct;
        // Increment counter for the initialisation of expectedProduct variable
        counter++;

        long actualProduct;
        // Increment counter for the initialisation of actualProduct variable
        counter++;

        int numberOfDigits = 3;
        // Increment counter for the initialisation of numberOfDigits variable
        counter++;

        Integer MAX_VALUE = 10000;
        // Increment counter for the initialisation of MAX_VALUE variable
        counter++;

        // Boe creating an object of random class
        // inside main() method
        Random r = new Random();
        counter++; // Increment counter for the initialisation of random variable

        for (int i = 0; i < MAX_VALUE; i++) {
            counter += 3; // Increment counter for the loop initialisation, condition and increment

            long x = generateRandomNumber(numberOfDigits, r);
            long y = generateRandomNumber(numberOfDigits, r);
            counter += 4; // Increment counter for the assignment and function call operations

            System.out.println("First Number: " + x + "\nSecond Number: " + y);
            counter += 4; // Increment counter for the print statements

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
            System.out.println("Actual: " + actualProduct);
            counter += 4; // Increment counter for print statements

            System.out.println("Total number of primitive operations = " + counter + "\n");
            counter += 3; // Increment counter for the print statement

            assert expectedProduct == actualProduct : "The expected result is not equal to the actual result";
            counter++; // Increment counter for the assert statement
        }

    }

    // Generate a random number with the specified number of digits
    private static long generateRandomNumber(int numberOfDigits, Random random) {

        long min = (long) Math.pow(10, numberOfDigits - 1);
        counter += 3; // Increment the counter for the initialization of the min variable

        long max = (long) Math.pow(10, numberOfDigits) - 1;
        counter += 3; // Increment the counter for the initialization of the max variable

        long randomNumber = random.nextLong(max - min + 1) + min;
        counter += 4; // Increment the counter for the initialization of the randomNumber variable

        counter++; // Increment the counter for the return statement
        return randomNumber;

    }
}
