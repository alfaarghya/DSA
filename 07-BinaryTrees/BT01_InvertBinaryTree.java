/*
LC226: Invert Binary Tree || https://leetcode.com/problems/invert-binary-tree/

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

import java.util.Queue;
import java.util.LinkedList;

class BinaryTree {

  /*---- Node ----*/
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
  /*---- ----*/

  Node root;
  int index = -1;

  /*---- Calling Function ----*/

  BinaryTree(int[] data) {
    this.root = buildTree(data);
  }

  public void levelOrderTraversal() {
    System.out.print("Level-order Traversal >> \n");
    levelOrderTraversal(root);
    System.out.println();
  }

  public void invertBinaryTree() {
    invertBinaryTree(root);
  }

  /*---- ----*/

  /*---- Working Function ----*/

  /*---- build a tree form array ----*/
  private Node buildTree(int[] data) { // TC => O(n)
    index++; // increase the index

    // base case => the Node is empty
    if (data[index] == -1) {
      return null;
    }
    // step1 => Create a Node with data
    Node newNode = new Node(data[index]);
    // step2 => build left side of the tree
    newNode.left = buildTree(data);
    // step3 => build right side of the tree
    newNode.right = buildTree(data);

    return newNode;
  }
  /*---- ----*/

  /*---- level-order Traversal on tree ----*/
  private void levelOrderTraversal(Node root) { // TC => O(n)
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
  /*---- ----*/

  /*--- Solution ----*/
  // invert the binary tree: Time Complexity => O(n) || Space Complexity => O(1)
  private Node invertBinaryTree(Node root) {
    // base case
    if (root == null) {
      return null;
    }

    // interchange between 2 side
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    // recursion call
    invertBinaryTree(root.left);
    invertBinaryTree(root.right);

    return root;
  }
  /*---  ----*/

}

public class BT01_InvertBinaryTree {
  public static void main(String[] args) {
    // example 1
    System.out.println("---- Example 1 ----");
    int[] data1 = { 4, 2, 1, -1, -1, 3, -1, -1, 7, 6, -1, -1, 9, -1, -1 };
    BinaryTree bt1 = new BinaryTree(data1);
    bt1.levelOrderTraversal();
    bt1.invertBinaryTree();
    bt1.levelOrderTraversal();

    // example 2
    System.out.println("---- Example 2 ----");
    int[] data2 = { 2, 1, -1, -1, 3, -1, -1 };
    BinaryTree bt2 = new BinaryTree(data2);
    bt2.levelOrderTraversal();
    bt2.invertBinaryTree();
    bt2.levelOrderTraversal();

    // example 3
    System.out.println("---- Example 3 ----");
    int[] data3 = { 1, 2, 4, 7, -1, -1, -1, 5, -1, 8, 11, -1, -1, -1, 3, -1, 6, 9, -1, 12, -1, -1, 10, -1, -1 };
    BinaryTree bt3 = new BinaryTree(data3);
    bt3.levelOrderTraversal();
    bt3.invertBinaryTree();
    bt3.levelOrderTraversal();
  }
}