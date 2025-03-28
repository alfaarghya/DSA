/*
LC208 Implement Trie (Prefix Tree) || https://leetcode.com/problems/implement-trie-prefix-tree


A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

    + Trie() Initializes the trie object.
    + void insert(String word) Inserts the string word into the trie.
    + boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    + boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

 

Constraints:

    1 <= word.length, prefix.length <= 2000
    word and prefix consist only of lowercase English letters.
    At most 3 * 104 calls in total will be made to insert, search, and startsWith.

 */

class Tries {

  class Node {
    Node[] children;
    boolean isEndOfWord;

    // every node is null
    Node() {
      this.children = new Node[26];
      this.isEndOfWord = false;
    }
  }

  Node root = new Node();

  /*---- inset a word into tries ----*/
  public void insert(String word) { // TC -> O(L) | L is max size of a word
    Node current = root;

    // step1 => run a loop for each character in word
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      // step2 => check if the character is present -> put it in trie
      if (current.children[idx] == null) {
        current.children[idx] = new Node();
      }
      // step3 => move the pointer to next Node
      current = current.children[idx];
    }
    // step4 => mark the end of the word
    current.isEndOfWord = true;
  }
  /*---- ----*/

  /*---- search into tries ----*/
  public boolean search(String word) { // TC -> O(L) | L is max size of a word
    Node current = root;

    // step1 => run a loop for each character in word
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';

      // step2 => check if the character is present
      if (current.children[idx] == null) {
        return false;
      }
      // step3 => if there are chars present -> move to next position
      current = current.children[idx];
    }
    // step4 => check if word end or not
    return current.isEndOfWord;
  }
  /*---- ----*/

  /*---- search into tries ----*/
  public boolean startsWith(String prefix) { // TC -> O(L) | L is max size of a word
    Node current = root;

    for (char ch : prefix.toCharArray()) {
      int idx = ch - 'a';

      // check if char of the word exists on Trie
      if (current.children[idx] == null) {
        return false;
      }

      // if there are chars present -> move to next position
      current = current.children[idx];
    }
    // prefix is present
    return true;
  }
  /*---- ----*/

}

public class Implement_Tries {
  public static void main(String[] args) {
    Tries trie = new Tries();
    String[] words = {
        "avenger",
        "ironman",
        "captain",
        "america",
        "thor",
        "jarvis",
        "blackwidow",
        "loki",
        "ultran",
        "blackpanther",
        "wanda",
        "drstrange",
        "spiderman",
        "thanos"
    };

    for (int i = 0; i < words.length; i++) {
      trie.insert(words[i]);
    }

    System.out.println(trie.search("avg"));
    System.out.println(trie.search("spiderman"));
    System.out.println(trie.search("avgenger"));
    System.out.println(trie.startsWith("ave"));
    System.out.println(trie.startsWith("abc"));
  }
}