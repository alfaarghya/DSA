/*
LC5: Longest Palindromic Substring || https://leetcode.com/problems/longest-palindromic-substring

Given a string s, return the longest in s.


Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 
Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.
 */

class LongestPalindrome {
  // approach 1
  // TC => O(n^3) || SC => O(1)
  public String approach1(String s) {
    int n = s.length();

    for (int length = n; length > 0; length--) {
      for (int i = 0; i <= n - length; i++) {
        // System.out.println(i + "," + length);
        if (isPalindrome(s, i, i + length)) {
          return s.substring(i, i + length);
        }
      }
      // System.out.println("-----------");
    }
    return "";
  }
  private boolean isPalindrome(String s, int i, int j) {
    // System.out.println(i + ",," + j);
    int left = i, right = j - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

  // approach 2
  // TC => O(n^2) || SC => O(1)
  public String approach2(String s) {
    int start = 0, end = 0;

    for(int i = 0; i < s.length(); i++) {
      int oddLen = expandFromCenter(i, i, s);
      int evenLen = expandFromCenter(i, i+1, s);

      int maxLen = Math.max(oddLen, evenLen);

      if(maxLen > end - start) {
        start = i - (maxLen-1) / 2;
        end = i + maxLen/2;
      }
    }

    return s.substring(start, end+1);
  }
  private int expandFromCenter(int left, int right, String str) {
    while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
      left--;
      right++;
    }

    return right - left - 1;
  }
}

public class String04_LongestPalindromicSubstring {
  public static void main(String[] args) {
    LongestPalindrome obj = new LongestPalindrome();

    // example 1
    System.out.println("---- example 1 ----");
    String s1 = "abz12521cdege";
    System.out.println(obj.approach1(s1));
    System.out.println(obj.approach2(s1));
  }
}
