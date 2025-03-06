/*
LC169: Majority Element || https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 
Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.Arrays;
import java.util.HashMap;

class MajorityElement {

  // Brute Force => Time Complexity: O(n log(n)) || Space Complexity: O(1)
  public int approach1(int[] arr) {
    Arrays.sort(arr);
    return arr[arr.length / 2];
  }

  // HashMap => Time Complexity: O(n) || Space Complexity: O(n)
  public int approach2(int[] arr) {
    // store key -> nums[i] & value -> count of elements
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int key : arr) {
      // put or update {key,value}
      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      } else {
        map.put(key, 1);
      }

      // check for the majority element
      if (map.get(key) > arr.length / 2) {
        return key;
      }
    }

    return -1;
  }

  // Optimal approach => Time Complexity: O(n) || Space Complexity: O()
  public int approach3(int[] arr) {
    int count = 0, ans = 0;

    for (int x : arr) {
      if (count == 0) {
        ans = x;
      }

      if (ans == x) {
        count++;
      } else {
        count--;
      }
    }
    return ans;
  }
}

public class Array04_MajorityElement {
  public static void main(String[] args) {
    MajorityElement obj = new MajorityElement();

    // example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = { 3, 2, 3 };
    System.out.println("Approach 1: " + obj.approach1(nums1));
    System.out.println("Approach 2: " + obj.approach2(nums1));
    System.out.println("Approach 3: " + obj.approach3(nums1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
    System.out.println("Approach 1: " + obj.approach1(nums2));
    System.out.println("Approach 2: " + obj.approach2(nums2));
    System.out.println("Approach 3: " + obj.approach3(nums2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] nums3 = { 1 };
    System.out.println("Approach 1: " + obj.approach1(nums3));
    System.out.println("Approach 2: " + obj.approach2(nums3));
    System.out.println("Approach 3: " + obj.approach3(nums3));

    // example 3
    System.out.println("---- example 4 ----");
    int[] nums4 = { 6, 5, 5 };
    System.out.println("Approach 1: " + obj.approach1(nums4));
    System.out.println("Approach 2: " + obj.approach2(nums4));
    System.out.println("Approach 3: " + obj.approach3(nums4));
  }
}