/*
LC212: Word Search II || https://leetcode.com/problems/word-search-ii

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

 

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 12
    board[i][j] is a lowercase English letter.
    1 <= words.length <= 3 * 10^4
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
    All the strings of words are unique.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 {
  //Brute force approach from Word Search I
  public List<String> findWords(char[][] board, String[] words) {
    List<String> answer = new ArrayList<>();
    int m = board.length, n = board[0].length;
    boolean[] isAnswer = new boolean[words.length];
    
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < words.length; k++) {
                String word = words[k];
                if(!isAnswer[k] && word.charAt(0) == board[i][j]) {
                    if(helper(board, word, i, j, 0, new boolean[m][n])) {
                        answer.add(word);
                        isAnswer[k] = true;
                    }
                }
            }
        }
    }

    return answer;
}

private boolean helper(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
    //base case
    if(word.length() == idx) {
        return true;
    }

    //check limits, visited & same character
    if((0 > i || i >= board.length) || (0 > j || j >= board[0].length) || visited[i][j] || word.charAt(idx) != board[i][j]) {
        return false;
    }

    //visited
    visited[i][j] = true;

    //recurssion
    if(
        helper(board, word, i-1, j, idx+1, visited) || //left
        helper(board, word, i+1, j, idx+1, visited) || //right
        helper(board, word, i, j-1, idx+1, visited) || //up
        helper(board, word, i, j+1, idx+1, visited)     //down
    ) {
        return true;
    }

    visited[i][j] = false; //backtrack
    return false;

}
}

class Solution2 {

  class Node {
    Node[] children;
    String word;

    Node() {
        this.children = new Node[26];
        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
        this.word = null;
    }

}

  public List<String> findWords(char[][] board, String[] words) {
    var trie = buildTrie(words);
    Set<String> ans = new HashSet<>();

    for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            if(trie.children[board[i][j]-'a'] != null) {
                dfs(board, trie, i, j, ans);
            }
        }
    }

    return new ArrayList<>(ans);

}

private void dfs(char[][] board, Node trie, int i, int j, Set<String> ans) {
    //base case
    if((0 > i || i >= board.length) || (0 > j || j >= board[0].length) ||
        board[i][j] == '-' || trie.children[board[i][j] - 'a'] == null ) {
            return;
    }

    if(trie.children[board[i][j] - 'a'].word != null) {
        ans.add(trie.children[board[i][j] - 'a'].word);
    }


    //nove to next node
    trie = trie.children[board[i][j] - 'a'];

    //mark as visited
    char ch = board[i][j];
    board[i][j] = '-';

    //go to all direction
    dfs(board, trie, i-1, j, ans); //left
    dfs(board, trie, i+1, j, ans); //right
    dfs(board, trie, i, j-1, ans); //up
    dfs(board, trie, i, j+1, ans); //down

    //backtrack -> mark as unvisited
    board[i][j] = ch;
}

private Node buildTrie(String[] words) {
    Node root = new Node();

    for(String word: words) {
        Node curr = root;

        for(char ch: word.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }

        curr.word = word;
    }

    return root;
}
}

public class String10_WordSearchII {
  public static void main(String[] args) {
    Solution1 obj1 = new Solution1();
    Solution2 obj2 = new Solution2();
    String[] words;
    char[][] board;

    //example 1
    board = new char[][] {{'a','b','c','e','l','k'},{'z','n','z','d','d','j'},{'o','y','m','e','c','i'},{'p','n','x','f','h','b'},{'o','q','y','g','i','a'}};
    words = new String[] {"efgi","ddn","efefg", "efgyx","ddj"};
    System.out.println(obj1.findWords(board, words));
    System.out.println(obj2.findWords(board, words));
  }
}
