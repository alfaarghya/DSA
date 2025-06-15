/*
LC75: Sort Colors || https://leetcode.com/problems/sort-colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:
    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?

 */

import java.util.Arrays;

class SortColors {
  // Time Complexity: O(n) || Space Complexity: O(1)
  public void approach1(int[] nums) {
    // pointers
    int n0 = 0, n1 = 0, n = nums.length;

    // count 0's and 1's
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        n0++;
      } else if (nums[i] == 1) {
        n1++;
      }
    }

    // put 0's in range of 0 to n0
    for (int i = 0; i < n0; i++) {
      nums[i] = 0;
    }

    // put 1's in range of n0 to (n0+n1)
    for (int i = n0; i < n0 + n1; i++) {
      nums[i] = 1;
    }

    // put 2's in range of (n0+n1) to n
    for (int i = n0 + n1; i < n; i++) {
      nums[i] = 2;
    }
  }

  // Time Complexity: O(n) || Space Complexity: O(1)
  public void approach2(int[] nums) {
    // pointers
    int start = 0, end = nums.length - 1;
    int ptr = 0;

    // put 0's, 1's & 2's in place
    while (ptr <= end) {
      if (nums[ptr] == 0) {
        swap(nums, ptr++, start++);
      } else if (nums[ptr] == 1) {
        ptr++;
      } else {
        swap(nums, ptr, end--);
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

public class Array47_SortColors {
  public static void main(String[] args) {
    SortColors obj = new SortColors();
    int[] nums;

    // example 1
    System.out.println("---- example 1 ----");
    nums = new int[] { 2, 1, 0, 2, 1, 1, 2, 0, 2, 0 };
    // obj.approach1(nums);
    obj.approach2(nums);
    System.out.println(Arrays.toString(nums));

    // example 2
    System.out.println("---- example 2 ----");
    nums = new int[] { 2, 0, 2, 1, 1, 0 };
    // obj.approach1(nums);
    obj.approach2(nums);
    System.out.println(Arrays.toString(nums));
  }
}