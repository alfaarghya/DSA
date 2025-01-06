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
      // step3 => if character is not present move to next character
      current = current.children[idx];
    }
    // step4 => check if word is present or not
    return current.isEndOfWord == true;
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
  }
}