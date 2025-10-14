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
  // Time complexity: O(n) || Space complexity: O(1)
  public double solution1(double x, int n) {
    double ans = 1.0;

    for (int i = 0; i < n; i++) {
      ans *= x;
    }

    return n < 0 ? 1.0 / ans : ans;
  }

  // Time complexity: O(log n) || Space complexity: O(log n)
  public double solution2(double x, int n) {
    return n < 0 ? 1 / pow(x, -n) : pow(x, n);
  }

  private double pow(double x, long n) {
    // base class
    if (n == 0) {
      return 1;
    }
    /* Logic */
    double val = pow(x, n / 2);
    val = val * val;

    return n % 2 == 0 ? val : x * val;
  }

  // Time complexity: O(log(n)) || Space complexity: O(1)
  public double solution3(double x, int n) {
    // corner case
    if (n == 0) {
      return 1;
    }

    // get the positive value
    long N = n;
    if (N < 0) {
      N = -1 * N;
    }
    double ans = 1.0;

    // calculate the X^n
    while (N > 0) {
      if (N % 2 == 0) { // even case => X^n = (X^2)^(n/2)
        x = x * x;
        N = N / 2;
      } else { // odd case => X^n = X*X^(n-1)
        ans = ans * x;
        N = N - 1;
      }
    }

    return n < 0 ? (double) 1.0 / (double) ans : ans;
  }
}

public class Math04_Pow {
  public static void main(String[] args) {
    Pow obj = new Pow();
    double x;
    int n;

    // example 1
    System.out.println("----- example 1 -----");
    x = 1;
    n = 10;
    System.out.println(obj.solution1(x, n));
    System.out.println(obj.solution2(x, n));
    System.out.println(obj.solution3(x, n));

    // example 2
    System.out.println("----- example 2 -----");
    x = -2;
    n = 5;
    System.out.println(obj.solution1(x, n));
    System.out.println(obj.solution2(x, n));
    System.out.println(obj.solution3(x, n));

    // example 3
    System.out.println("----- example 3 -----");
    x = 2;
    n = -5;
    System.out.println(obj.solution1(x, n));
    System.out.println(obj.solution2(x, n));
    System.out.println(obj.solution3(x, n));

    // example 4
    System.out.println("----- example 3 -----");
    x = 2;
    n = -254697;
    System.out.println(obj.solution1(x, n));
    System.out.println(obj.solution2(x, n));
    System.out.println(obj.solution3(x, n));
  }
}