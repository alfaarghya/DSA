/*
Is Unique: Implement an algorithm to determine if a string has all unique characters, 
what if you cannot use additional data structure?
 */

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    /** ----------- My Solutions ----------- **/
    /* Without additional data structure */
    // TC => O(n^2) || SC => O(1), where n is size of string
    public boolean solution1(String str) {
        int n = str.length();

        // for each character go through the loop to check any duplicates
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /* With additional data structure */
    // TC => O(n) || SC => O(n), where n is size of string
    public boolean solution2(String str) {
        // Store characters into hash set, so that we can found duplicate characters
        HashSet<Character> set = new HashSet<>();

        for (char character : str.toCharArray()) {
            if (set.contains(character)) {
                return false;
            }

            set.add(character);
        }

        return true;
    }

    /* With additional data structure */
    // TC => O(n*log(n)) || SC => O(n), where n is size of string
    public boolean solution3(String str) {
        // sort the char array
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);

        for (int i = 0; i < strArr.length - 1; i++) {
            if (strArr[i] == strArr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /** ----------- Book Solutions ----------- **/
    /* With additional data structure */

    // ONLY VALID FOR ASCII Characters
    public boolean solution4(String str) {
        // only 128 unique ASCII char are present, so if our string size exceed 128 then
        // we must ave duplicates
        if (str.length() > 128) {
            return false;
        }

        boolean[] ascii = new boolean[128]; // only 128 ASCII char are present

        for (char ch : str.toCharArray()) {
            if (ascii[ch - ' ']) {
                return false;
            }

            ascii[ch - ' '] = true;
        }

        return true;
    }

    // ONLY VALID FOR LOWERCASE ASCII Characters
    // public boolean solution5(String str) {
    // }

}

public class C01_01_IsUnique {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str;

        // example 1
        System.out.println("---- Example 1 ----");
        str = "hii";
        System.out.println(obj.solution1(str));
        System.out.println(obj.solution2(str));
        System.out.println(obj.solution3(str));
        // example 2
        System.out.println("---- Example 2 ----");
        str = "abcezxiyupe";
        System.out.println(obj.solution1(str));
        System.out.println(obj.solution2(str));
        System.out.println(obj.solution3(str));
        // example 3
        System.out.println("---- Example 3 ----");
        str = "Alfa";
        System.out.println(obj.solution1(str));
        System.out.println(obj.solution2(str));
        System.out.println(obj.solution3(str));
        // example 4
        System.out.println("---- Example 4 ----");
        str = "ab123mnc";
        System.out.println(obj.solution1(str));
        System.out.println(obj.solution2(str));
        System.out.println(obj.solution3(str));
    }
}