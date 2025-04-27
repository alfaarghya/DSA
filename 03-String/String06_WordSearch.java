/*
LC79: Word Search || https://leetcode.com/problems/word-search/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 

Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.

 */

class WordSearch {

    // Time complexity: O(m*n*4^k) -> all 4 direction
    // Space complexity: O(m*n);
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n]; // store which place we visited

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // word's first char is same as board[i][j]
                if (word.charAt(0) == board[i][j]) {
                    if (helper(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int idx) {
        // base case
        if (idx == word.length()) {
            return true;
        }

        // check limits, visited & same character
        if ((0 > i || i >= board.length)
                || (0 > j || j >= board[0].length)
                || visited[i][j]
                || word.charAt(idx) != board[i][j]) {
            return false;
        }

        // mark as visited
        visited[i][j] = true;
        idx++;

        if (helper(board, word, visited, i - 1, j, idx) || // left
                helper(board, word, visited, i + 1, j, idx) || // right
                helper(board, word, visited, i, j - 1, idx) || // top
                helper(board, word, visited, i, j + 1, idx) // bottom
        ) {
            return true;
        }

        // no match

        visited[i][j] = false; // bakctrack

        return false;
    }
}

public class String06_WordSearch {
    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {
                { 'A', 'B', 'C', 'E', 'L', 'K' },
                { 'Z', 'N', 'Z', 'D', 'D', 'J' },
                { 'O', 'Y', 'M', 'E', 'C', 'I' },
                { 'P', 'N', 'X', 'F', 'H', 'B' },
                { 'O', 'Q', 'Y', 'G', 'I', 'A' },
        };

        //example 1
        System.out.println("---- example 1 ----");
        String word1 = "EFGI";
        System.out.println(obj.exist(board, word1));

        //example 2
        System.out.println("---- example 2 ----");
        String word2 = "DDN";
        System.out.println(obj.exist(board, word2));

        //example 3
        System.out.println("---- example 3 ----");
        String word3 = "EFEFG";
        System.out.println(obj.exist(board, word3));
    }
}