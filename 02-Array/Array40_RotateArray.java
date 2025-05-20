/*
LC189: Rotate Array || https://leetcode.com/problems/rotate-array/

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 

Constraints:

    1 <= nums.length <= 10^5
    -2^31 <= nums[i] <= 2^31 - 1
    0 <= k <= 10^5

 

Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
 */

 import java.util.Arrays;

class RotateArray {
  // Time complexity: O(n) || Space complexity: O(n)
  public void approach1(int[] nums, int k) {
    int n = nums.length, idx = 0;
    k = k % n;
    if (k == 0 || n == 0) {
      return;
    }

    int[] ans = new int[n];
    // store k elements in ans
    for (int i = n - k; i < n; i++) {
      ans[idx++] = nums[i];
    }

    // store rest of the element
    for (int i = 0; i < n - k; i++) {
      ans[idx++] = nums[i];
    }

    // copy ans into nums
    for (int i = 0; i < n; i++) {
      nums[i] = ans[i];
    }
  }

  // Time complexity: O(n) || Space complexity: O(1)
  public void approach2(int[] nums, int k) {
    int n = nums.length;
    k = k % n;

    if (k == 0 || n == 0) {
      return;
    }

    reverse(nums, 0, n - 1); // reverse entire array
    reverse(nums, 0, k - 1); // reverse k elements
    reverse(nums, k, n - 1); // reverse rest of the elements
  }

  private void reverse(int[] nums, int start, int end) {
    while (start <= end) {
      // swap
      int swap = nums[start];
      nums[start] = nums[end];
      nums[end] = swap;

      // update pointer
      start++;
      end--;
    }
  }
}

public class Array40_RotateArray {
  public static void main(String[] args) {
    RotateArray obj = new RotateArray();
    int[] nums;
    int k;

    //example 1
    System.out.println("----- example 1 -----");
    nums = new int[] {7,2,1,3,5,4,-11,10,9,8,1};
    k = 5;
    // obj.approach1(nums, k);
    obj.approach2(nums, k);
    System.out.println(Arrays.toString(nums));

    //example 2
    System.out.println("----- example 2 -----");
    nums = new int[] {1,2};
    k = 7;
    // obj.approach1(nums, k);
    obj.approach2(nums, k);
    System.out.println(Arrays.toString(nums));

    //example 3
    System.out.println("----- example 3 -----");
    nums = new int[] {1,2,-11,-10};
    k = 4;
    // obj.approach1(nums, k);
    obj.approach2(nums, k);
    System.out.println(Arrays.toString(nums));
  }
}
