/*
LC300: Longest Increasing Subsequence || https://leetcode.com/problems/longest-increasing-subsequence

Given an integer array nums, return the length of the longest strictly increasing

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:
    1 <= nums.length <= 2500
    -10^4 <= nums[i] <= 10^4


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

 import java.util.Arrays;

class LongestIncreasingSubsequence {

  // Time complexity: O(n^2) || Space Complexity: O(n)
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    if (n == 0 || n == 1) {
      return n;
    }

    int[] dp = new int[n];

    // fill up dp with 1
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    // find max Length from dp
    int maxLength = 0;
    for (int val : dp) {
      maxLength = Math.max(maxLength, val);
    }

    return maxLength;
  }
}

public class Array35_LongestIncreasingSubsequence {
  public static void main(String[] args) {
    LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
    int[] nums;

    // example 1
    System.out.println("----- example 1 -----");
    nums = new int[] { 0, 1, 0, 3, 2, 3, 4 };
    System.out.println(obj.lengthOfLIS(nums));

    // example 2
    System.out.println("----- example 2 -----");
    nums = new int[] { 1, 3, 6, 7, 9, 4, 10, 4, 6 };
    System.out.println(obj.lengthOfLIS(nums));
  }
}
