/*
LC62: Unique Paths || https://leetcode.com/problems/unique-paths


There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 
Constraints:
    1 <= m, n <= 100
 */

class UniquePaths {
  // Time complexity: O(m*n) || Space Complexity: O(m*n)
  public int approach1_tabulation(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }

      }
    }

    return dp[m - 1][n - 1];
  }

  // Time complexity: O(m*n) || Space Complexity: O(m*n)
  public int approach2_memoization(int m, int n) {
    int[][] dp = new int[m][n];

    // fill up with -1
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }

    return helper(m - 1, n - 1, dp);
  }

  private int helper(int i, int j, int[][] dp) {
    // base case -> 1st row or 1st col set it to 1
    if (i == 0 || j == 0) {
      return 1;
    }

    // value already calculated
    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    dp[i][j] = helper(i, j - 1, dp) + helper(i - 1, j, dp);
    return dp[i][j];
  }
}

public class DP02_UniquePaths {
  public static void main(String[] args) {
    UniquePaths obj = new  UniquePaths();

    //example 1
    System.out.println("---- example 1 ----");
    int m1 = 3, n1 = 4;
    System.out.println(obj.approach1_tabulation(m1, n1));
    System.out.println(obj.approach2_memoization(m1, n1));

    //example 2
    System.out.println("---- example 2 ----");
    int m2 = 3, n2 = 2;
    System.out.println(obj.approach1_tabulation(m2, n2));
    System.out.println(obj.approach2_memoization(m2, n2));

    //example 3
    System.out.println("---- example 3 ----");
    int m3 = 3, n3 = 7;
    System.out.println(obj.approach1_tabulation(m3, n3));
    System.out.println(obj.approach2_memoization(m3, n3));
  }
}
