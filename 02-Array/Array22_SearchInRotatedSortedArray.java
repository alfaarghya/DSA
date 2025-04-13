/*
LC33: Search in Rotated Sorted Array || https://leetcode.com/problems/search-in-rotated-sorted-array/

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 

Constraints:
    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
 */

class SearchInRotatedSortedArray {
  // Time complexity: O(log(n)) || Space complexity: O(1)
  public int search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    int mid = 0;

    while (start <= end) {

      // calculate mid
      mid = start + (end - start) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      /*
       * imagine 2 lines =>
       * + line 1 -> start from 0th index to before pivot point
       * + line 2 -> start from pivot point to nth index
       */

      // case 1 => when mid lies on line 1
      if (nums[start] <= nums[mid]) {
        // target lies on left side of mid
        if (target <= nums[mid] && target >= nums[start]) {
          end = mid - 1;

          // target lies on right side of mid
        } else {
          start = mid + 1;
        }

        // case 2 => when mid lies on line 2
      } else {
        // target lies on tight side of mid
        if (target >= nums[mid] && target <= nums[end]) {
          start = mid + 1;

          // target lies on left side of mid
        } else {
          end = mid - 1;
        }
      }
    }

    return -1;
  }
}

public class Array22_SearchInRotatedSortedArray {
  public static void main(String[] args) {
    SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

    // example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
    int target1 = 0;
    System.out.println(obj.search(nums1, target1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
    int target2 = 3;
    System.out.println(obj.search(nums2, target2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] nums3 = { 1 };
    int target3 = 0;
    System.out.println(obj.search(nums3, target3));
  }
}
