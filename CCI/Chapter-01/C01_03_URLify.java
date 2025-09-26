/*
  URLify: Write a method to replace all white-spaces in a string with %20. 
  You may assumed that every string have sufficient spaces at the end to hold the characters 
  and that you are given the "true" length of the string.
  
  Examples:

  input: "Mr John Smith    ", 13
  output: "Mr%20John%20Smith"
  
 */

import java.util.Arrays;

class Solution {
    /** ----------- My Solutions ----------- **/
    // TC => O(n) || SC => O(n), where n is size of str
    public String solution1(String str) {
        StringBuilder newStr = new StringBuilder("");

        // trim white-spaces at the beginning and end
        str = str.trim();

        // iterate over the string
        for (char ch : str.toCharArray()) {
            // found space
            if (ch == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(ch);
            }
        }

        return newStr.toString();
    }

    /** ----------- Book Solutions ----------- **/
    // TC => O(m) || SC => O(1), where m = trueLength
    public String solution2(char[] str, int trueLength) {
        int spaceCount = 0;
        // count white spaces
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;
        if (trueLength < str.length)
            str[trueLength] = '\0'; // end array

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';

                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        return Arrays.toString(str);
    }

}

public class C01_03_URLify {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str1;

        // example 1
        System.out.println("---- Example 1 ----");
        str1 = "Mr John Smith    ";
        System.out.println(obj.solution1(str1));
        System.out.println(obj.solution2(str1.toCharArray(), 13));

    }
}