/*
LC19 Remove Nth Node From End of List || https://leetcode.com/problems/remove-nth-node-from-end-of-list

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]


Constraints:
    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz

Follow up: Could you do this in one pass?
 */

class Node {
  int data;
  Node next;

  Node() {
    this.next = null;
  }

  Node(int data) {
    this.data = data;
    this.next = null;
  }

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

  Node(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    this.data = arr[0];
    Node temp = this;
    for (int i = 1; i < arr.length; i++) {
      temp.next = new Node(arr[i]);
      temp = temp.next;
    }

  }

  public void print() {
    if (this == null || (this.data == 0 && this.next == null)) {
      System.out.print("[]\n");
      return;
    }

    Node temp = this;

    System.out.print("[");
    while (temp != null) {
      System.out.print(" " + temp.data + " ");
      temp = temp.next;
    }
    System.out.print("]\n");
  }
}

class RemoveNthNodeFromEnd {

  // Time Complexity: O(n) || Space Complexity: O(1)
  public Node approach1(Node head, int n) {
    // calculate the size of LL
    Node temp = head;
    int N = size(temp);

    // corner case only 1 node
    if (N == n) {
      return head.next;
    }

    // Delete the nth node
    int delIdx = N - n;
    Node prev = head;
    removeNthNode(prev, delIdx);

    return head;
  }

  private int size(Node head) {
    int N = 0;

    // go through entire LL
    while (head != null) {
      N++;
      head = head.next;
    }

    return N;
  }

  private void removeNthNode(Node prev, int n) {
    // go to the prev node of del node
    for (int i = 1; i < n; i++) {
      prev = prev.next;
    }

    // findout the del node
    Node del = prev.next;

    // disconnect the del node
    prev.next = del.next;
    del.next = null;

  }

  // Time Complexity: O(n) || Space Complexity: O(1)
  public Node approach2(Node head, int n) {
    // corner case -> only one node
    if (head.next == null && n == 1) {
      return head.next;
    }

    Node ans = new Node(-1, head);

    Node temp = head;
    for (int i = 0; i < n; i++) {
      temp = temp.next;
    }

    // find the prev Node of del Node
    Node prev = ans;
    while (temp != null) {
      temp = temp.next;
      prev = prev.next;
    }
    // disconnect Del node
    Node del = prev.next;
    prev.next = del.next;
    del.next = null;

    return ans.next;
  }
}

public class LL05_RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();

    // example 1
    System.out.println("---- example 1 ----");
    obj.approach1(new Node(new int[] { 1, 2, 3, 4, 5 }), 2).print();
    obj.approach2(new Node(new int[] { 1, 2, 3, 4, 5 }), 2).print();

    // example 2
    System.out.println("---- example 2 ----");
    obj.approach1(new Node(new int[] { 1 }), 1); // null will be the ans
    obj.approach2(new Node(new int[] { 1 }), 1); // null will be the ans

    // example 3
    System.out.println("---- example 3 ----");
    obj.approach1(new Node(new int[] { 1, 2 }), 1).print();
    obj.approach2(new Node(new int[] { 1, 2 }), 1).print();

    // example 4
    System.out.println("---- example 4 ----");
    obj.approach1(new Node(new int[] { 1, 2, 3, 4, 5, 6 }), 3).print();
    obj.approach2(new Node(new int[] { 1, 2, 3, 4, 5, 6 }), 3).print();
  }
}
