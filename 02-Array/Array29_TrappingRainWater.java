/*
LC42: Trapping Rain Water || https://leetcode.com/problems/trapping-rain-water


Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

 

Constraints:

    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105
 */

class TrappingRainWater {

  //Time Complexity: O(n) || Space Complexity: O(n)
  public int approach1(int[] height){
    int n = height.length;

    //calculate max left side height boundary for each bar
    int[] maxLeft = new int[n];
    maxLeft[0] = height[0]; //0th bar height it self is the max left side height
    for(int i = 1; i < n; i++) {
      maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
    }

    //calculate max right side height boundary for each bar
    int[] maxRight = new int[n];
    maxRight[n-1] = height[n-1]; //(n-1)th bar height it self is the max right side height
    for(int i = n-2; i >= 0; i--) {
      maxRight[i] = Math.max(height[i], maxRight[i+1]);
    }

    //calculate trapped rain water on top of each bar
    int trappedWater = 0;
    for(int i = 0; i < n; i++) {
      //trapped water on top of each bar = min height - bar's height
      trappedWater += Math.min(maxLeft[i], maxRight[i]) - height[i];
    }

    return trappedWater;
  }
  
  //two pointers
  //Time Complexity: O(n) || Space Complexity: O(1)
  public int approach2(int[] height){
    int start = 0, end = height.length-1;
    int maxLeft = -1; // store left side max height for current bar
    int maxRight = -1; //store right side max height for current bar
    int trappedWater = 0;

    while(start <= end) {
      maxLeft = Math.max(maxLeft, height[start]);
      maxRight = Math.max(maxRight, height[end]);

      if(maxLeft < maxRight) {
        trappedWater += maxLeft - height[start++];
      } else {
        trappedWater += maxRight - height[end--];
      }
    }

    return trappedWater;
  }
}

public class Array29_TrappingRainWater {
  public static void main(String[] args) {
    TrappingRainWater obj = new TrappingRainWater();
    int[] height;

    //example 1
    System.out.println("----- example 1 -----");
    height = new int[] {1,2,3,0,0,3,4,5,0,0,10,1};
    System.out.println(obj.approach1(height));
    System.out.println(obj.approach2(height));

    //example 2
    System.out.println("----- example 2 -----");
    height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(obj.approach1(height));
    System.out.println(obj.approach2(height));

    //example 3
    System.out.println("----- example 3 -----");
    height = new int[] {4,2,0,3,2,5};
    System.out.println(obj.approach1(height));
    System.out.println(obj.approach2(height));
  }
}
