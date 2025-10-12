/*
LC73: Set Matrix Zeroes || https://leetcode.com/problems/set-matrix-zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1

Follow up:

    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SetMatrixZeros {
  // Approach 1
  // Time Complexity: O(m*n) || Space Complexity: O(m*n)
  class Pair {
    int row;
    int column;

    Pair(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }

  public int[][] approach1(int[][] matrix) {
    List<Pair> list = new ArrayList<>();
    int m = matrix.length, n = matrix[0].length;

    // store the row & column index of cell have 0
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          list.add(new Pair(i, j));
        }
      }
    }

    // setting 0 in matrix
    for (Pair pair : list) {
      int row = pair.row, col = pair.column;
      // change on column
      for (int j = 0; j < n; j++) {
        if (matrix[row][j] != 0) {
          matrix[row][j] = 0;
        }
      }

      // change on rows
      for (int i = 0; i < m; i++) {
        if (matrix[i][col] != 0) {
          matrix[i][col] = 0;
        }
      }
    }

    return matrix;
  }

  // Approach 2
  // Time Complexity: O(m*n) || Space Complexity: O(m+n)
  public int[][] approach2(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[] rows = new int[m];
    int[] columns = new int[n];

    // fills rows & columns with 1
    Arrays.fill(rows, 1);
    Arrays.fill(columns, 1);

    // store row & column index of cell have 0
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = 0;
          columns[j] = 0;
        }
      }
    }

    // if row or column have 0 then set 0 in matrix
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rows[i] == 0 || columns[j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    return matrix;
  }

  // approach 3
  // Time Complexity: O(m*n) || Space Complexity: O(1)
  public int[][] approach3(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean isZeroFR = false, isZeroFC = false;

    // check on the first row
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        isZeroFR = true;
        break;
      }
    }

    // check on the first col
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        isZeroFC = true;
        break;
      }
    }

    // make zeros on 0th row & columns
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // make 0th row & col pilar & change all value zero
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // if our 0th row have any zero at first that row will be zero
    if (isZeroFR) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }

    // if our 0th col have any zero at first that col will be zero
    if (isZeroFC) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }

    return matrix;
  }

  public void printMatrix(int[][] matrix) {
    System.out.print("[");
    for (int[] row : matrix) {
      System.out.print("[");
      for (int cell : row) {
        System.out.print(" " + cell + " ");
      }
      System.out.print("]\n");
    }
    System.out.print("]\n");
  }
}

public class Array12_SetMatrixZeros {
  public static void main(String[] args) {
    SetMatrixZeros obj = new SetMatrixZeros();

    // example 1
    System.out.println("---- example 1 ----");
    int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
    // obj.printMatrix(obj.approach1(matrix1));
    // obj.printMatrix(obj.approach2(matrix1));
    obj.printMatrix(obj.approach3(matrix1));

    // example 2
    System.out.println("---- example 2 ----");
    int[][] matrix2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
    // obj.printMatrix(obj.approach1(matrix2));
    // obj.printMatrix(obj.approach2(matrix2));
    obj.printMatrix(obj.approach3(matrix2));
  }
}
