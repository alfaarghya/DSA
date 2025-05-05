/*
LC138: Copy List with Random Pointer || https://leetcode.com/problems/copy-list-with-random-pointer


A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.

Your code will only be given the head of the original linked list.

 

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

 

Constraints:

    0 <= n <= 1000
    -104 <= Node.val <= 104
    Node.random is null or is pointing to some node in the linked list.

 */

class Node {
  int val;
  Node next;
  Node random;

  Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class CopyListWithRandomPointer {
  //Time complexity: O(n) || Space complexity: O(1)
  public Node copyRandomList(Node head) {
    Node root = new Node(-1); // ans node
    Node currH, currR; // pointer for current head & root

    // create new copy nodes
    currH = head;
    while (currH != null) {
      Node newCopy = new Node(currH.val);

      // connect new node in list
      newCopy.next = currH.next;
      currH.next = newCopy;

      // move to next point
      currH = currH.next.next;
    }

    // copy random points
    currH = head;
    while (currH != null) {
      if (currH.random != null) {
        // copyNode point to current head's random's next which is a copyNode
        currH.next.random = currH.random.next;
      }

      // move to next point
      currH = currH.next.next;
    }

    // saparate lists
    currH = head;
    currR = root;
    while (currH != null) {
      // connect copy nodes with root
      currR.next = currH.next;

      // diconnect copy nodes
      currH.next = currH.next.next;

      // move to next point
      currH = currH.next;
      currR = currR.next;
    }

    return root.next;
  }
}

public class LL07_CopyListWithRandomPointer {
  public static void main(String[] args) {
    CopyListWithRandomPointer obj = new CopyListWithRandomPointer();

    // example: [[7,4],[1,0],[2,null],[5,2],[3,4]]
    Node head = new Node(7); // 0th idx
    head.next = new Node(1); // 1th idx
    head.next.next = new Node(2); // 2th idx
    head.next.next.next = new Node(5); // 3th idx
    head.next.next.next.next = new Node(3); // 4th idx
    head.random = head.next.next.next.next; // 0th idx -> 4th idx
    head.next.random = head;// 1th idx -> 0th idx
    head.next.next.random = null;// 2th idx -> null
    head.next.next.next.random = head.next.next;// 3th idx -> 2th idx
    head.next.next.next.next.random = head.next.next.next.next;// 4th idx -> 4th idx

    obj.copyRandomList(head);
  }
}
