# 🧮 Simple Multiplication Algorithm vs Karatsuba Algorithm

## 📋 Table of Contents
- [Overview](#-overview)
- [Prerequisites](#-prerequisites)
- [Performance Analysis](#-performance-analysis)
- [Implementation Details](#-implementation-details)
- [Usage](#-usage)
- [Testing](#-testing)
- [Visual Comparison](#-visual-comparison)

## 🌟 Overview
This project implements and compares two multiplication algorithms:
1. Simple Multiplication Algorithm - A traditional approach with O(n²) complexity
2. Karatsuba Algorithm - A faster divide-and-conquer approach

## 🔧 Prerequisites
- Java Development Kit (JDK) 8 or higher
- Basic understanding of algorithm complexity
- Familiarity with Java programming

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

### 📁 Project Structure
```
.
├── SimpleMultiplication.java    # Simple multiplication implementation
├── Karatsuba.java              # Karatsuba algorithm implementation
├── Graph of Karatsuba Algorithm.xlsx    # Performance graphs
└── Graph for Simple Multiplication.xlsx # Performance graphs
```

## 💻 Usage
1. **Compile the Java files**:
   ```bash
   javac SimpleMultiplication.java
   javac Karatsuba.java
   ```

2. **Run the algorithms**:
   ```bash
   java SimpleMultiplication
   java Karatsuba
   ```

3. **Configure parameters**:
   - Modify `numberOfDigits` in both files to change input size
   - Adjust `MAX_VALUE` to change number of test iterations

## 📊 Performance Comparison
| Algorithm | Time Complexity | Best For | Space Complexity |
|-----------|----------------|----------|------------------|
| Simple    | O(n²)          | Small numbers | O(n) |
| Karatsuba | O(n^1.585)     | Large numbers | O(n) |

## 🔍 Testing
- Both algorithms are tested with random numbers
- Results are compared with expected values
- Includes assertion checks for accuracy
- Supports configurable number of digits and test iterations

## 📈 Visual Comparison
The project includes Excel files with performance graphs:
- `Graph of Karatsuba Algorithm.xlsx`
- `Graph for Simple Multiplication.xlsx`

These graphs visualize:
- Operation count vs. input size
- Time complexity comparison
- Performance differences between algorithms

## 🤝 Contributing
Feel free to:
- Report issues
- Suggest improvements
- Submit pull requests

## 📝 License
This project is open source and available for educational purposes.
