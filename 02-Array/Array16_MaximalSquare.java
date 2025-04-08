/*
LC221: Maximal Square || https://leetcode.com/problems/maximal-square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0

 

Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is '0' or '1'.
 */

class MaximalSquare {
  // TC => O(m * n) || SC => O(m * n)
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length, n = matrix[0].length;

    // no element
    if (m == 0 || n == 0) {
      return 0;
    }

    // initialize
    int[][] dp = new int[m][n]; // store the side of square
    int side = 0; // store the maximum side we can get

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // when it's 1 calculate the side
        if (matrix[i][j] == '1') {
          // only for first row & column put 1
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            // find the minimum value between (i-1,j-1), (i,j-1), (i-1,j) & increase by 1
            dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
          }

          // keep track of maximum side value
          side = Math.max(side, dp[i][j]);
        }
      }
    }

    // calculate the area of square
    return side * side;
  }
}

public class Array16_MaximalSquare {
  public static void main(String[] args) {
    MaximalSquare obj = new MaximalSquare();

    // example 1
    System.out.println("---- example 1 ----");
    char[][] matrix1 = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' } };
    System.out.println(obj.maximalSquare(matrix1));

    // example 2
    System.out.println("---- example 2 ----");
    char[][] matrix2 = { { '0', '1' }, { '1', '0' } };
    System.out.println(obj.maximalSquare(matrix2));
  }
}
