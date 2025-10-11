/*
LC48: Rotate Image || https://leetcode.com/problems/rotate-image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
*/

class RotateImage {
  // Apprach 1 -> brute force approach
  // Time complexity: O(n*n) || Space complexity: O(n*n)
  public int[][] appraoch1(int[][] matrix) {
    int n = matrix.length;

    // initilize
    int[][] ans = new int[n][n];
    int k = n - 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // rotate
        ans[j][k] = matrix[i][j];
      }

      // decrease the k by 1
      k--;
    }

    return ans;
  }

  // Apprach 2 -> in place change approach
  // Time complexity: O(n*n) || Space complexity: O(1)
  public int[][] appraoch2(int[][] matrix) {
    int n = matrix.length;
    int k = n - 1;

    for (int i = 0; i < (n + 1) / 2; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];

        // rotate
        matrix[i][j] = matrix[k - j][i];
        matrix[k - j][i] = matrix[k - i][k - j];
        matrix[k - i][k - j] = matrix[j][k - i];
        matrix[j][k - i] = temp;
      }
    }

    return matrix;
  }

  // TC => O(n*n) || SC => O(1), where n = size of matrix[0]
  public int[][] approach3(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = matrix[n - 1 - j][i];

        // bottom right -> bottom left
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        // top right -> bottom right
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        // top left -> top right
        matrix[j][n - 1 - i] = matrix[i][j];
        // bottom left -> top right
        matrix[i][j] = temp;
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

public class Array20_RotateImage {
  public static void main(String[] args) {
    RotateImage obj = new RotateImage();

    // example 1
    System.out.println("---- example 1 ----");
    int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    obj.printMatrix(obj.appraoch1(matrix1));
    obj.printMatrix(obj.appraoch2(matrix1));

    // example 2
    System.out.println("---- example 2 ----");
    int[][] matrix2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
    obj.printMatrix(obj.appraoch1(matrix2));
    obj.printMatrix(obj.appraoch2(matrix2));

    // example 3
    System.out.println("---- example 3 ----");
    int[][] matrix3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
    obj.printMatrix(obj.appraoch1(matrix3));
    obj.printMatrix(obj.appraoch2(matrix3));

  }
}
