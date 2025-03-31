/*
LC215: Kth Largest Element in an Array || https://leetcode.com/problems/kth-largest-element-in-an-array


Given an integer array nums and an integer k, return the kth largest element in the array.
Note: that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:
    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElement {
  // approach 1 - brute force
  // TC => O(n log(n)) || SC => O(1)
  public int approach1(int[] arr, int k) {
    // sort the array
    Arrays.sort(arr);

    // run a loop & find the kth largest element
    for (int i = arr.length - 1; i >= 0; i--) {
      if (k == 1) {
        return arr[i];
      }
      k--;
    }

    return -1;
  }

  // approach 2 - Min Heap
  // TC => O(n log(k)) || SC => O(k)
  public int approach2(int[] arr, int k) {
    // create a min heap -> only k number of items will store
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int x : arr) {
      // add data into min-heap
      minHeap.add(x);

      // if minHeap size is bigger than k -> remove from min heap
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    // at the top of heap, our kth largest integer
    return minHeap.peek();
  }

}

public class Array15_KthLargestElementInAnArray {
  public static void main(String[] args) {
    KthLargestElement obj = new KthLargestElement();

    // example 1
    System.out.println("---- example 1 ----");
    int[] arr1 = { 3, 2, 1, 5, 6, 4 };
    int k1 = 2;
    System.out.println(obj.approach1(arr1, k1));
    System.out.println(obj.approach2(arr1, k1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] arr2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k2 = 4;
    System.out.println(obj.approach1(arr2, k2));
    System.out.println(obj.approach2(arr2, k2));

  }
}
