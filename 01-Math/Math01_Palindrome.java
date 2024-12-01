/*
LC-09
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

public class Math01_Palindrome {

    public static boolean approach1(int x) { // TC -> O(n) || SC -> O(1)
        int number = x;
        int n = 0;
        while (number > 0) {
            int reminder = number % 10;
            number /= 10;
            n = n * 10 + reminder;
        }

        if (n == x) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean approach2(int x) {
        String str = Integer.toString(x);
        int n = str.length();

        for (int i = 0; i < n / 2; i++) { // TC -> O(n) || SC -> O(1)
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean approach3(int x) { // TC -> O(n) || SC -> O(1)
        int reverse = 0;
        int original = x;

        while (original > 0) {
            reverse = reverse * 10 + original % 10;
            original /= 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        int x1 = 121;
        int x2 = -121;
        int x3 = 10;

        System.out.println(approach1(x2));
        System.out.println(approach2(x2));
        System.out.println(approach3(x2));
    }
}
