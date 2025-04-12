/*
LC74: Search a 2D Matrix || https://leetcode.com/problems/search-a-2d-matrix


You are given an m x n integer matrix matrix with the following two properties:

    + Each row is sorted in non-decreasing order.
    + The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 

Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104
 */

class Search2DMatrix {
  // Binary Search on 2D matrix
  // TC => O(log(m*n)) || SC => O(1)
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;

    // two pointers
    int start = 0, end = m * n - 1;
    int mid = 0;

    while (start <= end) {
      mid = start + (end - start) / 2;
      int midValue = matrix[mid / n][mid % n];

      if (target == midValue) {
        return true;
      } else if (target < midValue) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return false;
  }

}

public class Array21_Search2DMatrix {
  public static void main(String[] args) {
    Search2DMatrix obj = new Search2DMatrix();

    // example 1
    System.out.println("---- example 1 ----");
    int[][] matrix1 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    int target1 = 3;
    System.out.println(obj.searchMatrix(matrix1, target1));

    // example 2
    System.out.println("---- example 2 ----");
    int[][] matrix2 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    int target2 = 7;
    System.out.println(obj.searchMatrix(matrix2, target2));
  }
}
