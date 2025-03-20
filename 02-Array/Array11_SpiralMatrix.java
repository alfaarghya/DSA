/*
LC54: Spiral Matrix || https://leetcode.com/problems/spiral-matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100


 */

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

  // Time Complexity: O(m*n) || Space Complexity: O(m+n)
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();

    int startRow = 0, endRow = matrix.length - 1;
    int startColumn = 0, endColumn = matrix[0].length - 1;

    while (startRow <= endRow && startColumn <= endColumn) {
      // travel top boundary
      for (int j = startColumn; j <= endColumn; j++) {
        list.add(matrix[startRow][j]);
      }

      // travel right boundary
      for (int i = startRow + 1; i <= endRow; i++) {
        list.add(matrix[i][endColumn]);
      }

      // travel bottom boundary
      for (int j = endColumn - 1; j >= startColumn; j--) {
        if (startRow == endRow) {
          break;
        }
        list.add(matrix[endRow][j]);
      }

      // travel left boundary
      for (int i = endRow - 1; i >= startRow + 1; i--) {
        if (startColumn == endColumn) {
          break;
        }
        list.add(matrix[i][startColumn]);
      }

      // update rows & columns
      startRow++;
      endRow--;
      startColumn++;
      endColumn--;
    }

    return list;
  }
}

public class Array11_SpiralMatrix {
  public static void main(String[] args) {
    SpiralMatrix obj = new SpiralMatrix();

    // example 1
    System.out.println("---- example 1 ----");
    int[][] data1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    System.out.println(obj.spiralOrder(data1));

    // example 2
    System.out.println("---- example 2 ----");
    int[][] data2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
    System.out.println(obj.spiralOrder(data2));
  }
}
