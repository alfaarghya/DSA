/*
LC11: Container With Most Water || https://leetcode.com/problems/container-with-most-water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

 

Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
 */

class ContainerWithMostWater {
  // approach 1 - brute force
  // Time Complexity: O(n^2) || Space complexity: O(1)
  public int approach1(int[] height) {
    // variable to store maximum water
    int max = 0;
    int n = height.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        // calculating area = height x width
        int area = Math.min(height[i], height[j]) * Math.abs(j - i);
        // get or set maximum water
        max = Math.max(max, area);
      }
    }

    return max;
  }

  // approach 2 - two pointers (Optimal)
  // Time complexity: O(n) || Space complexity: O(1)
  public int approach2(int[] height) {
    // variable to store maximum water
    int max = 0;
    // two pointers
    int left = 0, right = height.length - 1;

    while (left < right) {
      // calculating area
      int ht = Math.min(height[left], height[right]); // height will be the minimum one
      int width = Math.abs(right - left);
      int area = ht * width;

      // get or set maximum water
      max = Math.max(max, area);

      // change the pointers -> which one is minimum change that
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}

public class Array13_ContainerWithMostWater {
  public static void main(String[] args) {
    ContainerWithMostWater obj = new ContainerWithMostWater();

    // example 1
    System.out.println("---- example 1 ----");
    int[] heights1 = { 2, 6, 7, 1, 4, 5, 3, 8, 8 };
    System.out.println(obj.approach1(heights1));
    System.out.println(obj.approach2(heights1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] heights2 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    System.out.println(obj.approach1(heights2));
    System.out.println(obj.approach2(heights2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] heights3 = { 1, 1 };
    System.out.println(obj.approach1(heights3));
    System.out.println(obj.approach2(heights3));
  }
}
