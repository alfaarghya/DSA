/*
LC09: Palindrome Number || https://leetcode.com/problems/palindrome-number

Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1

 */

class Palindrome{

    // Time complexity -> O(log n) || Space complexity -> O(1)
    public boolean approach1(int x) { 
        int reverse = 0; //store x in reverse order
        int original = x;

        while(original > 0) {
            reverse = reverse*10 + original % 10; // put values in reverse
            original = original/10; //update original
        }

        return reverse == x; //check if palindrome
    }

     // Time complexity -> O(n) || Space complexity -> O(n)
    public boolean approach2(int x) {
        String str = Integer.toString(x); //create string from x
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) { //check ith char & (n-i-1)th char for palindrome
                return false;
            }
        }

        return true; //palindrome
    }
}
 public class Math01_Palindrome {
    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        int x;

        //example 1
        System.out.println("----- example 1 -----");
        x = 5;
        System.out.println(obj.approach1(x));
        System.out.println(obj.approach2(x));

        //example 2
        System.out.println("----- example 2 -----");
        x = 121;
        System.out.println(obj.approach1(x));
        System.out.println(obj.approach2(x));

        //example 3
        System.out.println("----- example 3 -----");
        x = -121;
        System.out.println(obj.approach1(x));
        System.out.println(obj.approach2(x));

        //example 4
        System.out.println("----- example 4 -----");
        x = 1110;
        System.out.println(obj.approach1(x));
        System.out.println(obj.approach2(x));
    }
}
