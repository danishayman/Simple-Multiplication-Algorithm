import java.util.Random;


public class SimpleMultiplication {

    private static int counter = 0; // Counter variable to count the total primitive operations executed

    public static void main(String[] args) {

        int numberOfDigits = 10; // Change this to specify the number of digits for the two numbers
        counter++; // Increment the counter for the initialization of the numberOfDigits variable

        Random random = new Random();
        counter++; // Increment the counter for the initialization of the random variable

        long first_number = generateRandomNumber(numberOfDigits, random);
        long second_number = generateRandomNumber(numberOfDigits, random);
        counter += 4; // Increment the counter for the initialization of the first_number and
                      // second_number variables and fucntion call

        simpleMultiplication(first_number, second_number);
        counter++; // Increment the counter for the function call

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

    private static void simpleMultiplication(long first_number, long second_number) {

        // Initialize the result to 0
        long result = 0;
        counter++; // Increment the counter for the initialization of the result variable


        // get length of number assuming both number has the same length
        int length = String.valueOf(first_number).length();
        counter++; // Increment the counter for the initialization of the length variable


        // store each digit in an array
        long[] first_number_array = new long[length];
        counter++; // Increment the counter for the initialization of the first_number_array
                   // variable
        long[] second_number_array = new long[length];
        counter++; // Increment the counter for the initialization of the second_number_array
                   // variable
        long[] carry = new long[length];
        counter++; // Increment the counter for the initialization of the carry variable

        long temp_first = first_number;
        counter++; // Increment the counter for the initialization of the temp_first variable

        long temp_second = second_number;
        counter++; // Increment the counter for the initialization of the temp_second variable

        // store each digit of the first number in an array

        for (int i = 0; i < length; i++) {
            counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                          // loop increment

            second_number_array[i] = temp_second % 10;
            counter += 2; // Increment the counter for the assignment operation & the modulo operation

            temp_second = temp_second / 10;
            counter += 2; // Increment the counter for the division operation & the assignment operation

            first_number_array[i] = temp_first % 10;
            counter += 2; // Increment the counter for the assignment operation & the modulo operation

            temp_first = temp_first / 10;
            counter += 2; // Increment the counter for the division operation & the assignment operation
        }

        // multiply each digit of the first number with the second number using simple
        // multiplication method
        long[] partial_result = new long[length];
        counter++; // Increment the counter for the initialization of the partial_result variable

        for (int i = 0; i < length; i++) {
            counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                          // loop increment

            carry[i] = 0;
            counter++; // Increment the counter for the assignment operation

            for (int j = 0; j < length; j++) {
                counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                              // loop increment

                long product = first_number_array[j] * second_number_array[i];
                counter += 2; // Increment the counter for the multiplication operation & the assignment
                              // operation

                long last_digit = product % 10;
                counter += 2; // Increment the counter for the assignment operation & the modulo operation

                partial_result[i] = partial_result[i] + last_digit * (long) Math.pow(10, j);
                counter += 4; // Increment the counter for the multiplication operation, the assignment
                              // operation, the power operation & the addition operation

                // if the product is more than 9, add the tens to the carry

                counter++; // Increment the counter for the comparison operation
                if (product > 9) {
                    carry[i] += product / 10 * (long) Math.pow(10, j + i + 1);
                    counter += 7; // Increment the counter for the division operation, the multiplication
                                  // operation, the power operation, the addition operation & the assignment
                                  // operation

                }
            }
            // multiply the result by 10^i for each iteration
            partial_result[i] *= (long) Math.pow(10, i);
            counter += 3; // Increment the counter for the multiplication operation, the power operation &
                          // the
                          // assignment operation
        }

        // print the result
        for (int i = 0; i < length; i++) {
            counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                          // loop increment
            // add the result of the multiplication to the previous result
            result += partial_result[i] + carry[i];
            counter += 3; // Increment the counter for the addition operation, the assignment operation &
                          // the
                          // addition operation
        }

        String line = "-----";
        counter++; // Increment the counter for the initialization of the line variable

        // length + 7 to account for the space and the 'x' sign
        for (int i = 0; i < length + 7; i++) {
            counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                          // loop increment

            line += "-";
            counter += 2; // Increment the counter for the concatenation operation & the assignment
                          // operation
        }

        String space = "";
        counter++; // Increment the counter for the initialization of the space variable

        for (int i = 0; i < length; i++) {
            counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                          // loop increment
            space += " ";
            counter += 2; // Increment the counter for the concatenation operation & the assignment
                          // operation
        }

        // Print the result
        System.out.println(" " + space + "   " + first_number);
        counter++; // Increment the counter for the print statement

        System.out.println("x" + space + "   " + second_number);
        counter++; // Increment the counter for the print statement

        System.out.println(line);
        counter++; // Increment the counter for the print statement

        for (int i = 0; i < length; i++) {
            counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                          // loop increment

            String indentation = " ";
            counter++; // Increment the counter for the initialization of the indentation variable

            for (int j = length - i; j + 3 > 0; j--) {
                counter += 3; // Increment the counter for the loop initialization, the loop condition & the
                              // loop increment

                indentation += " ";
                counter += 2; // Increment the counter for the concatenation operation & the assignment
                              // operation
            }

            String partialStr = String.format(indentation + "%0" + length + "d",
                    partial_result[i] / (long) Math.pow(10, i));
            counter += 3; // Increment the counter for the initialization of the partialStr variable

            String carryStr = String.format(indentation.substring(1) + "%0" + length + "d",
                    carry[i] / (long) Math.pow(10, i));
            counter += 3; // Increment the counter for the initialization of the carryStr variable

            counter += 2; // Increment the counter for the comparison operation & subtraction operation
            if (i == length - 1) {
                carryStr = "+" + carryStr.substring(1);
                counter += 2; // Increment the counter for the concatenation operation & the assignment
                              // operation
            }

            System.out.printf("%-20s", partialStr);
            counter++; // Increment the counter for the print statement

            System.out.println("partial products for (=" + first_number + " x " + second_number_array[i] + ")");
            counter += 2; // Increment the counter for the print statement & the concatenation operation

            System.out.printf("%-20s", carryStr);
            counter++; // Increment the counter for the print statement

            System.out.println("carry for (=" + first_number + " x " + second_number_array[i] + ")");
            counter += 2; // Increment the counter for the print statement & the concatenation operation

            counter += 2; // Increment the counter for the comparison operation & subtraction operation
            if (i == length - 1) {
                System.out.println(line);
                counter++; // Increment the counter for the print statement

                System.out.println(" " + space + result);
                counter++; // Increment the counter for the print statement

                System.out.println(line);
                counter++; // Increment the counter for the print statement
            }
        }

        System.out.println("Total primitive operations executed: " + counter);
        counter++; // Increment the counter for the print statement

    }
}