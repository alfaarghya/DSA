/*
 LC242: Valid Anagram || https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise. 

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

import java.util.HashMap;

class ValidAnagram {

  /*
   * Approach 1: using frequency array -> use when there are limited number of
   * characters(s and t consist of lowercase English letters.)
   * Time Complexity: O(n) || Space Complexity: O(m), where m is the size of freq
   * array
   */
  public boolean approach1(String s, String t) {
    // s & l does not have same length
    if (s.length() != t.length()) {
      return false;
    }

    // store the frequency of each character
    int[] freq = new int[26];

    // update the frequency of each character in s & t
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }

    // check if all the frequency is 0
    for (int x : freq) {
      if (x != 0) {
        return false;
      }
    }

    return true;
  }

  /*
   * Approach 2: using hashmap -> use when there are large number of
   * characters(numeric, characters, special characters)
   * Time Complexity: O(n) || Space Complexity: O(m), where m is the size of
   * hashmap
   */
  public boolean approach2(String s, String t) {
    // s & l does not have same length
    if (s.length() != t.length()) {
      return false;
    }

    // store the frequency of each character in hashMap
    HashMap<Character, Integer> map = new HashMap<>();

    // update frequency of characters in s
    for (char key : s.toCharArray()) {
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }

    // update frequency of characters in t
    for (char key : t.toCharArray()) {
      if (map.containsKey(key)) {
        map.put(key, map.get(key) - 1);
      } else {
        return false;
      }
    }

    // check if all the frequency is 0
    for (int x : map.values()) {
      if (x != 0) {
        return false;
      }
    }

    return true;
  }

}

public class String02_ValidAnagram {
  public static void main(String[] args) {
    ValidAnagram obj = new ValidAnagram();

    // example 1
    System.out.println("------ Example 1 ------");
    String s1 = "anagram";
    String t1 = "nagaram";
    System.out.println(obj.approach1(s1, t1));
    System.out.println(obj.approach2(s1, t1));

    // example 2
    System.out.println("------ Example 2 ------");
    String s2 = "rat";
    String t2 = "cat";
    System.out.println(obj.approach1(s2, t2));
    System.out.println(obj.approach2(s2, t2));

    // example 3
    System.out.println("------ Example 3 ------");
    String s3 = "false";
    String t3 = "true";
    System.out.println(obj.approach1(s3, t3));
    System.out.println(obj.approach2(s3, t3));
  }
}