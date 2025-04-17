/*
LC36: Valid Sudoku || https://leetcode.com/problems/valid-sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    + Each row must contain the digits 1-9 without repetition.
    + Each column must contain the digits 1-9 without repetition.
    + Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

 

Example 1:

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 

Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit 1-9 or '.'.
 */

 import java.util.HashSet;

class ValidSudoku {

  // Time complexity: O(1) || Space Complexity: O(1)
  public boolean approach1(char[][] board) {
    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[] grid = new HashSet[9];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
      grid[i] = new HashSet<>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];
        if (board[i][j] != '.') {
          int gridIndex = (i / 3) * 3 + (j / 3);

          if (rows[i].contains(ch) || cols[j].contains(ch) || grid[gridIndex].contains(ch)) {
            return false;
          }

          rows[i].add(ch);
          cols[j].add(ch);
          grid[gridIndex].add(ch);
        }
      }
    }

    return true;
  }

  // Time complexity: O(1) || Space Complexity: O(1)
  public boolean approach2(char[][] board) {
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char ch = board[i][j];

        if (ch != '.') {
          // found duplicate values
          if (set.contains(ch + "row" + i) || set.contains(ch + "col" + j)
              || set.contains(ch + "grid" + i / 3 + j / 3)) {
            return false;
          } else {
            set.add(ch + "row" + i);// storing for row
            set.add(ch + "col" + j);// storing for col
            set.add(ch + "grid" + i / 3 + j / 3);// storing for grid
          }
        }
      }
    }

    return true;
  }
}

public class Array26_ValidSudoku {
  public static void main(String[] args) {
    ValidSudoku obj = new ValidSudoku();

    // example 1
    System.out.println("---- example 1 ----");
    char[][] sudoku1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

    System.out.println(obj.approach1(sudoku1));
    System.out.println(obj.approach2(sudoku1));
  }
}
