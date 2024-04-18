import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Generate random numbers with the same number of digits
        int numDigits = 3; // Change this to adjust the number of digits
        // int first_number = generateRandomNumber(numDigits);
        // int second_number = generateRandomNumber(numDigits);

        int first_number = 754;
        int second_number = 797;

        int result = 0;

        // get length of number assuming both number has the same length
        int length = Math.max(String.valueOf(first_number).length(), String.valueOf(second_number).length());

        // store each digit in an array
        int[] first_number_array = new int[length];
        int[] second_number_array = new int[length];
        int[] carry = new int[length];

        int temp_first = first_number;
        int temp_second = second_number;
        for (int i = 0; i < length; i++) {
            second_number_array[i] = temp_second % 10;
            temp_second = temp_second / 10;
            first_number_array[i] = temp_first % 10;
            temp_first = temp_first / 10;
        }

        // multiply each digit of the first number with the second number using simple
        // multiplication method
        int[] partial_result = new int[length];
        for (int i = 0; i < length; i++) {
            carry[i] = 0;

            for (int j = 0; j < length; j++) {
                int product = first_number_array[j] * second_number_array[i];

                int last_digit = product % 10;
                partial_result[i] = partial_result[i] + last_digit * (int) Math.pow(10, j);

                // if the product is more than 9, add the tens to the carry
                if (product > 9)
                    carry[i] += product / 10 * (int) Math.pow(10, j + i + 1);
            }
            // multiply the result by 10^i for each iteration
            partial_result[i] *= (int) Math.pow(10, i);
        }

        // print the result
        for (int i = 0; i < length; i++) {
            // add the result of the multiplication to the previous result
            result += partial_result[i] + carry[i];
        }

        // print it
        System.out.println("    " + first_number);
        System.out.println("x   " + second_number);

        String line = "";
        // length + 7 to account for the space and the 'x' sign
        for (int i = 0; i < length + 7; i++) {
            line += "-";
        }

        System.out.println(line);
        for (int i = 0; i < length; i++) {
            String indentation = " ";
            for (int j = length - i; j > 0; j--) {
                indentation += " ";
            }

            String partialStr = String.format(indentation + "%0" + length + "d",
                    partial_result[i] / (int) Math.pow(10, i));
            String carryStr = String.format(indentation + "%" + length + "d", carry[i] / (int) Math.pow(10, i));

            if (i == length - 1) {
                carryStr = "+" + carryStr.substring(1);
            }

            System.out.printf("%-15s", partialStr);
            System.out.println("partial products for (=" + first_number + " x " + second_number_array[i] + ")");
            System.out.printf("%-15s", carryStr);
            System.out.println("carry for (=" + first_number + " x " + second_number_array[i] + ")");


        }
        System.out.println(line);
        System.out.println(" " + result);
        System.out.println(line);
    }


    // Method to generate a random number with a specified number of digits
    public static int generateRandomNumber(int numDigits) {
        Random rand = new Random();
        int min = (int) Math.pow(10, numDigits - 1);
        int max = (int) Math.pow(10, numDigits) - 1;
        return rand.nextInt(max - min + 1) + min;
    }
}