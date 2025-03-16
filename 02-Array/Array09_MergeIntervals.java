/*
LC56: Merge Intervals || https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
  // Approach 1
  // Time Complexity: O(n log(n)) || Space complexity: O(n)
  public int[][] approach1(int[][] intervals) {
    // sorting the array
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // ans to store the final ans
    List<int[]> ans = new ArrayList<>();
    // prev to store previous interval or just updated intervals
    int[] prev = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      // check if previous[1] is greater than current[0]
      if (prev[1] >= interval[0]) {
        // true -> check which one is large between previous[1] or current[1]
        prev[1] = Math.max(prev[1], interval[1]);
      } else {
        // false-> it's time to store prev on ans & re-initialize prev with current
        ans.add(prev);
        prev = interval;
      }
    }

    // store the last data on ans
    ans.add(prev);

    return ans.toArray(new int[ans.size()][]);
  }

  // Approach 2 - In place Merging (optimizing space)
  // Time Complexity: O(n log(n)) || Space complexity: O(n)
  public int[][] approach2(int[][] intervals) {
    // sorting the array
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // keep track of the index where we last update
    int k = 0;

    for (int i = 1; i < intervals.length; i++) {
      // check if previous[1] is greater than current[0]
      if (intervals[k][1] >= intervals[i][0]) {
        // true -> check which one is large between previous[1] or current[1]
        intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
      } else {
        // false-> it's time to update the k
        k++;
        intervals[k] = intervals[i];
      }
    }

    return Arrays.copyOfRange(intervals, 0, k + 1);
  }

  public void print(int[][] arr) {
    System.out.print("[");

    for (int[] x : arr) {
      System.out.print("[" + x[0] + "," + x[1] + "]");
    }

    System.out.print("]\n");
  }
}

public class Array09_MergeIntervals {
  public static void main(String[] args) {
    MergeIntervals obj = new MergeIntervals();

    // example 1
    System.out.println("---- example 1 ----");
    int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    obj.print(obj.approach1(intervals1));
    obj.print(obj.approach2(intervals1));

    // example 2
    System.out.println("---- example 2 ----");
    int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
    obj.print(obj.approach1(intervals2));
    obj.print(obj.approach2(intervals2));

    // example 3
    System.out.println("---- example 3 ----");
    int[][] intervals3 = { { 1, 3 }, { 2, 6 }, { 3, 7 }, { 8, 10 }, { 15, 18 }, { 3, 6 } };
    obj.print(obj.approach1(intervals3));
    obj.print(obj.approach2(intervals3));
  }
}
