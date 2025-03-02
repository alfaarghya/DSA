/*
LC125: Valid Palindrome || https://leetcode.com/problems/valid-palindrome/

 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

class ValidPalindrome {
  public boolean approach1(String s) {
    if (s == " ") { // when it is empty string
      return false;
    }

    int startIndex = 0, endIndex = s.length() - 1;

    while (startIndex <= endIndex) {
      char char1 = s.charAt(startIndex), char2 = s.charAt(endIndex);
      if (!Character.isLetterOrDigit(char1)) {
        startIndex++;
      } else if (!Character.isLetterOrDigit(char2)) {
        endIndex--;
      } else {
        if (Character.toLowerCase(char1) != Character.toLowerCase(char2)) {
          return false;
        }
        startIndex++;
        endIndex--;
      }
    }

    return true;
  }
}

public class String01_ValidPalindrome {
  public static void main(String[] args) {
    ValidPalindrome obj = new ValidPalindrome();

    // example 1
    String s1 = "race a car";
    System.out.println(obj.approach1(s1));

    // example 2
    String s2 = "ab1d23ba5";
    System.out.println(obj.approach1(s2));

    // example 3
    String s3 = "rAcE caR";
    System.out.println(obj.approach1(s3));
  }
}