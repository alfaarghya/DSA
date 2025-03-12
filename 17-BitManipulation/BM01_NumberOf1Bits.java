/*
LC191: Number of 1 Bits || https://leetcode.com/problems/number-of-1-bits

Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).


Example 1:
Input: n = 11
Output: 3
Explanation: The input binary string 1011 has a total of three set bits.

Example 2:
Input: n = 128
Output: 1
Explanation: The input binary string 10000000 has a total of one set bit.

Example 3:
Input: n = 2147483645
Output: 30
Explanation: The input binary string 1111111111111111111111111111101 has a total of thirty set bits.


Constraints:
1 <= n <= 231 - 1
 

Follow up: If this function is called many times, how would you optimize it?
 */

class NumberOf1Bits {

  // Time Complexity: O(log n) || Space Complexity: O(1)
  public int approach1(int n) {
    // count the 1 bits
    int count = 0;

    while (n != 0) {
      // check if bit is 1
      if (n % 2 == 1) {
        count++;
      }
      // update n
      n /= 2;
    }

    return count;
  }

  // Time Complexity: O(log n) || Space Complexity: O(1)
  public int approach2(int n) {
    // count the 1 bits
    int count = 0;

    while (n != 0) {
      // check if bit is 1 & update count
      count += n & 1;
      // shift the bits
      n >>>= 1;
    }

    return count;
  }
}

public class BM01_NumberOf1Bits {
  public static void main(String[] args) {
    NumberOf1Bits obj = new NumberOf1Bits();

    // example 1
    System.out.println("---- example 1 ----");
    int n1 = 12;
    System.out.println(obj.approach1(n1));
    System.out.println(obj.approach2(n1));

    // example 2
    System.out.println("---- example 2 ----");
    int n2 = 13;
    System.out.println(obj.approach1(n2));
    System.out.println(obj.approach2(n2));

    // example 3
    System.out.println("---- example 3 ----");
    int n3 = 8;
    System.out.println(obj.approach1(n3));
    System.out.println(obj.approach2(n3));

    // example 4
    System.out.println("---- example 4 ----");
    int n4 = 32;
    System.out.println(obj.approach1(n4));
    System.out.println(obj.approach2(n4));

    // example 5
    System.out.println("---- example 5 ----");
    int n5 = 128;
    System.out.println(obj.approach1(n5));
    System.out.println(obj.approach2(n5));

    // example 6
    System.out.println("---- example 6 ----");
    int n6 = 2147483645;
    System.out.println(obj.approach1(n6));
    System.out.println(obj.approach2(n6));
  }
}