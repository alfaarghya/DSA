/*
LC1: Two Sum || https://leetcode.com/problems/two-sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
- 2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
- Only one valid answer exists.
 */

import java.util.HashMap;

class TwoSum {

  // Brute Force => time complexity: O(n^2) || space complexity: O(1)
  public int[] approach1(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] {};
  }

  // approach 2 => time complexity: O(n) || space complexity: O(n)
  public int[] approach2(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(); // key: nums[i], value: i

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int val = target - nums[i];
      if (map.containsKey(val) && map.get(val) != i) {
        return new int[] { i, map.get(val) };
      }
    }

    return new int[] {};
  }

  // approach 3=> time complexity: O(n) || space complexity: O(n)
  public int[] approach3(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(); // key: nums[i], value: i

    for (int i = 0; i < nums.length; i++) {
      int val = target - nums[i];
      if (map.containsKey(val) && map.get(val) != i) {
        return new int[] { i, map.get(val) };
      }
      map.put(nums[i], i);
    }

    return new int[] {};
  }
}

public class Array01_TwoSum {
  public static void main(String[] args) {
    int[] nums1 = { 2, 7, 11, 15 };
    int target1 = 9;

    int[] nums2 = { 3, 2, 4 };
    int target2 = 6;

    int[] nums3 = { 3, 3 };
    int target3 = 5;

    TwoSum ts = new TwoSum();
    System.out.println("Approach 1");
    System.out.println(ts.approach1(nums1, target1).length != 0
        ? ts.approach1(nums1, target1)[0] + "," + ts.approach1(nums1, target1)[1]
        : "No result");
    System.out.println(ts.approach1(nums2, target2).length != 0
        ? ts.approach1(nums2, target2)[0] + "," + ts.approach1(nums2, target2)[1]
        : "No result");
    System.out.println(ts.approach1(nums3, target3).length != 0
        ? ts.approach1(nums3, target3)[0] + "," + ts.approach1(nums3, target3)[1]
        : "No result");

    System.out.println("Approach 2");
    System.out.println(ts.approach2(nums1, target1).length != 0
        ? ts.approach2(nums1, target1)[0] + "," + ts.approach2(nums1, target1)[1]
        : "No result");
    System.out.println(ts.approach2(nums2, target2).length != 0
        ? ts.approach2(nums2, target2)[0] + "," + ts.approach2(nums2, target2)[1]
        : "No result");
    System.out.println(ts.approach2(nums3, target3).length != 0
        ? ts.approach2(nums3, target3)[0] + "," + ts.approach2(nums3, target3)[1]
        : "No result");

    System.out.println("Approach 3");
    System.out.println(ts.approach3(nums1, target1).length != 0
        ? ts.approach3(nums1, target1)[0] + "," + ts.approach3(nums1, target1)[1]
        : "No result");
    System.out.println(ts.approach3(nums2, target2).length != 0
        ? ts.approach3(nums2, target2)[0] + "," + ts.approach3(nums2, target2)[1]
        : "No result");
    System.out.println(ts.approach3(nums3, target3).length != 0
        ? ts.approach3(nums3, target3)[0] + "," + ts.approach3(nums3, target3)[1]
        : "No result");

  }
}