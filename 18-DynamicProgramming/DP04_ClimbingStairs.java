/*
LC70: Climbing Stairs || https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
 */

class ClimbingStairs {

  // Recursion: till n<45 this will work absolutely fine
  // Time Complexity: O(n) || Space Complexity: O(1)
  public int approach1(int n) {
    // base case
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }

    return approach1(n - 1) + approach1(n - 2);
  }

  /*---- Memoization ----- */
  // Time Complexity: O(n) || Space Complexity: O(n)
  public int approach2(int n) {
    int[] dp = new int[n + 1];

    return memoization(n, dp);
  }

  private int memoization(int n, int[] dp) {
    // base case
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else if (dp[n] != 0) {
      return dp[n];
    }

    // store in dp
    dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);

    return dp[n];
  }

  /*---- ---- */

  /*----Tabulation ----*/
  // Time Complexity: O(n) || Space Complexity: O(n)
  public int approach3(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
  /*---- ----*/

}

public class DP04_ClimbingStairs {
  public static void main(String[] args) {
    ClimbingStairs obj = new ClimbingStairs();

    // example 1
    System.out.println("---- Example 1 ----");
    System.out.println(obj.approach1(1));
    System.out.println(obj.approach2(1));
    System.out.println(obj.approach3(1));

    // example 2
    System.out.println("---- Example 2 ----");
    System.out.println(obj.approach1(2));
    System.out.println(obj.approach2(2));
    System.out.println(obj.approach3(2));

    // example 3
    System.out.println("---- Example 3 ----");
    System.out.println(obj.approach1(5));
    System.out.println(obj.approach2(5));
    System.out.println(obj.approach3(5));

    // example 4
    System.out.println("---- Example 4 ----");
    System.out.println(obj.approach1(8));
    System.out.println(obj.approach2(8));
    System.out.println(obj.approach3(8));

    // example 5
    System.out.println("---- Example 5 ----");
    // System.out.println(obj.approach1(45)); // n >= 45, it will take a large time
    System.out.println(obj.approach2(45));
    System.out.println(obj.approach3(45));

  }
}