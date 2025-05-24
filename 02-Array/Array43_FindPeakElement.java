/*
LC162: Find Peak Element || https://leetcode.com/problems/find-peak-element/

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

 

Constraints:

    1 <= nums.length <= 1000
    -2^31 <= nums[i] <= 2^31 - 1
    nums[i] != nums[i + 1] for all valid i.
 */

class FindPeakElement {
  // brute force
  // Time complexity: O(n) || Space Complexity: )(1)
  public int approach1(int[] nums) {
    // corner case -> only 1 element
    if (nums.length == 1) {
      return 0;
    }

    int max = nums[0];
    int idx = 0;
    int n = nums.length;

    // fid the peek element between 1th - n-2 th index
    for (int i = 1; i < n - 1; i++) {
      if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
        if (max < nums[i]) {
          max = nums[i];
          idx = i;
        }
      }
    }

    // compare with last element
    return max > nums[n - 1] ? idx : n - 1;
  }

  // Time optimal with binary search
  // Time complexity: O(log(n)) || Space complexity: O(1)
  public int approach2(int[] nums) {
    int n = nums.length;

    // corner case -> only 1 element
    if (n == 1) {
      return 0;
    }

    // pointers
    int start = 0, end = n - 1, mid = 0;

    // find the peek element
    while (start < end) {
      mid = start + (end - start) / 2;

      // curr element is bigger than next element
      if (nums[mid] > nums[mid + 1]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    // ans will be in start idx
    return start;
  }
}

public class Array43_FindPeakElement {
  public static void main(String[] args) {
    FindPeakElement obj = new FindPeakElement();
    int[] nums;

    //example 1
    System.out.println("----- example 1 -----");
    nums = new int[] {2,1,5,3,4,5,2,5,1,4};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    //example 2
    System.out.println("----- example 2 -----");
    nums = new int[] {6,2,5,3,6,1,4,6,3,2,4,5};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    //example 3
    System.out.println("----- example 3 -----");
    nums = new int[] {10};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    //example 4
    System.out.println("----- example 4 -----");
    nums = new int[] {2,1};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));
  }
}
