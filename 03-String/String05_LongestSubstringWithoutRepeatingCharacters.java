/*
LC03: Longest Substring Without Repeating Characters || https://leetcode.com/problems/longest-substring-without-repeating-characters

Given a string s, find the length of the longest without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 
Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;

class LongestSubstring {

  // Time complexity: O(n) || Space complexity: O(1)
  public int lengthOfLongestSubstring(String s) {
    // empty string
    if (s.equals("")) {
      return 0;
    }

    // initialize
    HashSet<Character> set = new HashSet<>();
    int maxLen = 0;
    int left = 0;
    int n = s.length();

    for (int right = 0; right < n; right++) {
      char key = s.charAt(right);

      // remove until we remove the prev duplicate value
      while (set.contains(key)) {
        set.remove(s.charAt(left));
        left++;
      }

      // add current char
      set.add(key);

      // calculate max length
      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }
}

public class String05_LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    LongestSubstring obj = new LongestSubstring();

    // example 1
    System.out.println("----- example 1 -----");
    String s1 = "ab11cde2@f234";
    System.out.println(obj.lengthOfLongestSubstring(s1));

    // example 1
    System.out.println("----- example 2 -----");
    String s2 = "ab11cd2e@f234ghi";
    System.out.println(obj.lengthOfLongestSubstring(s2));

    // example 1
    System.out.println("----- example 3 -----");
    String s3 = "";
    System.out.println(obj.lengthOfLongestSubstring(s3));
  }
}
