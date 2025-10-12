/*
    String Rotation: Assume you have a method isSubstring which check if one word is a substring of another.
    Given two strings, s1 & s2, write code to check if s2 is a rotation s1 using only one call to isSubstring

    Example: "waterbottle" is rotation of "erbottlewat"
 */

class Solution {
    /** ----------- My Solutions ----------- **/
    // TC => O(1) || SC => O(n+n), where n = str1 length
    public boolean solution(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // example: "waterbottlewaterbottle"
        String stringConcat = str1 + str1;

        // example: now "waterbottlewaterbottle" contains "erbottlewat"
        return isSubString(stringConcat, str2);
    }

    private boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

}

public class C01_09_StringRotation {

    public static void main(String[] args) {
        Solution obj = new Solution();
        String str1, str2;

        // example 1
        System.out.println("---- Example 1 ----");
        str1 = "waterbottle";
        str2 = "erbottlewat";
        System.out.println(obj.solution(str1, str2));

        // example 2
        System.out.println("---- Example 2 ----");
        str1 = "alfaarghya";
        str2 = "alfa--devs";
        System.out.println(obj.solution(str1, str2));

        // example 3
        System.out.println("---- Example 3 ----");
        str1 = "abcxyz";
        str2 = "zxabcy";
        System.out.println(obj.solution(str1, str2));

    }
}