/*
LC198: House Robber || https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

class HouseRobber {
  // Base DP approach
  // Time complexity: O(n) || Space Complexity: O(n)
  public int approach1(int[] houses) {
    int n = houses.length;

    // only 1 house is there
    if (n == 1) {
      return houses[0];
    }

    // only 2 houses is there
    if (n == 2) {
      Math.max(houses[0], houses[1]);
    }

    // create dp to calculate the max profit
    int[] dp = new int[n];

    // fill up base case data;
    dp[0] = houses[0];
    dp[1] = Math.max(houses[0], houses[1]);

    // loop => i = 2 -> n-1
    for (int i = 2; i < n; i++) {
      /*
       * found max profit on last i-1 combination OR last i-2 combination + current
       * house
       */
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
    }

    // return the max profit
    return dp[n - 1];
  }

  // Base DP optimal space approach
  // Time complexity: O(n) || Space Complexity: O(1)
  public int approach2(int[] houses) {
    int n = houses.length;

    // only 1 house is there
    if (n == 1) {
      return houses[0];
    }

    // only 2 houses is there
    if (n == 2) {
      Math.max(houses[0], houses[1]);
    }

    // create const variable to calculate the max profit
    int prevRob = houses[0];
    int maxRob = Math.max(houses[0], houses[1]);

    // loop => i = 2 -> n-1
    for (int i = 2; i < n; i++) {
      /*
       * found max profit on last i-1 combination OR last i-2 combination + current
       * house
       */
      int newRob = Math.max(maxRob, prevRob + houses[i]);
      prevRob = maxRob;
      maxRob = newRob;
    }

    // return the max profit
    return maxRob;
  }
}

public class DP01_HouseRobber {
  public static void main(String[] args) {
    HouseRobber obj = new HouseRobber();

    // example 1
    System.out.println("---- Example 1 ----");
    int[] houses1 = { 1, 2, 3, 1 };
    System.out.println(obj.approach1(houses1));
    System.out.println(obj.approach2(houses1));

    // example 2
    System.out.println("---- Example 2 ----");
    int[] houses2 = { 2, 7, 9, 3, 1 };
    System.out.println(obj.approach1(houses2));
    System.out.println(obj.approach2(houses2));

    // example 3
    System.out.println("---- Example 3 ----");
    int[] houses3 = { 2, 1, 1, 2, 2, 7, 3, 9, 1 };
    System.out.println(obj.approach1(houses3));
    System.out.println(obj.approach2(houses3));

    // example 4
    System.out.println("---- Example 4 ----");
    int[] houses4 = { 2, 1, 1, 2, 7, 3, 9 };
    System.out.println(obj.approach1(houses4));
    System.out.println(obj.approach2(houses4));

    // example 5
    System.out.println("---- Example 5 ----");
    int[] houses5 = { 12 };
    System.out.println(obj.approach1(houses5));
    System.out.println(obj.approach2(houses5));

    // example 6
    System.out.println("---- Example 6 ----");
    int[] houses6 = { 12, 11 };
    System.out.println(obj.approach1(houses6));
    System.out.println(obj.approach2(houses6));
  }
}