/*
LC136: Single Number ||https://leetcode.com/problems/single-number/

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1


Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */

import java.util.HashSet;

class SingleNumber {
  // Brute Force Approach => Time Complexity: O(n^2) || Space Complexity: O(1)
  public int approach1(int[] nums) {

    for (int x : nums) {
      int count = 0;
      for (int y : nums) {
        // check for duplicate value
        if (x == y) {
          count++;
        }
      }

      // check if there are no duplicate value
      if (count == 1) {
        return x;
      }
    }

    return -1;
  }

  // HashSet Approach => Time Complexity: O(n) || Space Complexity: O(n)
  public int approach2(int[] nums) {

    HashSet<Integer> set = new HashSet<>();

    for (int key : nums) {
      if (set.contains(key)) {
        set.remove(key);
      } else {
        set.add(key);
      }
    }

    return set.iterator().next();
  }

  // Bit Manipulation Approach => Time Complexity: O(n) || Space Complexity: O(1)
  public int approach3(int[] nums) {
    int ans = 0;

    for (int x : nums) {
      ans ^= x;
    }

    return ans;
  }
}

public class Array03_SingleNumber {
  public static void main(String[] args) {
    SingleNumber obj = new SingleNumber();

    // example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = { 2, 2, 1 };
    System.out.println("Approach 1: " + obj.approach1(nums1));
    System.out.println("Approach 2: " + obj.approach2(nums1));
    System.out.println("Approach 3: " + obj.approach3(nums1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = { 4, 1, 2, 1, 2 };
    System.out.println("Approach 1: " + obj.approach1(nums2));
    System.out.println("Approach 2: " + obj.approach2(nums2));
    System.out.println("Approach 3: " + obj.approach3(nums2));

    // example 3
    System.out.println("---- example 2 ----");
    int[] nums3 = { 1 };
    System.out.println("Approach 1: " + obj.approach1(nums3));
    System.out.println("Approach 2: " + obj.approach2(nums3));
    System.out.println("Approach 3: " + obj.approach3(nums3));
  }
}