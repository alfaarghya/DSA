/*
LC530: Minimum Absolute Difference in BST || https://leetcode.com/problems/minimum-absolute-difference-in-bst
LC783: Minimum Distance Between BST Nodes || https://leetcode.com/problems/minimum-distance-between-bst-nodes/


Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.


Example 1:

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [2, 10^4].
    0 <= Node.val <= 10^5

 */

import java.util.ArrayList;
import java.util.List;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class MinimumDistanceBetweenBSTNodes {

  // Time complexity: O(n) || Space complexity: O(n)
  public int approach1(Node root) {
    List<Integer> list = new ArrayList<>();

    // inorder traversal
    inOrderTraversal(root, list);

    // calculate min difference
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < list.size() - 1; i++) {
      int diff = list.get(i + 1) - list.get(i);
      minDiff = Math.min(minDiff, diff);
    }

    return minDiff;
  }

  private void inOrderTraversal(Node root, List<Integer> list) {
    // base case
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left, list);
    list.add(root.data);
    inOrderTraversal(root.right, list);
  }

  // -------------------------------
  private int minDiff;
  private Node prev;

  public int approach2(Node root) {
    minDiff = Integer.MAX_VALUE;
    prev = null;

    // inorder traversal
    inOrderTraversal(root);

    return minDiff;
  }

  private void inOrderTraversal(Node root) {
    // base case
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left);

    // calculate the minDiff
    if (prev != null) {
      minDiff = Math.min(minDiff, root.data - prev.data);
    }
    prev = root;

    inOrderTraversal(root.right);
  }

}

public class BST04_MinimumDistanceBetweenBSTNodes {
  public static void main(String[] args) {
    MinimumDistanceBetweenBSTNodes obj = new MinimumDistanceBetweenBSTNodes();
    
    //BST
    Node root = new Node(20);
    root.left = new Node(10);
    root.left.left = new Node(7);
    root.left.right = new Node(11);
    root.right = new Node(25);
    root.right.left = new Node(22);
    root.right.left.left = new Node(21);
    root.right.right = new Node(30);

    //example 1
    System.out.println("----- example 1 -----");
    System.out.println(obj.approach1(root));
    System.out.println(obj.approach2(root));
  }
}
