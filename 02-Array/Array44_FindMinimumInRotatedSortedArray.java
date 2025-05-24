/*
LC153 Find Minimum in Rotated Sorted Array || https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

 

Constraints:

    n == nums.length
    1 <= n <= 5000
    -5000 <= nums[i] <= 5000
    All the integers of nums are unique.
    nums is sorted and rotated between 1 and n times.
 */

class FindMinimumInRotatedSortedArray {
  //Time complexity: O(log(n)) || Space complexity: O(1)
  public int findMin(int[] nums) {
    int n = nums.length;
    //corner case -> ony 1 element in array
    if(n == 1) {
        return nums[0];
    }

    //pointers
    int start = 0, end = n-1, mid = 0;

    //check -> array is fully rotated or sorted
    if(nums[start] < nums[end]) {
        return nums[start];
    }

    //find minimum in rotated array
    while(start < end) {
        mid = start + (end-start)/2;

        //mid is bigger than end -> means, rotated section
        if(nums[mid] > nums[end]) {
            start = mid+1;
        } else { //mid is smaller than end -> means, not in rotated section
            end = mid;
        }
    }

    //final ans
    return nums[start];
}
}

public class Array44_FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
    int[] nums;

    //example 1
    System.out.println("----- example 1 -----");
    nums = new int[] {11};
    System.out.println(obj.findMin(nums));

    //example 2
    System.out.println("----- example 2 -----");
    nums = new int[] {6,7,8,9,10,11,12,1,2,3,4,5};
    System.out.println(obj.findMin(nums));

    //example 3
    System.out.println("----- example 3 -----");
    nums = new int[] {3,5,7,10,11,25};
    System.out.println(obj.findMin(nums));
  }
}
