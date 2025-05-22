/*
LC106: Construct Binary Tree from Inorder and Postorder Traversal || https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

 

Constraints:

    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.

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
  private int postorderIdx1;

  public Node approach1(int[] inorder, int[] postorder) {
    postorderIdx1 = postorder.length - 1;
    return build(postorder, inorder, 0, inorder.length - 1);
  }

  private Node build(int[] postorder, int[] inorder, int start, int end) {
    // base case
    if (start > end) {
      return null;
    }

    // getting the root val from postorder
    int rootVal = postorder[postorderIdx1--];
    // getting mid index from inorder
    int mid = indexOf(inorder, rootVal);

    // create root & connect right & left nodes
    Node root = new Node(rootVal);
    root.right = build(postorder, inorder, mid + 1, end);
    root.left = build(postorder, inorder, start, mid - 1);

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
  private int postorderIdx2;

  public Node approach2(int[] inorder, int[] postorder) {
    postorderIdx2 = postorder.length - 1;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    return build(postorder, inorderMap, 0, inorder.length - 1);
  }

  private Node build(int[] postorder, HashMap<Integer, Integer> inorderMap, int start, int end) {
    // base case
    if (start > end) {
      return null;
    }

    // getting the root val from postorder
    int rootVal = postorder[postorderIdx2--];
    // getting mid index from inorderMap
    int mid = inorderMap.get(rootVal);

    // create root & connect right & left Nodes
    Node root = new Node(rootVal);
    root.right = build(postorder, inorderMap, mid + 1, end);
    root.left = build(postorder, inorderMap, start, mid - 1);

    return root;
  }
  /*---- ---- */
}
/*--- ---*/

public class BT08_ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    BuildTree build;
    int[] postorder, inorder;

    // example 1
    System.out.println("---- example 1 ----");
    postorder = new int[] { 9, 15, 7, 20, 3 };
    inorder = new int[] { 9, 3, 15, 20, 7 };
    build = new BuildTree();
    bt.levelOrderTraversal(build.approach1(inorder, postorder));
    System.out.println("----");
    bt.levelOrderTraversal(build.approach2(inorder, postorder));

    // example 2
    System.out.println("---- example 2 ----");
    postorder = new int[] { 3, 9, 20, 15, 7 };
    inorder = new int[] { 9, 3, 15, 20, 7 };
    build = new BuildTree();
    bt.levelOrderTraversal(build.approach1(inorder, postorder));
    System.out.println("----");
    bt.levelOrderTraversal(build.approach2(inorder, postorder));

    // example 3
    System.out.println("---- example 3 ----");
    postorder = new int[] { -1 };
    inorder = new int[] { -1 };
    build = new BuildTree();
    bt.levelOrderTraversal(build.approach1(inorder, postorder));
    System.out.println("----");
    bt.levelOrderTraversal(build.approach2(inorder, postorder));

  }
}
