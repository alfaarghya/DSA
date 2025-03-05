/*
LC206: Reverse Linked List || https://leetcode.com/problems/reverse-linked-list/

Given the head of a singly linked list, reverse the list, and return the reversed list. 

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
 

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

class Node {
  int data;
  Node next;

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

class ReverseLinkedList {
  // Time complexity: O(n) || Space Complexity: O(1)
  public Node reverseLinkedList(Node head) {
    Node prev = null; // always identify previous Node, need to connect with
    Node curr = head; // always identify current Node,
    Node nxt = head; // always identify next Node, need to disconnect with

    while (nxt != null) {
      nxt = nxt.next; // going to next possible Node
      curr.next = prev; // connect to the previous Node

      // change prev & curr for next iteration
      prev = curr;
      curr = nxt;
    }

    return prev;
  }
}

public class LL03_ReverseLinkedList {
  public static void main(String[] args) {
    ReverseLinkedList obj = new ReverseLinkedList();

    // example 1
    System.out.println("---- example 1 ----");
    Node list1 = new Node(new int[] { 1, 2, 3, 4, 5 });
    obj.reverseLinkedList(list1).print();

    // example 2
    System.out.println("---- example 2 ----");
    Node list2 = new Node(new int[] { 1, 2 });
    obj.reverseLinkedList(list2).print();

  }
}