/*
LC108: Convert Sorted Array to Binary Search Tree || https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
 */

import java.util.Queue;
import java.util.LinkedList;

class BinarySearchTree {

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

  BinarySearchTree(int[] data) {
    if (data.length == 0) {
      System.out.println(">> empty array");
      return;
    }
    this.root = buildTree(data, 0, data.length - 1);
  }

  public void levelOrderTraversal() {
    System.out.print("Level-order Traversal >> \n");
    levelOrderTraversal(root);
    System.out.println();
  }

  /*---- ----*/

  /*---- Working Function ----*/

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
  // Convert Sorted Array to BST:
  // Time Complexity => O(n) || Space Complexity => O(1)
  private Node buildTree(int[] arr, int start, int end) {
    // base case
    if (start > end) {
      return null;
    }

    // calculate the mid & create a new root with value
    int mid = start + (end - start) / 2;
    Node root = new Node(arr[mid]);

    // fill up the left & right side of the current root
    root.left = buildTree(arr, start, mid - 1);
    root.right = buildTree(arr, mid + 1, end);

    return root;
  }
  /*---  ----*/

}

public class BST01_ConvertSortedArrayToBST {
  public static void main(String[] args) {

    // example 1
    System.out.println("---- example 1 ----");
    BinarySearchTree obj1 = new BinarySearchTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    obj1.levelOrderTraversal();

    // example 2
    System.out.println("---- example 2 ----");
    BinarySearchTree obj2 = new BinarySearchTree(new int[] { -11, -5, 2, 3, 6, 7, 10, 11 });
    obj2.levelOrderTraversal();

    // example 3
    System.out.println("---- example 3 ----");
    BinarySearchTree obj3 = new BinarySearchTree(new int[] {});
    obj3.levelOrderTraversal();

    // example 4
    System.out.println("---- example 4 ----");
    BinarySearchTree obj4 = new BinarySearchTree(new int[] { -10, -3, 0, 5, 9 });
    obj4.levelOrderTraversal();

    // example 5
    System.out.println("---- example 5 ----");
    BinarySearchTree obj5 = new BinarySearchTree(new int[] { 1, 3 });
    obj5.levelOrderTraversal();
  }
}