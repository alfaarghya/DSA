/*
LC347: Top K Frequent Elements || https://leetcode.com/problems/top-k-frequent-elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

 

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {

  // approach 1 - sorting
  // Time complexity: O(n log(n)) || Space complexity: O(m)
  public int[] approach1(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] ans = new int[k];

    for (int key : nums) {
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }
    }

    // Convert map to a list of entries and sort by value descending
    List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());
    sortedList.sort((a, b) -> b.getValue() - a.getValue()); // Descending order

    // Get top k elements
    for (int i = 0; i < k; i++) {
      ans[i] = sortedList.get(i).getKey();
    }

    return ans;
  }

  // approach 2 - array of list(frequency)
  // Time complexity: O(n) || Space complexity: O(n)
  public int[] approach2(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] ans = new int[k];

    for (int key : nums) {
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    // initialize array of List
    List<Integer>[] freq = new ArrayList[nums.length + 1];
    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }

    // store values according to the freq
    for (int key : map.keySet()) {
      freq[map.get(key)].add(key);
    }

    // getting k frequent elements
    int idx = 0;
    for (int i = freq.length - 1; i >= 0; i--) {
      for (int val : freq[i]) {
        ans[idx++] = val;
        if (idx == k) {
          return ans;
        }
      }
    }

    return new int[0];
  }

  public void print(int[] arr) {
    System.out.print("[");
    for (int x : arr) {
      System.out.print(" " + x + " ");
    }
    System.out.print("]\n");
  }
}

public class Array24_TopKFrequentElements {
  public static void main(String[] args) {
    TopKFrequentElements obj = new TopKFrequentElements();

    //example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = {1,1,1,2,2,3};
    int k1 = 2;
    obj.print(obj.approach1(nums1, k1));
    obj.print(obj.approach2(nums1, k1));

    //example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = {1};
    int k2 = 1;
    obj.print(obj.approach1(nums2, k2));
    obj.print(obj.approach2(nums2, k2));

    //example 3
    System.out.println("---- example 3 ----");
    int[] nums3 = {5,5,3,5,2,1,3,4,2,2,2,1,4,1};
    int k3 = 3;
    obj.print(obj.approach1(nums3, k3));
    obj.print(obj.approach2(nums3, k3));

    //example 4
    System.out.println("---- example 4 ----");
    int[] nums4 = {5,3,1,1,1,3,5,73,1};
    int k4 = 3;
    obj.print(obj.approach1(nums4, k4));
    obj.print(obj.approach2(nums4, k4));
  }
}