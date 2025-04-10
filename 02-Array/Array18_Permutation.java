/*
LC46: Permutations || https://leetcode.com/problems/permutations

Given an array nums of distinct integers, return all the possible. You can return the answer in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]


Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */

import java.util.List;
import java.util.ArrayList;

class Permutation {
  // Time Complexity: O(n!) || Space Complexity: O(n)
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, ans, new ArrayList<>());
    return ans;
  }

  private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr) {
    // base case
    if (nums.length == curr.size()) {
      ans.add(new ArrayList<>(curr));
      return;
    }

    // permutations
    for (int i = 0; i < nums.length; i++) {
      if (!curr.contains(nums[i])) {
        // add current value in permutation
        curr.add(nums[i]);
        // recursive call
        backtrack(nums, ans, curr);
        // backtrack call -> remove last element from curr
        curr.remove(curr.size() - 1);
      }
    }
  }
}

public class Array18_Permutation {
  public static void main(String[] args) {
    Permutation obj = new Permutation();

    // example 1
    System.out.println("---- example 1 ----");
    System.out.println(obj.permute(new int[] { 1 }));

    // example 2
    System.out.println("---- example 2 ----");
    System.out.println(obj.permute(new int[] { 1, 2 }));

    // example 3
    System.out.println("---- example 3 ----");
    System.out.println(obj.permute(new int[] { 1, 2, 3 }));

    // example 4
    System.out.println("---- example 4 ----");
    System.out.println(obj.permute(new int[] { 4, 2, 1, 3 }));

    // example 5
    System.out.println("---- example 5 ----");
    System.out.println(obj.permute(new int[] { 2, 1, 5, 3, 4 }));
  }
}
