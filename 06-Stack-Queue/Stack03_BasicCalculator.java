/*
LC224: Basic Calculator || https://leetcode.com/problems/basic-calculator

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2

Example 2:

Input: s = " 2-1 + 2 "
Output: 3

Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

 

Constraints:

    1 <= s.length <= 3 * 10^5
    s consists of digits, '+', '-', '(', ')', and ' '.
    s represents a valid expression.
    '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
    '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
    There will be no two consecutive operators in the input.
    Every number and running calculation will fit in a signed 32-bit integer.
 */

import java.util.Stack;

class BasicCalculator {
  // Time complexity: O(n) || Space complexity: O(n)
  public int calculate(String s) {
    Stack<Integer> stk = new Stack<>(); // store values before brackets
    int number = 0; // store current digits
    int sign = 1; // + or - sign
    int ans = 0; // calculate the result of each operations

    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) { // digits
        number = 10 * number + (int) (ch - '0');
      } else if (ch == '+') { // add operation
        ans += sign * number;
        number = 0;
        sign = 1;
      } else if (ch == '-') { // minus operation
        ans += sign * number;
        number = 0;
        sign = -1;
      } else if (ch == '(') {
        // store prev ans & sign into stack
        stk.push(ans);
        stk.push(sign);

        // go back to default
        ans = 0;
        sign = 1;
      } else if (ch == ')') {
        ans += sign * number; // first calculate ans inside brackets

        // before brackets
        ans *= stk.pop(); // sign
        ans += stk.pop(); // ans

        number = 0;
      }
    }

    // if number still holds value do calculation
    if (number != 0) {
      ans += sign * number;
    }

    return ans;

  }
}

public class Stack03_BasicCalculator {
  public static void main(String[] args) {
    BasicCalculator obj = new BasicCalculator();
    String s;

    //example 1
    System.out.println("----- example 1 -----");
    s = "10-2+(3+4-(5+6)+(7+2-1))";
    System.out.println(obj.calculate(s));

    //example 2
    System.out.println("----- example 2 -----");
    s = "(1-(2+3)+(4+5-6)-7+8)";
    System.out.println(obj.calculate(s));
  }
}
