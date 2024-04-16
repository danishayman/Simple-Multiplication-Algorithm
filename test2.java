public class test2 {
    public static void main(String[] args) {
        int num1 = 123;  // First number
        int num2 = 456;  // Second number

        // Convert integers to strings
        String strNum1 = Integer.toString(num1);
        String strNum2 = Integer.toString(num2);

        // Get lengths of the two strings
        int len1 = strNum1.length();
        int len2 = strNum2.length();

        int[] result = new int[len1 + len2];  // To store the final result
        StringBuilder partialProduct = new StringBuilder();  // To store the partial product
        // Loop through each digit of the second number
        for (int i = len2 - 1; i >= 0; i--) {
            int n2 = strNum2.charAt(i) - '0';  // Current digit of second number

            // Multiply each digit of the first number with the current digit of the second number
            for (int j = len1 - 1; j >= 0; j--) {
                int n1 = strNum1.charAt(j) - '0';  // Current digit of first number

                // Multiply the two digits and add carry from previous multiplication
                int sum = n1 * n2 + result[i + j + 1];

                // Update the result array
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;

                // Print the carry for this multiplication step
                System.out.println("Carry for (" + n1 + " x " + n2 + "): " + result[i + j]);

                
                partialProduct.append(sum % 10);
                
            }
            // Print the partial product for the current multiplication
            System.out.println("Partial product for (" + strNum1 + " x " + n2 + "): " + partialProduct.toString());
            partialProduct.setLength(0);
        }

        // Convert the result array to string
        StringBuilder finalResult = new StringBuilder();
        for (int i : result) {
            finalResult.append(i);
        }

        // Print the final result
        System.out.println("Final result: " + finalResult.toString());
    }
}
