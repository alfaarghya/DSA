/*
LC118: Pascal's Triangle || https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:
    1 <= numRows <= 30
 */

import java.util.List;
import java.util.ArrayList;

class PascalTriangle {
  // Time Complexity: O(n^2) || Space Complexity: O(n)
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = new ArrayList<>();

    // calculate values of each row
    for (int i = 0; i < numRows; i++) {

      // calculate values
      List<Integer> row = new ArrayList<>(); // temprary store
      int val = 1; // first value is always 1
      row.add(val); // store first val

      for (int j = 1; j <= i; j++) {
        val = ((i + 1 - j) * val) / j;
        row.add(val);
      }

      // build pascal triangle
      list.add(row);
    }

    return list;
  }
}

public class Array48_PascalTriangle {
  public static void main(String[] args) {
    PascalTriangle obj = new PascalTriangle();
    int numRows;

    // example 1
    System.out.println("---- example 1 ----");
    numRows = 3;
    System.out.println(obj.generate(numRows));

    // example 2
    System.out.println("---- example 2 ----");
    numRows = 5;
    System.out.println(obj.generate(numRows));

    // example 3
    System.out.println("---- example 3 ----");
    numRows = 11;
    System.out.println(obj.generate(numRows));
  }
}
