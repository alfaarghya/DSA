/*
  String Compression: Implement a method to perform basic String compression using the counts
  of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
  'compressed' string would not become smaller than original string should return the 
  original string. you can assume  string has only uppercase and lowercase letters(a-Z).
  
 */

class Solution {
    /** ----------- My Solutions ----------- **/
    //TC => O(n) || SC => O(N), where n = size of String, N = size of String builder(ans)
    public String solution1(String str) {
        int n = str.length();
        if(n == 0 || n == 1) {
            return str;
        }

        StringBuilder ans = new StringBuilder();
        int[] freq = new int[128]; // to count the frequency
        freq[str.charAt(0)-'a']++; // count the first char

        for(int i = 1; i < n; i++) {
            char currCh = str.charAt(i);
            char prevCh = str.charAt(i-1);
            
            //when current & previous character does not match
            if(currCh != prevCh) {
                ans.append(prevCh); //put the prev char into StringBuilder
                ans.append(freq[prevCh-'A']); //put the count/freq of the prev char

                freq[prevCh -'A'] = 0; //freq go back to 0
            }
            
            freq[currCh -'A']++;//increase current freq
        }

        //put the last character and it's count
        ans.append(str.charAt(n-1));
        ans.append(freq[str.charAt(n-1) - 'A']);
        
        return ans.length() > str.length() ? str : ans.toString();
    }    

    /** ----------- Book Solutions ----------- **/
  
}

public class C01_06_StringCompression {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str1;

        // example 1
        System.out.println("---- Example 1 ----");
        str1 = "aabcccccaaa";
        System.out.println(obj.solution1(str1));
        
        // example 2
        System.out.println("---- Example 2 ----");
        str1 = "aBcdEfgHhIj";
        System.out.println(obj.solution1(str1));
        
        // example 3
        System.out.println("---- Example 3 ----");
        str1 = "alfaarghya";
        System.out.println(obj.solution1(str1));
        
    }
}