/*
  Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, 
  it's entire row and column are set 0.
 
 Full Solution: DSA/02-Array/Array12_SetMAtrixZeros.java
  */

class Solution {
    /** ----------- My Solutions ----------- **/

    // TC => O(m*n) || SC => O(1)
    public int[][] solution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isZeroFirstRow = false, isZeroFirstCol = false;

        // check zero in first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isZeroFirstRow = true;
                break;
            }
        }

        // check zero in first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isZeroFirstRow = true;
                break;
            }
        }

        // put zeros on first row & col based of current element
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // put zero based on first row or column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // put zeros on first row
        if (isZeroFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // put zeros on first col
        if (isZeroFirstCol) {
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

    /** ----------- Book Solutions ----------- **/

}

public class C01_08_ZeroMatrix {

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] matrix;

        // example 1
        System.out.println("---- Example 1 ----");
        matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        obj.printMatrix(obj.solution(matrix));

        // example 2
        System.out.println("---- Example 2 ----");
        matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        obj.printMatrix(obj.solution(matrix));

        // example 3
        System.out.println("---- Example 3 ----");
        matrix = new int[][] { { 0, 1, 2, 0, 3 }, { 3, 4, 5, 2, 1 }, { 0, 1, 3, 1, 5 } };
        obj.printMatrix(obj.solution(matrix));

    }
}