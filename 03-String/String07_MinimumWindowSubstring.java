/*
LC76: Minimum Window Substring || https://leetcode.com/problems/minimum-window-substring

Given two strings s and t of lengths m and n respectively, return the minimum window

of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

 

Constraints:

    m == s.length
    n == t.length
    1 <= m, n <= 105
    s and t consist of uppercase and lowercase English letters.

 
Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

import java.util.HashMap;

class MinimumWindowSubstring {

  //Time complexity: O(m+n) || Space complexity: O(m+n)
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    // store t's value and freq on a map
    HashMap<Character, Integer> distT = new HashMap<>();
    for (char key : t.toCharArray()) {
      distT.put(key, distT.getOrDefault(key, 0) + 1);
    }

    // initilize
    int n = distT.size(), startIdx = 0, formed = 0;
    int[] minWindow = { 0, Integer.MAX_VALUE };
    HashMap<Character, Integer> countMap = new HashMap<>();

    // run a loop on s
    for (int endIdx = 0; endIdx < s.length(); endIdx++) {
      char key = s.charAt(endIdx);

      // put or update in countMap
      countMap.put(key, countMap.getOrDefault(key, 0) + 1);

      // check if current char present on distT & freq same as countMap
      if (distT.containsKey(key) && distT.get(key).intValue() == countMap.get(key).intValue()) {
        formed++; // keep track how much we still need to be equal with `n`
      }

      while (startIdx <= endIdx && formed == n) {
        char startChar = s.charAt(startIdx);

        // get the minimum substring
        if (endIdx - startIdx < minWindow[1] - minWindow[0]) {
          minWindow[0] = startIdx;
          minWindow[1] = endIdx;
        }

        // decrese by 1 -> marked as visited
        countMap.put(startChar, countMap.get(startChar) - 1);

        // decrese formed if freq doesn't match
        if (distT.containsKey(startChar) && distT.get(startChar) > countMap.get(startChar)) {
          formed--;
        }

        // update startIdx
        startIdx++;
      }
    }

    //return sub-string
    return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
  }
}

public class String07_MinimumWindowSubstring {
  public static void main(String[] args) {
    MinimumWindowSubstring obj = new MinimumWindowSubstring();
    String s, t;

    //example 1
    System.out.println("---- example 1 ----");
    s = "ADOBECODEBANC";
    t = "BANC";
    System.out.println(obj.minWindow(s, t));

    //example 2
    System.out.println("---- example 2 ----");
    s = "a";
    t = "aa";
    System.out.println(obj.minWindow(s, t));

    //example 3
    System.out.println("---- example 3 ----");
    s = "ABcdXYmNckzXNccbbckN";
    t = "cccN";
    System.out.println(obj.minWindow(s, t));
  }
}
