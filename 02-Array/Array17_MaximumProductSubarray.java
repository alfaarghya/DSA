/*
LC152: Maximum Product Subarray || https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 

Constraints:
    1 <= nums.length <= 2 * 104
    -10 <= nums[i] <= 10
    The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */

class MaximumProductSubarray {
  // TC => O(n) || SC => O(1)
  public int maxProduct(int[] nums) {
    int max = nums[0], min = nums[0], ans = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int temp = max;
      int currentVal = nums[i];

      // calculate maximum product till this point or element
      max = Math.max(currentVal, Math.max(max * currentVal, min * currentVal));

      // calculate minimum product till this point or element
      min = Math.min(currentVal, Math.min(temp * currentVal, min * currentVal));

      // whenever max is bigger update ans
      if (max > ans) {
        ans = max;
      }

    }

    return ans;
  }
}

public class Array17_MaximumProductSubarray {
  public static void main(String[] args) {
    MaximumProductSubarray obj = new MaximumProductSubarray();

    // example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = { 3, 2, -2, 1, 2, 5, 0 };
    System.out.println(obj.maxProduct(nums1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = { 3, 2, -2, -2, 3, -4, 0, 1, 2 };
    System.out.println(obj.maxProduct(nums2));
  }
}