/*
Check Permutation: Given two string, write a method to decide if one is permutation of the other.
 */

import java.util.HashMap;

//This implementation is case sensitive & also we allowed white spaces,
class Solution {
    /** ----------- My Solutions ----------- **/
    // This Solution is only work for ASCII
    // TC => O(n) || SC => O(1), where n is the size of string
    public boolean solution1(String str1, String str2) {
        // not the same size
        if (str1.length() != str2.length()) {
            return false;
        }

        // store frequency of each character on string
        int[] freq = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - ' ']++; // increase frequency
            freq[str2.charAt(i) - ' ']--; // decrease frequency
        }

        // check if all frequency is zero(0)
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    // This Solution is only work for all UNICODE characters
    // TC => O(n) || SC => O(n), where n is the size of string
    public boolean solution2(String str1, String str2) {
        // not the same size
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char key1 = str1.charAt(i);
            map.put(key1, map.getOrDefault(key1, 0) + 1);// increase frequency

            char key2 = str2.charAt(i);
            map.put(key2, map.getOrDefault(key2, 0) - 1);// decrease frequency
        }

        // check if all values in map is zero(0)
        for (char key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        return true;
    }

    /** ----------- Book Solutions ----------- **/

}

public class C01_02_CheckPermutation {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str1, str2;

        // example 1
        System.out.println("---- Example 1 ----");
        str1 = "xzybca";
        str2 = "mzbcaa";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 2
        System.out.println("---- Example 2 ----");
        str1 = "abcezxiyupe";
        str2 = "hii";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 3
        System.out.println("---- Example 3 ----");
        str1 = "ccv125ad";
        str2 = "1d5acv2c";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 4
        System.out.println("---- Example 4 ----");
        str1 = "God";
        str2 = "dog";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

    }
}
