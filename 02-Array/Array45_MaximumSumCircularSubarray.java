/*
LC918: Maximum Sum Circular Subarray || https://leetcode.com/problems/maximum-sum-circular-subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.

 

Constraints:
    n == nums.length
    1 <= n <= 3 * 10^4
    -3 * 10^4 <= nums[i] <= 3 * 10^4

 */

class MaximumSumCircularSubarray {
  //Time complexity: O(n) || Space Complexity: O(1)
  public int maxSubarraySumCircular(int[] nums) {
    int maxSum = nums[0], currMax = nums[0];
    int minSum = nums[0], currMin = nums[0];
    int totalSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];

      // calculate total sum
      totalSum += num;

      // Kadane's algorithm for maximum sum
      // either extend previos sub-array or start new one
      currMax = Math.max(currMax + num, num);
      maxSum = Math.max(maxSum, currMax);

      // Kadane's algorithm for minimum sum
      // either extend previos sub-array or start new one
      currMin = Math.min(currMin + num, num);
      minSum = Math.min(minSum, currMin);
    }

    int circularSum = totalSum - minSum;

    // corner case -> nums[] contains only negative numbers
    if (circularSum == 0) {
      return maxSum;
    }

    // return either maxSum(when nums[] is strictly increasing order)
    // or circularSum for sub-array
    return Math.max(maxSum, circularSum);
  }
}

public class Array45_MaximumSumCircularSubarray {
  public static void main(String[] args) {
    MaximumSumCircularSubarray obj = new MaximumSumCircularSubarray();
    int[] nums;

    //example 1
    System.out.println("----- example 1 -----");
    nums = new int[] {3,1,-1,2,0,-4,-1,-2,6,5};
    System.out.println(obj.maxSubarraySumCircular(nums));

    //example 2
    System.out.println("----- example 2 -----");
    nums = new int[] {1,2,3,4,5,6,7};
    System.out.println(obj.maxSubarraySumCircular(nums));

    //example 3
    System.out.println("----- example 3 -----");
    nums = new int[] {-1,-2,-3,-4,-5,-6};
    System.out.println(obj.maxSubarraySumCircular(nums));
  }
}
