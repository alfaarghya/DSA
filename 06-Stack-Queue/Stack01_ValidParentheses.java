/*
LC20: Valid Parentheses || https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;

class ValidParentheses {

  // TC: O(n) || SC: O(n)
  public boolean approach1(String s) {
    Stack<Character> stk = new Stack<>();

    for (char ch : s.toCharArray()) {
      // if it's open bracket -> push it to stk
      if (ch == '(' || ch == '{' || ch == '[') {
        stk.push(ch);
      } else {
        // if stk is empty -> return false
        if (stk.isEmpty()) {
          return false;
        }

        char top = stk.peek();
        // if it's close bracket with same type -> pop it from stk
        if (top == '(' && ch == ')' ||
            top == '{' && ch == '}' ||
            top == '[' && ch == ']') {
          stk.pop();
        } else {
          return false;
        }
      }
    }

    // check stk is empty or not
    return stk.isEmpty();
  }
}

public class Stack01_ValidParentheses {
  public static void main(String[] args) {
    String s1 = "()";
    String s2 = "(){}[]";
    String s3 = "(])";
    String s4 = "())";
    String s5 = "]";

    ValidParentheses vp = new ValidParentheses();

    System.out.println(vp.approach1(s1));
    System.out.println(vp.approach1(s2));
    System.out.println(vp.approach1(s3));
    System.out.println(vp.approach1(s4));
    System.out.println(vp.approach1(s5));
  }
}
