/*
LC268: Missing Number || https://leetcode.com/problems/missing-number/

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:
Input: nums = [3,0,1]
Output: 2

Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2

Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8

Explanation:
n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

 
Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */

import java.util.Arrays;

class MissingValue {

  // Brute Force => Time Complexity: O(n log(n)) || Space Complexity: O(1)
  public int approach1(int[] arr) {
    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      if (i != arr[i]) {
        return i;
      }
    }

    return arr.length;
  }

  // Extra Space => Time Complexity: O(n) || Space Complexity: O(n)
  public int approach2(int[] arr) {
    int[] temp = new int[arr.length + 1];

    for (int x : arr) {
      temp[x] = 1;
    }

    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == 0) {
        return i;
      }
    }

    return -1;
  }

  // Optimal Approach => Time Complexity: O(n) || Space Complexity: O(1)
  public int approach3(int[] arr) {
    int n = arr.length;
    int expectedSum = n * (n + 1) / 2;
    int realSum = 0;

    for (int x : arr) {
      realSum += x;
    }

    return expectedSum - realSum;
  }

}

public class Array05_MissingValue {
  public static void main(String[] args) {
    MissingValue obj = new MissingValue();

    // example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = { 3, 0, 1 };
    System.out.println("Approach 1: " + obj.approach1(nums1));
    System.out.println("Approach 2: " + obj.approach2(nums1));
    System.out.println("Approach 3: " + obj.approach3(nums1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = { 0, 1 };
    System.out.println("Approach 1: " + obj.approach1(nums2));
    System.out.println("Approach 2: " + obj.approach2(nums2));
    System.out.println("Approach 3: " + obj.approach3(nums2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] nums3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
    System.out.println("Approach 1: " + obj.approach1(nums3));
    System.out.println("Approach 2: " + obj.approach2(nums3));
    System.out.println("Approach 3: " + obj.approach3(nums3));

  }
}