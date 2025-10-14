/*
LC229: Majority Element II|| https://leetcode.com/problems/majority-element-ii/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 
Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]

 

Constraints:

    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MajorityElementII {

  // HashMap
  // Time Complexity: O(n) || Space Complexity: O(n)
  public List<Integer> approach1(int[] arr) {
    int n = arr.length;
    List<Integer> ans = new ArrayList<>(); // to store answers
    HashMap<Integer, Integer> map = new HashMap<>();

    // calculate the frequency
    for (int key : arr) {
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    // get the final ans
    for (int key : map.keySet()) {
      if (map.get(key) > n / 3) {
        ans.add(key);
      }
    }

    return ans;

  }

  // Optimal Approach (Extended Boyer Moore’s Voting Algorithm)
  // Time Complexity: O(n) || Space Complexity: O(1)
  public List<Integer> approach2(int[] arr) {
    int n = arr.length;

    // track the counts
    int count1 = 0, count2 = 0;
    // possible majority elements
    int val1 = Integer.MIN_VALUE, val2 = Integer.MIN_VALUE;

    // find the possible majority elements
    for (int curr : arr) {
      if (count1 == 0 && curr != val2) {
        count1 = 1;
        val1 = curr;
      } else if (count2 == 0 && curr != val1) {
        count2 = 1;
        val2 = curr;
      } else if (curr == val1) {
        count1++;
      } else if (curr == val2) {
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    // check if the val1 & val2 are the possible majority element
    count1 = 0;
    count2 = 0;
    for (int curr : arr) {
      if (curr == val1) {
        count1++;
      }
      if (curr == val2) {
        count2++;
      }
    }

    List<Integer> ans = new ArrayList<>();
    if (count1 > n / 3) {
      ans.add(val1);
    }
    if (count2 > n / 3) {
      ans.add(val2);
    }

    return ans;
  }

}

public class Array51_MajorityElementII {
  public static void main(String[] args) {
    MajorityElementII obj = new MajorityElementII();
    int[] nums;

    // example 1
    System.out.println("---- example 1 ----");
    nums = new int[] { 3, 2, 3 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    // example 2
    System.out.println("---- example 2 ----");
    nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    // example 3
    System.out.println("---- example 3 ----");
    nums = new int[] { 1 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    // example 4
    System.out.println("---- example 4 ----");
    nums = new int[] { 6, 5, 5 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    // example 5
    System.out.println("---- example 5 ----");
    nums = new int[] { 2, 1, 2, 2, 1, 3, 4, 2, 1, 3, 1 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    // example 6
    System.out.println("---- example 6 ----");
    nums = new int[] { 2, 1, 1, 3, 1, 4, 5, 6 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    // example 7
    System.out.println("---- example 7 ----");
    nums = new int[] { 0, 0, 0 };
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

  }
}