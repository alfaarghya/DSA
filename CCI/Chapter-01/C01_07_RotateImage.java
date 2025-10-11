/*
  Rotate Image: Given an image represented by an NxN matrix, where each pixel
  in the image is 4 bytes, write a method to rotate the image by 90 degrees.
  Can you do it in place?
 */

import java.util.Arrays;

class Solution {
    /** ----------- My Solutions ----------- **/
    // TC => O(n*n) || SC => O(1), where n = size of matrix[0]
    public int[][] solution1(int[][] matrix) {
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
    /** ----------- Book Solutions ----------- **/

}

public class C01_07_RotateImage {

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] matrix;

        // example 1
        System.out.println("---- Example 1 ----");
        matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        obj.printMatrix(obj.solution1(matrix));

        // example 2
        System.out.println("---- Example 2 ----");
        matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        ;
        obj.printMatrix(obj.solution1(matrix));

        // example 3
        System.out.println("---- Example 3 ----");
        matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        obj.printMatrix(obj.solution1(matrix));

    }
}