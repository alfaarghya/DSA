/*
LC211: Design Add and Search Words Data Structure || https://leetcode.com/problems/design-add-and-search-words-data-structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

 

Constraints:

    1 <= word.length <= 25
    word in addWord consists of lowercase English letters.
    word in search consist of '.' or lowercase English letters.
    There will be at most 2 dots in word for search queries.
    At most 104 calls will be made to addWord and search.

 */

class Node {
  Node[] children;
  boolean endOfWord;

  Node() {
    this.children = new Node[26];
    for (int i = 0; i < 26; i++) {
      this.children[i] = null;
    }
    this.endOfWord = false;
  }
}

class WordDictionary {
  Node root;

  public WordDictionary() {
    this.root = new Node();
  }

  public void addWord(String word) {
    Node curr = root;

    for (char ch : word.toCharArray()) {
      int idx = ch - 'a';

      // no char present on trie -> so put new value
      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
      }

      // move to next point
      curr = curr.children[idx];
    }

    // mark as word ends here
    curr.endOfWord = true;
  }

  public boolean search(String word) {
    Node curr = root;

    return helper(word, 0, curr);
  }

  private boolean helper(String word, int start, Node curr) {
    // base case
    if (curr == null) {
      return false;
    }

    for (int i = start; i < word.length(); i++) {
      char ch = word.charAt(i);

      if (ch == '.') {
        // check for non empty children
        for (Node child : curr.children) {
          if (child != null && helper(word, i + 1, child)) {
            return true;
          }
        }

        return false;
      } else {
        int idx = ch - 'a';

        // no char present on trie -> so put new value
        if (curr.children[idx] == null) {
          return false;
        }

        // move to next point
        curr = curr.children[idx];
      }
    }

    return curr.endOfWord;
  }
}

public class Tries01_DesignAddAndSearchWordsDataStructure {
  public static void main(String[] args) {
    WordDictionary obj = new WordDictionary();

    obj.addWord("bad");
    obj.addWord("dad");
    obj.addWord("mad");
    System.out.println(obj.search("pad"));
    System.out.println(obj.search("bad"));
    System.out.println(obj.search(".ad"));
    System.out.println(obj.search("b.."));
  }
}
