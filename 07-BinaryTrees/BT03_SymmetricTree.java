/*
LC101: Symmetric Tree || https://leetcode.com/problems/symmetric-tree/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
 */

import java.util.ArrayList;

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

  public boolean approach1() {
    if (root == null) {
      return true;
    }

    return approach1_helper(root.left, root.right);
  }

  public boolean approach2() {
    if (root == null) {
      return true;
    }

    return approach2_helper(root);
  }

  /*---- ----*/

  /*---- Working Function ----*/

  /*---- build a tree form array ----*/
  private Node buildTree(int[] data) { // TC => O(n)
    index++; // increase the index

    // base case => the Node is empty
    if (data[index] == -101) {
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

  /*--- Solutions ----*/

  // Approach recursion=> Time Complexity: O(n) || Space Complexity: O(h)
  private boolean approach1_helper(Node leftN, Node rightN) {
    // base case 1
    if (leftN == null && rightN == null) {
      return true;
    }

    // base case 2
    if (leftN == null || rightN == null) {
      return false;
    }

    // check for node values
    if (leftN.data == rightN.data) {
      return approach1_helper(leftN.left, rightN.right) && approach1_helper(leftN.right, rightN.left);
    } else {
      return false;
    }
  }

  // Approach Iteration => Time Complexity: O(n) || Space Complexity: O(n)
  private boolean approach2_helper(Node root) {
    // store both side node here
    ArrayList<Integer> leftList = new ArrayList<>();
    ArrayList<Integer> rightList = new ArrayList<>();

    // traversal for identical value
    postOrderTraversal(root.left, leftList);
    preOrderTraversal(root.right, rightList);

    // if size is not the same, it's not a mirror
    if (leftList.size() != rightList.size()) {
      return false;
    }

    // check if all values are matching or not
    int n = leftList.size();
    for (int i = 0; i < n; i++) {
      if (leftList.get(i) != rightList.get(n - 1 - i)) {
        return false;
      }
    }

    return true;
  }

  private void postOrderTraversal(Node root, ArrayList<Integer> list) {
    if (root == null) {
      list.add(-101);
      return;
    }

    list.add(root.data);
    postOrderTraversal(root.left, list);
    postOrderTraversal(root.right, list);
  }

  private void preOrderTraversal(Node root, ArrayList<Integer> list) {
    if (root == null) {
      list.add(-101);
      return;
    }

    preOrderTraversal(root.left, list);
    preOrderTraversal(root.right, list);
    list.add(root.data);
  }
  /*---  ----*/

}

public class BT03_SymmetricTree {
  public static void main(String[] args) {
    // Example 1
    System.out.println("---- Example 1 ----");
    BinaryTree bt1 = new BinaryTree(new int[] { -101 }); // -101 is null
    System.out.println(bt1.approach1());
    System.out.println(bt1.approach2());

    // Example 2
    System.out.println("---- Example 2 ----");
    BinaryTree bt2 = new BinaryTree(new int[] { 1, -101, -101 });
    System.out.println(bt2.approach1());
    System.out.println(bt2.approach2());

    // Example 3
    System.out.println("---- Example 3 ----");
    BinaryTree bt3 = new BinaryTree(new int[] { 1, 2, -101, -101, -101 });
    System.out.println(bt3.approach1());
    System.out.println(bt3.approach2());

    // Example 4
    System.out.println("---- Example 4 ----");
    BinaryTree bt4 = new BinaryTree(new int[] { 1, 2, -101, -101, 3, -101, -101 });
    System.out.println(bt4.approach1());
    System.out.println(bt4.approach2());

    // Example 5
    System.out.println("---- Example 5 ----");
    BinaryTree bt5 = new BinaryTree(new int[] { 1, 2, -101, -101, 2, -101, -101 });
    System.out.println(bt5.approach1());
    System.out.println(bt5.approach2());

    // Example 6
    System.out.println("---- Example 6 ----");
    BinaryTree bt6 = new BinaryTree(new int[] { 1, 2, 3, -101, 4, -101, -101, -101, 2, -101, 3, 4, -101, -101, -101 });
    System.out.println(bt6.approach1());
    System.out.println(bt6.approach2());

    // Example 7
    System.out.println("---- Example 7 ----");
    BinaryTree bt7 = new BinaryTree(new int[] { 1, 2, -101, 3, -101, -101, 2, -101, 3, -101, -101 });
    System.out.println(bt7.approach1());
    System.out.println(bt7.approach2());

    // Example 8
    System.out.println("---- Example 8 ----");
    BinaryTree bt8 = new BinaryTree(new int[] { 4, 2, 1, -101, -101, 3, -101, -101, 7, 6, -101, -101, 9, -101, -101 });
    System.out.println(bt8.approach1());
    System.out.println(bt8.approach2());
  }
}