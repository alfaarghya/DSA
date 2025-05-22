/*
LC112: Path Sum || https://leetcode.com/problems/path-sum/


Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

 

Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -1000 <= Node.val <= 1000
    -1000 <= targetSum <= 1000

 */

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

class PathSum {
  public boolean hasPathSum(Node root, int targetSum) {
    int sum = 0;
    return helper(root, targetSum, sum);
}

private boolean helper(Node root, int targetSum, int sum) {
    //base case
    if(root == null) {
        return false;
    }

    //leaf node case
    if(root.left == null && root.right == null) {
        return root.data + sum == targetSum;
    }

    //update sum
    sum += root.data;
    
    //recursive call
    return helper(root.left, targetSum, sum) || helper(root.right, targetSum, sum);

}
}

public class BT07_PathSum {
  public static void main(String[] args) {
    PathSum obj = new  PathSum();
    int targetSum;

    Node root = new Node(5);
    root.left = new Node(4);
    root.left.left = new Node(11);
    root.left.left.left = new Node(7);
    root.left.left.right = new Node(2);
    root.right = new Node(8);
    root.right.left = new Node(13);
    root.right.right = new Node(4);
    root.right.right.left = new Node(1);
    root.right.right.right = new Node(2);

    //example 1
    System.out.println("----- example 1 -----");
    targetSum = 18;
    System.out.println(obj.hasPathSum(root, targetSum));

    //example 2
    System.out.println("----- example 2 -----");
    targetSum = 20;
    System.out.println(obj.hasPathSum(root, targetSum));

    //example 3
    System.out.println("----- example 3 -----");
    targetSum = 22;
    System.out.println(obj.hasPathSum(root, targetSum));
  }
}
