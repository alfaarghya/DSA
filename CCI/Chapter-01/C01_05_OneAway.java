/*
  One Away: There are three types of edits that can be performed on strings. 
  Insert a character, remove a character, or replace a character.
  Given two strings write a function to check if they are one edit(or zero edits) away.
  
  Example 1:
  input: "pale" "ple"
  output: true
  
  Example 2:
  input: "pales" "pale"
  output: true
  
  Example 3:
  input: "pale" "bale"
  output: true
  
  Example 4:
  input: "pale" "bake"
  output: false
  
 */

class Solution {
    /** ----------- My Solutions ----------- **/

    // TC => O(n) || SC => O(1)
    public boolean solution1(String str1, String str2) {
        if (str1.length() == str2.length()) { // replace case
            return oneEditReplace(str1, str2);
        } else if (str1.length() + 1 == str2.length()) { // insert case
            return oneEditInsertOrRemove(str1, str2);
        } else if (str1.length() - 1 == str2.length()) { // remove case
            return oneEditInsertOrRemove(str2, str1);
        }

        return false;
    }

    private boolean oneEditReplace(String str1, String str2) {
        boolean oneEdit = true;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {

                // more edit found
                if (!oneEdit) {
                    return false;
                }

                oneEdit = false;
            }
        }

        return true;
    }

    private boolean oneEditInsertOrRemove(String str1, String str2) {
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (i != j) {
                    return false;
                }
                j++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    /** ----------- Book Solutions ----------- **/

    public boolean solution2(String str1, String str2) {
        // check length
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        // get largest & short strings
        String shortStr = str1.length() < str2.length() ? str1 : str2;
        String largeStr = str1.length() < str2.length() ? str2 : str1;

        int i = 0, j = 0;
        boolean oneEdit = true;
        while (i < shortStr.length() && j < largeStr.length()) {
            if (shortStr.charAt(i) != largeStr.charAt(j)) {

                // replace case
                if (!oneEdit) {
                    return false;
                }
                oneEdit = false;

                // on replace move shorter pointer
                if (shortStr.length() == largeStr.length()) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

}

public class C01_05_OneAway {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str1, str2;

        // example 1
        System.out.println("---- Example 1 ----");
        str1 = "pale";
        str2 = "ple";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 2
        System.out.println("---- Example 2 ----");
        str1 = "pales";
        str2 = "pale";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 3
        System.out.println("---- Example 3 ----");
        str1 = "pale";
        str2 = "bale";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 4
        System.out.println("---- Example 4 ----");
        str1 = "pale";
        str2 = "bake";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

        // example 5
        System.out.println("---- Example 5 ----");
        str1 = "ppppp";
        str2 = "pp";
        System.out.println(obj.solution1(str1, str2));
        System.out.println(obj.solution2(str1, str2));

    }
}