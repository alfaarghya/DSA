/*
LC50: Pow(x, n) || https://leetcode.com/problems/powx-n/

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

 

Constraints:

    -100.0 < x < 100.0
    -2^31 <= n <= 2^31-1
    n is an integer.
    Either x is not zero or n > 0.
    -10^4 <= x^n <= 10^4

 */

class Pow {
  //Time complexity: O(log n) || Space complexity: O(log n)
  public double myPow(double x, int n) {
    return n < 0 ? 1 / pow(x, -n) : pow(x, n);
  }

  public double pow(double x, long n) {
    // base class
    if (n == 0) {
      return 1;
    }
    /* Logic */
    double val = pow(x, n / 2);
    val = val * val;

    return n % 2 == 0 ? val : x * val;
  }
}

public class RB06_Pow {
  public static void main(String[] args) {
    Pow obj = new Pow();
    double x;
    int n;

    //example 1
    System.out.println("----- example 1 -----");
    x = 1;
    n = 10;
    System.out.println(obj.myPow(x, n));
    
    //example 2
    System.out.println("----- example 2 -----");
    x = -2;
    n = 5;
    System.out.println(obj.myPow(x, n));
    
    //example 3
    System.out.println("----- example 3 -----");
    x = 2;
    n = -5;
    System.out.println(obj.myPow(x, n));
    
    //example 4
    System.out.println("----- example 3 -----");
    x = 2;
    n = -254697;
    System.out.println(obj.myPow(x, n));
  }
}