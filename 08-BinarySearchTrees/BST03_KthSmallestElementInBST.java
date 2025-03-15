/*
LC230: Kth Smallest Element in a BST || https://leetcode.com/problems/kth-smallest-element-in-a-bst

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
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

class KthSmallestElementInBST {

  /*---- Approach 1 ----*/
  // Time complexity: O(n) || Space Complexity: O(n)
  public int approach1(Node root, int k) {
    List<Integer> list = new ArrayList<>();
    approach1_inOrderTraversal(root, list);

    for (int x : list) {
      k--;
      if (k == 0) {
        return x;
      }
    }

    return -1;
  }

  private void approach1_inOrderTraversal(Node root, List<Integer> list) {
    if (root == null) {
      return;
    }

    approach1_inOrderTraversal(root.left, list);

    list.add(root.data);

    approach1_inOrderTraversal(root.right, list);
  }
  /*---- ----*/

  /*---- Approach 2 ----*/
  // Time complexity: O(n) || Space Complexity: O(1)
  private int ans = -1;
  private int count = 0;

  public int approach2(Node root, int k) {
    approach2_inOrderTraversal(root, k);
    return ans;
  }

  private void approach2_inOrderTraversal(Node root, int k) {
    if (root == null) {
      return;
    }

    approach2_inOrderTraversal(root.left, k);

    count++;
    if (k == count) {
      ans = root.data;
      return;
    }

    approach2_inOrderTraversal(root.right, k);

  }
  /*---- ----*/
}

public class BST03_KthSmallestElementInBST {
  public static void main(String[] args) {

    // example 1
    System.out.println("---- example 1 ----");
    Node root1 = new Node(5);
    root1.left = new Node(3);
    root1.left.left = new Node(2);
    root1.left.right = new Node(4);
    root1.left.left.left = new Node(1);
    root1.right = new Node(6);
    int k1 = 3;

    KthSmallestElementInBST obj1 = new KthSmallestElementInBST();
    System.out.println(obj1.approach1(root1, k1));
    System.out.println(obj1.approach2(root1, k1));

    // example 2
    System.out.println("---- example 2 ----");
    Node root2 = new Node(5);
    root2.left = new Node(1);
    root2.left.right = new Node(2);
    root2.right = new Node(4);
    int k2 = 5;

    KthSmallestElementInBST obj2 = new KthSmallestElementInBST();
    System.out.println(obj2.approach1(root2, k2));
    System.out.println(obj2.approach2(root2, k2));
  }
}
