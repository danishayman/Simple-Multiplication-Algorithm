public class Main {
    public static void main(String[] args) {
        long first_number = 500000; // Note the 'L' suffix to indicate a long literal
        long second_number = 500000; // Note the 'L' suffix to indicate a long literal
        long result = 0;

         

        // get length of number assuming both number has the same length
        int length = Math.max(String.valueOf(first_number).length(), String.valueOf(second_number).length());

        // store each digit in an array
        long[] first_number_array = new long[length];
        long[] second_number_array = new long[length];
        long[] carry = new long[length];

        long temp_first = first_number;
        long temp_second = second_number;
        for (int i = 0; i < length; i++) {
            second_number_array[i] = temp_second % 10;
            temp_second = temp_second / 10;
            first_number_array[i] = temp_first % 10;
            temp_first = temp_first / 10;
        }

        // multiply each digit of the first number with the second number using simple
        // multiplication method
        long[] partial_result = new long[length];
        for (int i = 0; i < length; i++) {
            carry[i] = 0;

            for (int j = 0; j < length; j++) {
                long product = first_number_array[j] * second_number_array[i];

                long last_digit = product % 10;
                partial_result[i] = partial_result[i] + last_digit * (long) Math.pow(10, j);

                // if the product is more than 9, add the tens to the carry
                if (product > 9)
                    carry[i] += product / 10 * (long) Math.pow(10, j + i + 1);
            }
            // multiply the result by 10^i for each iteration
            partial_result[i] *= (long) Math.pow(10, i);
        }

        // prlong the result
        for (int i = 0; i < length; i++) {
            // add the result of the multiplication to the previous result
            result += partial_result[i] + carry[i];
        }

        String line = "-----";
        // length + 7 to account for the space and the 'x' sign
        for (long i = 0; i < length + 7; i++) {
            line += "-";
        }

        String space = "";
        for (long i = 0; i < length; i++) {
            space += " ";
        }

        // String headerSpace = "";
        // for (long i = 0; i < length+3; i++) {
        //     headerSpace += " ";
        // }





        // prlong it
        System.out.println(" " + space + "   " + first_number);
        System.out.println("x" + space + "   " + second_number);



        System.out.println(line);
        for (int i = 0; i < length; i++) {
            String indentation = " ";
            for (int j = length - i; j+3 > 0 ; j--) {
                indentation += " ";
            }

            String partialStr = String.format(indentation + "%0" + length + "d",
                    partial_result[i] / (long) Math.pow(10, i));

            String carryStr = String.format(indentation.substring(1) + "%0" + length + "d",
                 carry[i] / (long) Math.pow(10, i));


            if (i == length - 1) {
                carryStr = "+" + carryStr.substring(1);
            }
            
            
            // System.out.prlongf(calculationSpace);
            System.out.printf("%-20s", partialStr);
            System.out.println("partial products for (=" + first_number + " x " + second_number_array[i] + ")");
            // System.out.prlongf(calculationSpace);
            System.out.printf("%-20s", carryStr);
            System.out.println("carry for (=" + first_number + " x " + second_number_array[i] + ")");
            

        }
        System.out.println(line);
        System.out.println(space +" "+ result);
    }
}