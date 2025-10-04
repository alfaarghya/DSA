/*
  Palindrome Permutation: Given a String, write a function to check if it is a permutation of a palindrome. 
  A palindrome is the same forwards and backwards. A permutation is a rearrangement of letters. 
  The palindrome does not need to be limited to just  dictionary words.
  
  Examples:

  input: "Tact Coa"
  output: True (permutations: "taco cat", "atco cta", etc)
  
 */

class Solution {
    /** ----------- My Solutions ----------- **/

    // only work for 26 lower characters
    // TC => O(n) || SC => O(1)
    public boolean solution1(String str) {
        // size of string
        int n = 0;

        // count the frequency of all characters
        int[] freq = new int[26];

        // lowercase
        str = str.toLowerCase();

        // count the frequency
        for (char ch : str.toCharArray()) {
            if (!(ch == ' ')) {
                freq[ch - 'a']++;
                n++;
            }
        }

        // EVEN size string
        if (n % 2 == 0) {

            // RULE: must have all even frequency
            for (int x : freq) {
                if (x % 2 == 1) {
                    return false;
                }
            }
        } else { // ODD size string

            // RULE: must have at least 1 char with odd frequency
            int count = 0;
            for (int x : freq) {
                if (x % 2 == 1) {
                    count++;
                }

                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // only work for 26 lower characters
    // TC => O(n) || SC => O(1)
    public boolean solution2(String str) {
        // count the frequency of all characters
        int[] freq = new int[26];

        // lowercase
        str = str.toLowerCase();

        // count the frequency
        for (char ch : str.toCharArray()) {
            if (!(ch == ' ')) {
                freq[ch - 'a']++;
            }
        }

        // check no more than 1 character have odd count
        boolean foundOdd = false;

        for (int x : freq) {
            if (x % 2 == 1) {
                if (foundOdd) {
                    return false;
                }

                foundOdd = true;
            }
        }

        return true;
    }

    /** ----------- Book Solutions ----------- **/
    // only work for 26 lower characters
    // TC => O(n) || SC => O(1)
    public boolean solution3(String str) {
        // count the frequency of all characters
        int[] freq = new int[26];
        // count odd freq char
        int countOdd = 0;
        // lowercase
        str = str.toLowerCase();

        // check no more than 1 character have odd count
        for (char ch : str.toCharArray()) {
            if ((ch == ' ')) {
                continue;
            }

            int i = ch - 'a';
            freq[i]++;
            if (freq[i] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }

        return countOdd <= 1;
    }

}

public class C01_04_PalindromePermutation {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str1;

        // example 1
        System.out.println("---- Example 1 ----");
        str1 = "Tact Coa";
        System.out.println(obj.solution1(str1));
        System.out.println(obj.solution2(str1));
        System.out.println(obj.solution3(str1));

        // example 2
        System.out.println("---- Example 2 ----");
        str1 = "azbaaz";
        System.out.println(obj.solution1(str1));
        System.out.println(obj.solution2(str1));
        System.out.println(obj.solution3(str1));

        // example 3
        System.out.println("---- Example 3 ----");
        str1 = "azbaazc";
        System.out.println(obj.solution1(str1));
        System.out.println(obj.solution2(str1));
        System.out.println(obj.solution3(str1));

        // example 4
        System.out.println("---- Example 4 ----");
        str1 = "azbaz";
        System.out.println(obj.solution1(str1));
        System.out.println(obj.solution2(str1));
        System.out.println(obj.solution3(str1));

        // example 5
        System.out.println("---- Example 5 ----");
        str1 = "azbazcb";
        System.out.println(obj.solution1(str1));
        System.out.println(obj.solution2(str1));
        System.out.println(obj.solution3(str1));
    }
}