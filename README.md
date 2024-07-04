# Calculator
A simple and intuitive calculator application built using Java, featuring basic arithmetic operations and a user-friendly interface.
Overview: 
This project is a simple and intuitive calculator application built using Java. It performs basic arithmetic operations, including addition, subtraction, multiplication, division, and exponentiation. The application is designed to be user-friendly, allowing users to perform calculations with ease.

Features: 
- Basic Arithmetic Operations: Supports addition, subtraction, multiplication, division, and exponentiation.
- Parenthesis Handling: Correctly handles operations within parentheses to maintain proper order of operations.
- Modular Design: Each operator is implemented as a separate class, making the codebase modular and easy to extend.

Files and Classes: 
1. Main Class
- Calculator.java: This is the main class of the application. It manages the input, processes the arithmetic operations, and provides the final result.

Operators: 
- Operator.java: The base class for all operators. It defines the basic structure and functionality that all operators must implement.
- AddOperator.java: Handles addition operations.
- SubOperator.java: Handles subtraction operations.
- MultiplyOperator.java: Handles multiplication operations.
- DivideOperator.java: Handles division operations.
- ExpoOperator.java: Handles exponentiation operations.

Parentheses Handling:
- OpenParen.java: Represents an open parenthesis in an expression.
- CloseParen.java: Represents a close parenthesis in an expression.

Equals Operator:
- EqualsOperator.java: Handles the evaluation of the expression when the equals sign is encountered.

Usage:
To use this calculator, compile and run the Calculator.java file. You can input arithmetic expressions, and the calculator will evaluate and return the result. The calculator supports the use of parentheses to denote the order of operations.

Example: 
Input: (3 + 5) * 2 ^ 3 / 4 - 1
Output: 7.0

Contact: 
If you have any questions or suggestions, feel free to reach out to me at iftisa01@gettysburg.edu
