/*
LC130: Surrounded Regions || https://leetcode.com/problems/surrounded-regions


You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

    Connect: A cell is connected to adjacent cells horizontally or vertically.
    Region: To form a region connect every 'O' cell.
    Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.

To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

 

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 200
    board[i][j] is 'X' or 'O'.
 */

class SurroundedRegions {
    // Time complexity: O(n^2) || Space complexity: O(1)
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        // check first & last row, convert all O -> #
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                helper(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                helper(board, m - 1, j);
            }
        }

        // check first & last col, convert all O -> #
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                helper(board, i, n - 1);
            }
        }

        // final convert, convert O -> X || # -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    // dfs
    private void helper(char[][] board, int i, int j) {
        // corner case
        if ((0 > i || i >= board.length) || (0 > j || j >= board[0].length) || board[i][j] != 'O') {
            return;
        }

        // change O -> #
        board[i][j] = '#';

        helper(board, i - 1, j); // top
        helper(board, i + 1, j); // down
        helper(board, i, j - 1); // left
        helper(board, i, j + 1); // right
    }
}

public class Array46_SurroundedRegions {
    public static void print(char[][] board) {
        System.out.print("[");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.print("]");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        SurroundedRegions obj = new SurroundedRegions();
        char[][] board;

        // example 1
        System.out.println("----- example 1 -----");
        board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        obj.solve(board);
        print(board);

        // example 2
        System.out.println("----- example 2 -----");
        board = new char[][] { { 'X' }, };
        obj.solve(board);
        print(board);

        // example 3
        System.out.println("----- example 3 -----");
        board = new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'O', 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'X', 'X' }, { 'X', 'X', 'O', 'O', 'O', 'O' },
                { 'X', 'X', 'X', 'X', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X' } };
        obj.solve(board);
        print(board);
    }
}
