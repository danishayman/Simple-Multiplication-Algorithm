# 🧮 Simple Multiplication Algorithm vs Karatsuba Algorithm

## 📊 Performance Analysis

### 🔢 Simple Multiplication Algorithm
The simple multiplication algorithm is implemented with the following steps and their time complexities:

1. **Generating Random Numbers** 🎲
   - Time Complexity: O(n)
   - Generates random numbers with n digits
   - Constant time operation for each digit

2. **Storing Digits in Arrays** 📦
   - Time Complexity: O(n)
   - Iterates once over n digits
   - Stores each digit in separate arrays

3. **Performing Multiplication** ✖️
   - Time Complexity: O(n²)
   - Nested loops for digit-by-digit multiplication
   - Most significant part of the algorithm

4. **Handling Carries and Partial Products** ➕
   - Time Complexity: O(n²)
   - Manages carries and accumulates partial products
   - Nested within multiplication loops

5. **Result Output** 📝
   - Time Complexity: O(n)
   - Linear iteration over result digits
   - Formats and displays the final product

**Overall Time Complexity**: O(n²) ⏱️

### 🚀 Karatsuba Algorithm
A faster multiplication algorithm that reduces the number of multiplication operations through recursive decomposition.

#### 🔍 How It Works:
1. **Base Case** ⚡
   - If n = 1, uses simple multiplication
   - Direct multiplication for single-digit numbers

2. **Recursive Decomposition** 🔄
   - Splits numbers into halves (a, b) and (c, d)
   - Performs three recursive multiplications:
     - ac
     - bd
     - (a+b)(c+d)

3. **Final Computation** 🎯
   - Combines results using the formula:
   - ac * 10ⁿ + ((a+b)(c+d) - ac - bd) * 10ⁿ/² + bd

#### 📈 Performance Benefits
- Reduces multiplication operations
- More efficient for large numbers
- Recursive approach with three subproblems

## 🛠️ Implementation Details
- Both algorithms are implemented in Java
- Includes performance counters for operation tracking
- Supports random number generation for testing
- Validates results through assertions

## 📊 Performance Comparison
- Simple Multiplication: O(n²) time complexity
- Karatsuba: More efficient for large numbers
- Both implementations include detailed operation counting

## 🔍 Testing
- Both algorithms are tested with random numbers
- Results are compared with expected values
- Includes assertion checks for accuracy
- Supports configurable number of digits and test iterations
