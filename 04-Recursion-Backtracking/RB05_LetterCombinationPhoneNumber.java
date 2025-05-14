/*
LC17: Letter Combinations of a Phone Number || https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].

 */

 import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LetterCombinationPhoneNumber {
  HashMap<Character, String> map;

  LetterCombinationPhoneNumber() {
    this.map = new HashMap<>();
    this.map.put('2', "abc");
    this.map.put('3', "def");
    this.map.put('4', "ghi");
    this.map.put('5', "jkl");
    this.map.put('6', "mno");
    this.map.put('7', "pqrs");
    this.map.put('8', "tuv");
    this.map.put('9', "wxyz");
  }

  //Time complexity: O(4^n) OR O(3^n)
  public List<String> letterCombinations(String digits) {
    // empty digits
    if (digits.length() == 0) {
      return new ArrayList<>();
    }

    List<String> ans = new ArrayList<>(); // store the combinations
    helper(0, digits, ans, new StringBuilder("")); // function call

    return ans;
  }

  private void helper(int idx, String digits, List<String> ans, StringBuilder sb) {
    // base case, idx is now equal or bigger than digits size
    if (idx >= digits.length()) {
      ans.add(sb.toString()); // and combination into ans
      sb = new StringBuilder(""); // re-initialize sb
      return;
    }

    String letters = map.get(digits.charAt(idx));// get all letters for current digits

    for (char ch : letters.toCharArray()) {
      sb.append(ch); // add character into sb
      helper(idx + 1, digits, ans, sb); // recursive call -> increase idx by 1
      sb.deleteCharAt(sb.length() - 1); // backtrack
    }
  }
}

public class RB05_LetterCombinationPhoneNumber {
  public static void main(String[] args) {
    LetterCombinationPhoneNumber obj = new LetterCombinationPhoneNumber();
    String digits;

    //example 1
    System.out.println("----- example 1 -----");
    digits = "";
    System.out.println(obj.letterCombinations(digits));

    //example 2
    System.out.println("----- example 2 -----");
    digits = "77";
    System.out.println(obj.letterCombinations(digits));

    //example 2
    System.out.println("----- example 2 -----");
    digits = "234";
    System.out.println(obj.letterCombinations(digits));

    //example 3
    System.out.println("----- example 3 -----");
    digits = "72";
    System.out.println(obj.letterCombinations(digits));
  }
}
