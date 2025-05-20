/*
LC201: Bitwise AND of Numbers Range || https://leetcode.com/problems/bitwise-and-of-numbers-range

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

 

Example 1:

Input: left = 5, right = 7
Output: 4

Example 2:

Input: left = 0, right = 0
Output: 0

Example 3:

Input: left = 1, right = 2147483647
Output: 0

 

Constraints:

    0 <= left <= right <= 231 - 1

 */

class Solution {
  //Brute force
  // Time complexity: O(n) || Space complexity: O(1)
  public int approach1(int left, int right) {
    int ans = left;
    int range = left + 1;

    while (range <= right) {
      ans &= range;
      range++;
    }

    return ans;
  }

  //time optimal
  // Time complexity: O(log(n)) || Space complexity: O(1)
  public int approach2(int left, int right) {
    int count = 0;

    while (left != right) {
      left >>= 1;
      right >>= 1;

      count++;
    }

    return left << count;
  }
}

public class BW03_BitwiseANDofNumbersRange {
  public static void main(String[] args) {
    Solution obj = new Solution();
    int left, right;
    
    //example 1
    System.out.println("----- example 1 -----");
    left = 5; right = 5;
    // System.out.println(obj.approach1(left, right));
    System.out.println(obj.approach2(left, right));

    //example 2
    System.out.println("----- example 2 -----");
    left = 5; right = 10;
    // System.out.println(obj.approach1(left, right));
    System.out.println(obj.approach2(left, right));

    //example 3
    System.out.println("----- example 3 -----");
    left = 5; right = 7;
    // System.out.println(obj.approach1(left, right));
    System.out.println(obj.approach2(left, right));

    //example 4
    System.out.println("----- example 4 -----");
    left = 1; right = 2147483647;
    // System.out.println(obj.approach1(left, right));
    System.out.println(obj.approach2(left, right));
  }
}
