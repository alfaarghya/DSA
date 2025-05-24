/*
LC22: Generate Parentheses || https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

 

Constraints:

    1 <= n <= 8

 */

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {

  //Time complexity: O(4^n / sqrt(n)) || Space Complexity: O(4^n / sqrt(n) * n)
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    helper(n, 0, 0, new StringBuilder(""), list);

    return list  ;
}

private void helper(int n, int open, int close, StringBuilder sb, List<String> list) {
    //base case
    if(sb.length() == n*2) {
        list.add(sb.toString());
        return;
    }

    //put open brackets
    if(open < n) {
        sb.append('(');
        helper(n, open+1, close, sb, list); //recurssive call
        sb.deleteCharAt(sb.length()-1); //backtrack step
    }

    //put close brackets
    if(close < open) {
        sb.append(')');
        helper(n, open, close+1, sb, list); //recurssive call
        sb.deleteCharAt(sb.length()-1); //backtrack step
    }
}
}

public class String11_GenerateParentheses {
  public static void main(String[] args) {
    GenerateParentheses obj = new GenerateParentheses();
    int n;

    //example 1
    System.out.println("----- example 1 -----");
    n = 3;
    System.out.println(obj.generateParenthesis(n));
    System.out.println(obj.generateParenthesis(n).size());
    
    //example 2
    System.out.println("----- example 2 -----");
    n = 5;
    System.out.println(obj.generateParenthesis(n));
    System.out.println(obj.generateParenthesis(n).size());

    //example 3
    // System.out.println("----- example 3 -----");
    // n = 8;
    // System.out.println(obj.generateParenthesis(n));
  }
}