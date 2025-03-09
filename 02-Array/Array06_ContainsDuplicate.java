/*
LC217: Contains Duplicate || https://leetcode.com/problems/contains-duplicate/

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 
Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class ContainsDuplicate {

  // Brute Force Approach
  // Time Complexity: O(n^2) || Space Complexity: O(1)
  public boolean approach1(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          return true;
        }
      }
    }

    return false;
  }

  // Sort Approach
  // Time Complexity: O(n log(n)) || Space Complexity: O(1)
  public boolean approach2(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        return true;
      }
    }

    return false;
  }

  // HashSet Approach
  // Time Complexity: O(n) || Space Complexity: O(n)
  public boolean approach3(int[] arr) {
    HashSet<Integer> set = new HashSet<>();

    for (int key : arr) {
      if (set.contains(key)) {
        return true;
      } else {
        set.add(key);
      }
    }

    return false;
  }

  // HashMap Approach
  // Time Complexity: O(n) || Space Complexity: O(n)
  public boolean approach4(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int key : arr) {
      if (map.containsKey(key) && map.get(key) > 1) {
        return true;
      } else {
        map.put(key, map.getOrDefault(key, 1) + 1);
      }
    }

    return false;
  }
}

public class Array06_ContainsDuplicate {
  public static void main(String[] args) {
    ContainsDuplicate obj = new ContainsDuplicate();

    // example 1
    System.out.println("---- example 1 ----");
    int[] data1 = { 1, 2, 3, 1 };
    System.out.println(obj.approach1(data1));
    System.out.println(obj.approach2(data1));
    System.out.println(obj.approach3(data1));
    System.out.println(obj.approach4(data1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] data2 = { 1, 2, 3, 4 };
    System.out.println(obj.approach1(data2));
    System.out.println(obj.approach2(data2));
    System.out.println(obj.approach3(data2));
    System.out.println(obj.approach4(data2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] data3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
    System.out.println(obj.approach1(data3));
    System.out.println(obj.approach2(data3));
    System.out.println(obj.approach3(data3));
    System.out.println(obj.approach4(data3));
  }
}