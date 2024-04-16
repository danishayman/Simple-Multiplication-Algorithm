public class Main {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int[] result = new int[2 * n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;
                int p1 = i + j, p2 = i + j + 1;

                int sum = product + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;

                System.out.println("Partial product: " + result[p2] + ", Carrier: " + result[p1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            if (!(sb.length() == 0 && res == 0)) {
                sb.append(res);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
