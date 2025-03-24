/*
LC105: Construct Binary Tree from Preorder and Inorder Traversal || https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

 

Constraints:

    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left;
  Node right;

  Node(int val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

class BinaryTree {

  public void levelOrderTraversal(Node root) { // TC => O(n)
    // corner case => tree is empty
    if (root == null) {
      return;
    }

    // create A queue
    Queue<Node> q = new LinkedList<>();

    q.add(root); // add root & a null
    q.add(null); // here null refers to next line

    while (!q.isEmpty()) {
      Node current = q.remove();

      if (current == null) { // new level
        System.out.println();

        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else { // print value
        System.out.print(current.data + " ");

        if (current.left != null) { // if node's left side is not empty add left side value to queue
          q.add(current.left);
        }

        if (current.right != null) { // if node's right side is not empty add right side value to queue
          q.add(current.right);
        }
      }
    }
  }
}

/* --- solution --- */
class BuildTree {
  /*---- Approach 1 ---- */
  // Time Complexity: O(n^2) || Space Complexity: O(n)
  private int preOrderIdx1 = 0;

  public Node approach1(int[] preorder, int[] inorder) {
    return build(preorder, inorder, 0, inorder.length - 1);
  }

  private Node build(int[] preorder, int[] inorder, int start, int end) {
    // base case
    if (start > end) {
      return null;
    }

    // getting the root val from preorder
    int rootVal = preorder[preOrderIdx1++];
    // getting mid index from inorder
    int mid = indexOf(inorder, rootVal);

    // create root & connect left & right nodes
    Node root = new Node(rootVal);
    root.left = build(preorder, inorder, start, mid - 1);
    root.right = build(preorder, inorder, mid + 1, end);

    return root;
  }

  // search the index of rootval from inorder
  private int indexOf(int[] inorder, int rootVal) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == rootVal) {
        return i;
      }
    }

    return -1;
  }

  /*----  ---- */
  /*---- Approach 2 ---- */
  // Time Complexity: O(n) || Space Complexity: O(n)
  private int preOrderIdx2 = 0;

  public Node approach2(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    return build(preorder, inorderMap, 0, inorder.length - 1);
  }

  private Node build(int[] preorder, HashMap<Integer, Integer> inorderMap, int start, int end) {
    // base case
    if (start > end) {
      return null;
    }

    // getting the root val from preorder
    int rootVal = preorder[preOrderIdx2++];
    // getting mid index from inorderMap
    int mid = inorderMap.get(rootVal);

    // create root & connect left & right nodes
    Node root = new Node(rootVal);
    root.left = build(preorder, inorderMap, start, mid - 1);
    root.right = build(preorder, inorderMap, mid + 1, end);

    return root;
  }
  /*---- ---- */
}
/*--- ---*/

public class BT05_ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();

    // example 1
    System.out.println("---- example 1 ----");
    int[] preorder1 = { 1, 2, 4, 5, 8, 3, 6, 9, 10, 7 };
    int[] inorder1 = { 4, 2, 8, 5, 1, 6, 10, 9, 3, 7 };
    BuildTree build1 = new BuildTree();
    bt.levelOrderTraversal(build1.approach1(preorder1, inorder1));
    System.out.println("----");
    bt.levelOrderTraversal(build1.approach2(preorder1, inorder1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] preorder2 = { 3, 9, 20, 15, 7 };
    int[] inorder2 = { 9, 3, 15, 20, 7 };
    BuildTree build2 = new BuildTree();
    bt.levelOrderTraversal(build2.approach1(preorder2, inorder2));
    System.out.println("----");
    bt.levelOrderTraversal(build2.approach2(preorder2, inorder2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] preorder3 = { -1 };
    int[] inorder3 = { -1 };
    BuildTree build3 = new BuildTree();
    bt.levelOrderTraversal(build3.approach1(preorder3, inorder3));
    System.out.println("----");
    bt.levelOrderTraversal(build3.approach2(preorder3, inorder3));
  }
}