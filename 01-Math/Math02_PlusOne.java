/*
LC66: Plus One || https://leetcode.com/problems/plus-one


You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

 

Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.
 */

 import java.util.Arrays;

class PlusOne {
  //Time complexity: O(n) || Space complexity: O(n)
  public int[] plusOne(int[] digits) {
    int carry = 0;
    int n = digits.length;

    for(int i = n-1; i >= 0; i--) {
      //calculate the new value and carry
        int plusOne = digits[i] + 1;
        carry = plusOne / 10;
        digits[i] = plusOne % 10;

        //carry is not 1 -> so return the digits
        if(carry == 0) {
            return digits;
        }
    }

    //handle case like -> 999, 99, 9 etc.
    int[] ans = new int[n+1];
    ans[0] = carry;
    return ans;
}
}

public class Math02_PlusOne {
  public static void main(String[] args) {
    PlusOne obj = new PlusOne();
    int[] digits;

    //example 1
    System.out.println("----- example 1 -----");
    digits = new int[] {1,2,1};
    System.out.println(Arrays.toString(obj.plusOne(digits)));

    //example 2
    System.out.println("----- example 2 -----");
    digits = new int[] {1,2,9};
    System.out.println(Arrays.toString(obj.plusOne(digits)));

    //example 3
    System.out.println("----- example 3 -----");
    digits = new int[] {9};
    System.out.println(Arrays.toString(obj.plusOne(digits)));

    //example 4
    System.out.println("----- example 4 -----");
    digits = new int[] {9,9,9,9};
    System.out.println(Arrays.toString(obj.plusOne(digits)));
  }
}
