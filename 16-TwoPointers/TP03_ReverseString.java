/*
LC344: Reverse String || https://leetcode.com/problems/reverse-string

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.


Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
 */

class ReverseString {

  // Time Complexity: o(n) || Space Complexity: O(1)
  public void reverseString(char[] s) {
    int start = 0, end = s.length - 1;

    while (start <= end) {
      // swap
      char temp = s[start];
      s[start] = s[end];
      s[end] = temp;

      // update pointers
      start++;
      end--;
    }

    // additional line -> not a part of code
    print(s);
  }

  private void print(char[] s) {
    System.out.print("[");
    for (char ch : s) {
      System.out.print(" " + ch + " ");
    }
    System.out.print("]\n");
  }
}

public class TP03_ReverseString {
  public static void main(String[] args) {
    ReverseString obj = new ReverseString();

    // example 1
    char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
    obj.reverseString(s1);

    // example 2
    char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
    obj.reverseString(s2);

    // example 3
    char[] s3 = { 'a', 'l', 'f', 'a', 'a', 'r', 'g', 'h', 'y', 'a' };
    obj.reverseString(s3);
  }
}