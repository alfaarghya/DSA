/*
LC199: Binary Tree Right Side View || https://leetcode.com/problems/binary-tree-right-side-view

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:

Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]

Example 3:

Input: root = [1,null,3]
Output: [1,3]

Example 4:

Input: root = []
Output: []


Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

class SideView {
  //Time complexity: O(n) || Space Complexity: O(n)
  public List<Integer> rightSideView(Node root) {
    List<Integer> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    if(root == null) {
        return ans;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root); //add first node
    q.add(null); //null refers to next line

    while(!q.isEmpty()) {
        Node curr = q.remove();

        if(curr == null) {
            ans.add(temp.get(temp.size()-1)); //side view -> last element of current level
            temp = new ArrayList<>();
            
            if(q.isEmpty()) {
                break;
            } else {
                q.add(null);
            }
        } else {
            temp.add(curr.data);

            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    return ans;
}
}

public class BT09_SideView {
  public static void main(String[] args) {
    SideView obj = new SideView();
    
    //example 1
    System.out.println("----- example 1 -----");
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.left.left = new Node(5);
    root.right = new Node(3);

    System.out.println(obj.rightSideView(root));
  }
}
