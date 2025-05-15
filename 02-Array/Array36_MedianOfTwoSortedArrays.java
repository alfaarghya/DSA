/*
LC04: Median of Two Sorted Arrays || https://leetcode.com/problems/median-of-two-sorted-arrays


Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -10^6 <= nums1[i], nums2[i] <= 10^6
 */

 class MedianOfTwoSortedArrays {
  //Time Complexity: O(m+n) || Space Complexity => O(m+n)
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int[] nums = new int[m+n];

    //merge 2 arrays into nums
    int i = 0, j = 0, k = 0;
    while(i < m && j < n) {
        if(nums1[i] < nums2[j]) {
            nums[k++] = nums1[i++];
        } else {
            nums[k++] = nums2[j++];
        }
    }

    while(i < m) {
        nums[k++] = nums1[i++];
    }
    while(j < n) {
        nums[k++] = nums2[j++];
    }

    //find the median
    double median = 0.0;

    if((m+n) % 2 == 1) { //odd
        median = (double) nums[(m+n)/2];
    } else {//even
        median = (double) (nums[(m+n)/2]+nums[(m+n)/2 - 1])/2.0d;
    }

    return median;
}
}

public class Array36_MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
    int[] nums1, nums2;

    //example 1
    System.out.println("----- example 1 -----");
    nums1 = new int[] {2,4,5,7,9};
    nums2 = new int[] {1,3,5,6,8,8,10};
    System.out.println(obj.findMedianSortedArrays(nums1, nums2));
  }
}
