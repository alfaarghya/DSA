/*
LC289: Game of Life || https://leetcode.com/problems/game-of-life/


According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population.
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.

 

Example 1:

Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

 

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 25
    board[i][j] is 0 or 1.

 

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 */

class GameOfLife {

  // Time complexity: O(m*n) || Space complexity: O(m*n)
  public void gameOfLife(int[][] board) {
    int m = board.length, n = board[0].length;
    int[][] ans = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // count all live neighbours
        int countLive = liveNeighbors(board, i - 1, j - 1) + liveNeighbors(board, i - 1, j) +
            liveNeighbors(board, i - 1, j + 1) + liveNeighbors(board, i, j + 1) +
            liveNeighbors(board, i + 1, j + 1) + liveNeighbors(board, i + 1, j) +
            liveNeighbors(board, i + 1, j - 1) + liveNeighbors(board, i, j - 1);

        // rules
        if (board[i][j] == 1) {
          if (countLive < 2 || countLive > 3) {
            ans[i][j] = 0;
          } else if (countLive == 2 || countLive == 3) {
            ans[i][j] = 1;
          }
        } else {
          if (countLive == 3) {
            ans[i][j] = 1;
          }
        }

      }
    }

    // copy the ans into board
    for (int i = 0; i < m; i++) {
      board[i] = ans[i].clone();
    }
  }

  private int liveNeighbors(int[][] board, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0) {
      return 0;
    }

    return 1;
  }
}

public class Array32_GameOfLife {
  public static void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print("[");
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j]+" ");
      }
      System.out.println("]");
    }
  }
  public static void main(String[] args) {
    GameOfLife obj = new GameOfLife();
    int[][] board;

    //example 1
    System.out.println("----- example 1 -----");
    board = new int[][] {{1,0,0,1}, {0,0,1,0},{1,1,1,0}, {1,0,1,0}, {0,1,1,0}};
    obj.gameOfLife(board);
    printArray(board);

    //example 2
    System.out.println("----- example 2 -----");
    board = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    obj.gameOfLife(board);
    printArray(board);

    //example 3
    System.out.println("----- example 3 -----");
    board = new int[][] {{1,1},{1,0}};
    obj.gameOfLife(board);
    printArray(board);
  }
}
