# CPT212-Asg1
## Simple Multiplication Algorithm
1. Generating random numbers: Generating random numbers with n digits involves a constant time operation. The time complexity for this step is O(n), where n is the number of digits specified.

2. Storing digits in arrays: Storing each digit of the numbers in arrays requires iterating over the digits once. Since there are n digits in each number, the time complexity for this step is O(n).

3. Performing simple multiplication: This is the most significant part of the algorithm. It involves multiplying each digit of the first number with each digit of the second number. This operation is performed in nested loops. The outer loop iterates over each digit of the second number, and the inner loop iterates over each digit of the first number. Since both loops iterate n times (where n is the number of digits), the time complexity for this step is O(n^2).

4. Accumulating partial products and carries: Within the multiplication step, there is additional complexity for accumulating partial products and carries. This also involves nested loops, but the number of iterations remains within the bounds of the outer multiplication loops. Therefore, the time complexity for this step is also O(n^2).

5. Printing the result: Printing involves iterating over the digits of the result, which is linear with respect to the number of digits in the result. Thus, the time complexity for this step is O(n).

Overall, the most significant factor affecting the time complexity is the multiplication step, which is O(n^2) due to the nested loops iterating over the digits of both numbers. Therefore, the overall time complexity of the algorithm is O(n^2), where n is the number of digits in the larger of the two input numbers.

## Karatsuba Algorithm
The Karatsuba algorithm is a fast multiplication algorithm that reduces the number of multiplication operations required to multiply two numbers by recursively breaking down the multiplication into smaller multiplications. The number of subproblems is reduced to three. In this analysis, The multiplications are performed using two values of n-digit integers.

The working of Karatsuba algorithm is as follow:

Let x and y be the n-digit integers multiplicand and multiplier respectively.

If n = 1, perform a simple multiplication algorithm.
Else, split both x and y into two halves namely a and b for x as well as c and d for y. With this, x = 10n/2 * a + b and y = 10n/2 * c + d
Carry out three recursive multiplications which are:
ac
bd
(a+b)(c+d)
Lastly, the product is computed using the formula:
ac * 10n/2 + ((a+b)(c+d) - ac - bd) * 10n/2 + bd
