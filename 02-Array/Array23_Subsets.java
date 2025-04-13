/*
LC78: Subsets || https://leetcode.com/problems/subsets/

Given an integer array nums of unique elements, return all possible(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

 
Constraints:
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.
 */

import java.util.List;
import java.util.ArrayList;

class Subsets {

  // approach 1 - iterative
  public List<List<Integer>> approach1(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    // add empty subset into ans
    ans.add(subset);

    // find the subsets
    for (int x : nums) {
      int n = ans.size();
      for (int i = 0; i < n; i++) {
        subset = new ArrayList<>(ans.get(i));
        subset.add(x);
        ans.add(new ArrayList<>(subset));
      }
    }

    return ans;
  }

  // approach 2 - backtracking
  // Time complexity: O(2^n) || Space Complexity: O(n)
  public List<List<Integer>> approach2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(0, new ArrayList<>(), ans, nums);
    return ans;
  }

  private void backtrack(int start, List<Integer> subset, List<List<Integer>> ans, int[] nums) {
    ans.add(new ArrayList<>(subset));

    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      backtrack(i + 1, subset, ans, nums);
      subset.remove(subset.size() - 1);
    }
  }
}

public class Array23_Subsets {
  public static void main(String[] args) {
    Subsets obj = new Subsets();

    // example 1
    System.out.println("---- example 1 ----");
    int[] nums1 = { 0 };
    System.out.println(obj.approach1(nums1));
    System.out.println(obj.approach2(nums1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] nums2 = { 1, 2, 3 };
    System.out.println(obj.approach1(nums2));
    System.out.println(obj.approach2(nums2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] nums3 = { 1, 2, 3, 4, 5 };
    System.out.println(obj.approach1(nums3));
    System.out.println(obj.approach2(nums3));
  }
}
