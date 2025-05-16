/*
LC64: Minimum Path Sum ||https://leetcode.com/problems/minimum-path-sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200
 */

class MinimumPathSum {
  // Time Complexity: O(m*n) || Space Complexity: O(m*n)
  public int minPathSum(int[][] grid) {
    // create dp
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];

    // put grid(0,0) value into dp(0,0)
    dp[0][0] = grid[0][0];

    // fill up first row
    for (int j = 1; j < n; j++) {
      dp[0][j] = grid[0][j] + dp[0][j - 1];
    }

    // fill up first col
    for (int i = 1; i < m; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }

    // calculate minimum path
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    // final answer
    return dp[m - 1][n - 1];
  }
}

public class DP07_MinimumPathSum {
  public static void main(String[] args) {
    MinimumPathSum obj = new MinimumPathSum();
    int[][] grid;

    //example 1
    System.out.println("----- example 1 -----");
    grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
    System.out.println(obj.minPathSum(grid));

    //example 2
    System.out.println("----- example 2 -----");
    grid = new int[][] {{5,4,1},{3,6,2},{5,2,5},{4,7,3},{1,2,10}};
    System.out.println(obj.minPathSum(grid));
  }
}
