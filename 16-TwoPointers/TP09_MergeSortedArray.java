/*
LC88: Merge Sorted Array || https://leetcode.com/problems/merge-sorted-array/

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

 

Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109

 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeSortedArray {
  // Time complexity: O(m*n) || Space complexity: O(1)
  public void approach1(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0;
    int temp;

    while (i < m && j < n) {
      if (nums1[i] >= nums2[j]) {
        temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;

        for (int idx = j; idx < n - 1; idx++) {
          if (nums2[idx] > nums2[idx + 1]) {
            temp = nums2[idx];
            nums2[idx] = nums2[idx + 1];
            nums2[idx + 1] = temp;
          } else {
            break;
          }
        }
      }

      i++;
    }

    while (i < nums1.length && j < n) {
      nums1[i++] = nums2[j++];
    }
  }

  // Time complexity: O(m+n) || Space complexity: O(m+n)
  public void approach2(int[] nums1, int m, int[] nums2, int n) {
    List<Integer> list = new ArrayList<>();
    int i = 0, j = 0;

    // copy data acording to sort order
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        list.add(nums1[i++]);
      } else if (nums1[i] > nums2[j]) {
        list.add(nums2[j++]);
      } else {
        list.add(nums1[i++]);
        list.add(nums2[j++]);
      }
    }

    // copy rest of the data from nums1
    while (i < m) {
      list.add(nums1[i++]);
    }

    // copy rest of the data from nums2
    while (j < n) {
      list.add(nums2[j++]);
    }

    // now copy from list to nums1
    for (int k = 0; k < list.size(); k++) {
      nums1[k] = list.get(k);
    }
  }

  // Time complexity: O(m+n) || Space complexity: O(1)
  public void approach3(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = nums1.length - 1;

    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
  }
}

public class TP09_MergeSortedArray {
  public static void main(String[] args) {
    MergeSortedArray obj = new MergeSortedArray();
    int[] nums1, nums2;
    int m, n;

    //example 1
    System.out.println("----- example 1 -----");
    nums1 = new int[] {1,4,6,8,0,0,0,0,0};
    nums2 = new int[] {2,3,4,7,9};
    m = 4;
    n = 5;
    // obj.approach1(nums1, m, nums2, n);
    // obj.approach2(nums1, m, nums2, n);
    obj.approach3(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));

    //example 2
    System.out.println("----- example 2 -----");
    nums1 = new int[] {1,2,3,0,0,0};
    nums2 = new int[] {2,5,6};
    m = 3;
    n = 3;
    // obj.approach1(nums1, m, nums2, n);
    // obj.approach2(nums1, m, nums2, n);
    obj.approach3(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));

    //example 3
    System.out.println("----- example 3 -----");
    nums1 = new int[] {1};
    nums2 = new int[] {};
    m = 1;
    n = 0;
    // obj.approach1(nums1, m, nums2, n);
    // obj.approach2(nums1, m, nums2, n);
    obj.approach3(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));

    //example 4
    System.out.println("----- example 4 -----");
    nums1 = new int[] {0};
    nums2 = new int[] {1};
    m = 0;
    n = 1;
    // obj.approach1(nums1, m, nums2, n);
    // obj.approach2(nums1, m, nums2, n);
    obj.approach3(nums1, m, nums2, n);
    System.out.println(Arrays.toString(nums1));
  }
}
