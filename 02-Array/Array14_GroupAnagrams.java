/*
LC49: Group Anagrams || https://leetcode.com/problems/group-anagrams

Given an array of strings strs, group the

together. You can return the answer in any order.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:
    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {

  // Approach 1 - brute force
  // Time complexity: O(n^2) || Space complexity: O(m)
  public List<List<String>> approach1(String[] strs) {
    // no element in strs so no calculation
    if (strs.length < 1) {
      return new ArrayList<>();
    }

    List<List<String>> ans = new ArrayList<>();
    int n = strs.length;

    // run a loops for check each string
    for (int i = 0; i < n; i++) {
      List<String> temp = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        // anagrams check between 2 strings
        if (isAnagrams(strs[i], strs[j])) {
          temp.add(strs[j]);
        }
      }

      // storing unique list of anagrams
      if (!ans.contains(temp)) {
        ans.add(temp);
      }
    }

    return ans;
  }

  private boolean isAnagrams(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int[] freq = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      freq[s1.charAt(i) - 'a']++;
      freq[s2.charAt(i) - 'a']--;
    }

    for (int x : freq) {
      if (x != 0) {
        return false;
      }
    }

    return true;
  }

  // Approach 2 - optimal time
  // Time complexity: O(n * m * log(m)) || Space complexity: O(nk)
  public List<List<String>> approach2(String[] strs) {
    // no element in strs so no calculation
    if (strs.length < 1) {
      return new ArrayList<>();
    }

    HashMap<String, List<String>> map = new HashMap<>();

    // loop on strs
    for (String str : strs) {
      // storing the char of current string & store it on key
      char[] charArr = str.toCharArray();
      Arrays.sort(charArr);
      String key = new String(charArr);

      // add new anagrams on map
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }

    return new ArrayList<>(map.values());
  }

  // Approach 3
  // Time complexity: O(nm) || Space complexity: O(nk)
  public List<List<String>> approach3(String[] strs) {
    // no element in strs so no calculation
    if (strs.length < 1) {
      return new ArrayList<>();
    }

    HashMap<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      // calculating freq for chars in current string
      int[] freq = new int[26];
      for (char ch : str.toCharArray()) {
        freq[ch - 'a']++;
      }

      // convert freq into string for key
      StringBuilder sb = new StringBuilder();
      for (int x : freq) {
        /*
         * adding # after all freq,
         * cuz -> 10(ten) & 10(one-zero) are the same, have to differentiate
         */
        sb.append(x).append("#");
      }
      String key = sb.toString();

      // putting new anagrams into map
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      map.get(key).add(str);
    }

    return new ArrayList<>(map.values());
  }
}

public class Array14_GroupAnagrams {
  public static void main(String[] args) {
    GroupAnagrams obj = new GroupAnagrams();

    // example 1
    System.out.println("---- example 1 ----");
    String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
    System.out.println(obj.approach1(strs1));
    System.out.println(obj.approach2(strs1));
    System.out.println(obj.approach3(strs1));

    // example 2
    System.out.println("---- example 2 ----");
    String[] strs2 = { "" };
    System.out.println(obj.approach1(strs2));
    System.out.println(obj.approach2(strs2));
    System.out.println(obj.approach3(strs2));

    // example 3
    System.out.println("---- example 3 ----");
    String[] strs3 = { "a" };
    System.out.println(obj.approach1(strs3));
    System.out.println(obj.approach2(strs3));
    System.out.println(obj.approach3(strs3));

    // example 4
    System.out.println("---- example 4 ----");
    String[] strs4 = { "abc", "dcb", "cab", "ccb", "dbc", "ab", "cccc" };
    System.out.println(obj.approach1(strs4));
    System.out.println(obj.approach2(strs4));
    System.out.println(obj.approach3(strs4));

    // example 5
    System.out.println("---- example 5 ----");
    String[] strs5 = { "bdddddddddd", "bbbbbbbbbbc" };
    System.out.println(obj.approach1(strs5));
    System.out.println(obj.approach2(strs5));
    System.out.println(obj.approach3(strs5));
  }
}
