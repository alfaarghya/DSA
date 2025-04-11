/*
LC200: Number of Islands || https://leetcode.com/problems/number-of-islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
 */

class NumberOfIslands {
  // Time Complexity => O(m * n) || Space Complexity: O(m * n)
  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int countIsland = 0;
    int m = grid.length, n = grid[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // we found a un visited island
        if (grid[i][j] == '1') {
          countIsland++;
          dfs(i, j, grid);
        }
      }
    }

    return countIsland;
  }

  private void dfs(int i, int j, char[][] grid) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
      return;
    }

    // visit the connected island
    grid[i][j] = '-';

    // go to top
    dfs(i - 1, j, grid);

    // go to bottom
    dfs(i + 1, j, grid);

    // go to left
    dfs(i, j - 1, grid);

    // go to right
    dfs(i, j + 1, grid);
  }
}

public class Array19_NumberOfIslands {
  public static void main(String[] args) {
    NumberOfIslands obj = new NumberOfIslands();

    // example 1
    System.out.println("---- example 1 ----");
    char[][] map1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' } };
    System.out.println(obj.numIslands(map1));

    // example 2
    System.out.println("---- example 2 ----");
    char[][] map2 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
        { '0', '0', '0', '1', '1' } };
    System.out.println(obj.numIslands(map2));
  }
}
