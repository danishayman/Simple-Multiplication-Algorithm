public class test {

    public static String multiply(String num1, String num2) {
      // Reverse the strings to iterate through digits from right to left
      num1 = new StringBuilder(num1).reverse().toString();
      num2 = new StringBuilder(num2).reverse().toString();
  
      int n = num1.length();
      int[] result = new int[2 * n];
  
      // Initialize the result array with zeros
      for (int i = 0; i < 2 * n; i++) {
        result[i] = 0;
      }
  
      // Perform multiplication digit by digit
      for (int i = 0; i < n; i++) {
        int digit1 = num1.charAt(i) - '0';
        for (int j = 0; j < n; j++) {
          int digit2 = num2.charAt(j) - '0';
          int product = digit1 * digit2;
          int carry = 0;
  
          // Add the product and carry to the appropriate position in the result array
          int sumIndex = i + j;
          result[sumIndex] += product;
  
          // Handle carry
          while (result[sumIndex] >= 10) {
            carry = result[sumIndex] / 10;
            result[sumIndex] %= 10;
            result[sumIndex + 1] += carry;
            sumIndex++;
          }
          System.out.println("Partial Product: " + product);
          System.out.println("Carry: " + carry);
          while (result[sumIndex] >= 10) {
            carry = result[sumIndex] / 10;
            result[sumIndex] %= 10;
            result[sumIndex + 1] += carry;
            sumIndex++;
          }
        }
      }
  
      // Convert the result array to a String
      StringBuilder sb = new StringBuilder();
      boolean leadingZero = true;
      for (int digit : result) {
        if (digit != 0 || !leadingZero) {
          sb.append(digit);
          leadingZero = false;
        }
      }
  
      return sb.toString().isEmpty() ? "0" : sb.toString();
    }
  
    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "5678";
        String product = multiply(num1, num2);
        System.out.println(num1 + " * " + num2 + " = " + new StringBuilder(product).reverse().toString());
    }
  }
  