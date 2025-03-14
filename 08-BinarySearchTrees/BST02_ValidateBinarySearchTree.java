/*
LC98: Validate Binary Search Tree || https://leetcode.com/problems/validate-binary-search-tree/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */

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

class ValidateBinarySearchTree {
  // Time complexity: O(n) || Space Complexity: O(n)
  public boolean isValidBST(Node root, long min, long max) {
    // base case => if root is null -> true
    if (root == null) {
      return true;
    }

    // check if BST condition is failing
    if (!(min < root.data && root.data < max)) {
      return false;
    }

    // check if both side valid
    return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
  }
}

public class BST02_ValidateBinarySearchTree {
  public static void main(String[] args) {
    // example 1 => [5,1,4,null,null,3,6]
    System.out.println("---- example 1 ----");
    Node root1 = new Node(5);
    root1.left = new Node(1);
    root1.right = new Node(4);
    root1.right.left = new Node(3);
    root1.right.right = new Node(6);
    ValidateBinarySearchTree obj1 = new ValidateBinarySearchTree();
    System.out.println(obj1.isValidBST(root1, Long.MIN_VALUE, Long.MAX_VALUE));

    // example 2 => [5,4,8,null,null,6,9,null,7,null,null]
    System.out.println("---- example 2 ----");
    Node root2 = new Node(5);
    root2.left = new Node(4);
    root2.right = new Node(8);
    root2.right.left = new Node(6);
    root2.right.left.right = new Node(7);
    root2.right.right = new Node(9);
    ValidateBinarySearchTree obj2 = new ValidateBinarySearchTree();
    System.out.println(obj2.isValidBST(root2, Long.MIN_VALUE, Long.MAX_VALUE));
  }
}