/*
LC103: Binary Tree Zigzag Level Order Traversal || https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100


 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class BinaryTreeZigzagLevelOrderTraversal {
  // Time complexity: O(n) || Space complexity: O(n)
  public List<List<Integer>> zigzagLevelOrder(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    // create a queue
    Queue<Node> qu = new LinkedList<>();
    qu.add(root);
    qu.add(null);

    // zigzag checker
    boolean zigZag = false;

    while (!qu.isEmpty()) {
      Node curr = qu.remove();
      // new line
      if (curr == null) {

        if (zigZag) { // store the reversed arraylist
          Collections.reverse(temp);
          ans.add(temp);
        } else { // store normal reversed arraylist
          ans.add(temp);
        }

        temp = new ArrayList<>();

        if (qu.isEmpty()) {
          break; // stop the loop
        } else {
          qu.add(null);
        }

        // update zigzag checker
        zigZag = !zigZag;

      } else {
        // print the data
        temp.add(curr.data);
        // System.out.println(curr.val+"->"+zigZag);

        // first go to the left side
        if (curr.left != null) {
          qu.add(curr.left);
        }

        // then go to the right side
        if (curr.right != null) {
          qu.add(curr.right);
        }

      }
    }

    return ans;
  }

}

public class BT04_BinaryTreeZigzagLevelOrderTraversal {
  public static void main(String[] args) {
    BinaryTreeZigzagLevelOrderTraversal obj = new BinaryTreeZigzagLevelOrderTraversal();

    // example 1
    System.out.println("---- example 1 ----");
    Node root1 = new Node(3);
    root1.left = new Node(9);
    root1.right = new Node(20);
    root1.right.left = new Node(15);
    root1.right.right = new Node(7);

    System.out.println(obj.zigzagLevelOrder(root1));

    // example 2
    System.out.println("---- example 2 ----");
    Node root2 = new Node(1);
    System.out.println(obj.zigzagLevelOrder(root2));

    // example 3
    System.out.println("---- example 3 ----");
    Node root3 = new Node(1);
    root3.left = new Node(2);
    root3.right = new Node(3);
    root3.left.left = new Node(4);
    root3.right.right = new Node(5);
    System.out.println(obj.zigzagLevelOrder(root3));

  }
}
