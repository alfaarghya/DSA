/*
LC139: Word Break || https://leetcode.com/problems/word-break


Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 

Constraints:

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.
 */
import java.util.ArrayList;
import java.util.List;

class Tries {
  static class Node {
    Node[] children = new Node[26];
    boolean endOfWord;

    public Node() {
      for (int i = 0; i < 26; i++) {
        this.children[i] = null;
      }
      this.endOfWord = false;
    }
  }

  Node root;

  public Tries() {
    this.root = new Node();
  }

  public void insert(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
      }
      curr = curr.children[idx];
    }
    curr.endOfWord = true;
  }

  public boolean search(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (curr.children[idx] == null) {
        return false;
      }
      curr = curr.children[idx];
    }
    return curr.endOfWord;
  }

}

class WordBreak {
  public boolean wordBreak(String str, List<String> wordDict) {
    Tries trie = new Tries();

    for (String word : wordDict) {
      trie.insert(word);
    }

    int n = str.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int end = 1; end <= n; end++) {
      for (int start = 0; start < end; start++) {
        if (dp[start] && trie.search(str.substring(start, end))) {
          dp[end] = true;
          break;
        }
      }
    }

    return dp[n];
  }
}

public class DP05_WordBreak {
  public static void main(String[] args) {
    WordBreak obj = new WordBreak();
    String str;
    List<String> wordDict;

    //example 1
    System.out.println("----- example 1 -----");
    str = "applepenapple";
    wordDict = new ArrayList<>(List.of("apple", "pen"));
    System.out.println(obj.wordBreak(str, wordDict));

    //example 2
    System.out.println("----- example 2 -----");
    str = "aaaaaaa";
    wordDict = new ArrayList<>(List.of("aaaa", "aa"));
    System.out.println(obj.wordBreak(str, wordDict));
  }
}
