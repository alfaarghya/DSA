/*
LC238: Product of Array Except Self || https://leetcode.com/problems/product-of-array-except-self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

class ProductOfArrayExpectSelf {
  // Brute Force => Time Complexity: O(n^2) || Space Complexity: O(1)
  public int[] approach1(int[] arr) {
    // create a ans array and fill with 1
    int n = arr.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = 1;
    }

    // calculate the product
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) {
          ans[i] *= arr[j];
        }
      }
    }

    return ans;
  }

  // Prefix & Suffix
  // Time Complexity: O(n) || Space Complexity: O(n)
  public int[] approach2(int[] arr) {
    int n = arr.length;
    int[] prefix = new int[n];
    int[] suffix = new int[n];

    // calculate prefix product
    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * arr[i - 1];
    }

    // calculate suffix product
    suffix[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * arr[i + 1];
    }

    // calculate the product
    for (int i = 0; i < n; i++) {
      arr[i] = prefix[i] * suffix[i];
    }

    return arr;
  }

  // Prefix & Suffix - optimal
  // Time Complexity: O(n) || Space Complexity: O(1)
  public int[] approach3(int[] arr) {
    int n = arr.length;
    int[] ans = new int[n];

    // prefix product calculate
    ans[0] = 1;
    for (int i = 1; i < n; i++) {
      ans[i] = ans[i - 1] * arr[i - 1];
    }

    // suffix product calculate & store it on ans
    int suffix = 1;
    for (int i = n - 2; i >= 0; i--) {
      suffix *= arr[i + 1];
      ans[i] *= suffix;
    }

    return ans;
  }

  public void print(int[] arr) {
    System.out.print("[");
    for (int x : arr) {
      System.out.print(" " + x + " ");
    }
    System.out.print("]\n");
  }
}

public class Array07_ProductOfArrayExpectSelf {
  public static void main(String[] args) {
    ProductOfArrayExpectSelf obj = new ProductOfArrayExpectSelf();

    // example 1
    System.out.println("---- example 1 ----");
    int[] data1 = { 1, 2, 3, 4 };
    // obj.print(obj.approach1(data1));
    // obj.print(obj.approach2(data1));
    obj.print(obj.approach3(data1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] data2 = { -1, 1, 0, -3, 3 };
    // obj.print(obj.approach1(data2));
    // obj.print(obj.approach2(data2));
    obj.print(obj.approach3(data2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] data3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
    // obj.print(obj.approach1(data3));
    // obj.print(obj.approach2(data3));
    obj.print(obj.approach3(data3));
  }
}