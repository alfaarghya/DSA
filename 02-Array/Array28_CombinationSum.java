/*
LC39: Combination Sum || https://leetcode.com/problems/combination-sum/

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the

of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

 

Constraints:

    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40
 */

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
  //Time complexity: O(2^n)
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    helper(candidates, target, 0, new ArrayList<>(), list);
    return list;
  }

  private void helper(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> list) {
    // base case I
    if (target == 0) {
      list.add(new ArrayList<>(combination));
      return;
    }

    // base case II
    if (idx >= candidates.length || target < 0) {
      return;
    }

    // backtracing
    combination.add(candidates[idx]);
    helper(candidates, target - candidates[idx], idx, combination, list);// update target
    combination.remove(combination.size() - 1); // backtracking step
    helper(candidates, target, idx + 1, combination, list);// move forward
  }
}

public class Array28_CombinationSum {
  public static void main(String[] args) {
    CombinationSum obj = new CombinationSum();
    int[] candidates;
    int target;

    // example 1
    System.out.println("----- example 1 -----");
    candidates = new int[] { 5, 3, 8, 2 };
    target = 8;
    System.out.println(obj.combinationSum(candidates, target));

    // example 2
    System.out.println("----- example 2 -----");
    candidates = new int[] { 2, 3, 6, 7 };
    target = 7;
    System.out.println(obj.combinationSum(candidates, target));

    // example 3
    System.out.println("----- example 3 -----");
    candidates = new int[] { 2 };
    target = 1;
    System.out.println(obj.combinationSum(candidates, target));

  }
}
