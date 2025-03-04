/*
LC141:  Linked List Cycle || https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 
Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
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

  // create linkedList with cycle
  Node(int[] arr, int pos) {
    if (arr.length == 0) {
      return;
    }

    this.data = arr[0];
    Node temp = this;
    for (int i = 1; i < arr.length; i++) {
      temp.next = new Node(arr[i]);

      if (i != arr.length - 1) {
        temp = temp.next;
      }
    }

    // making a cycle
    Node tail = temp;
    temp = this;
    for (int i = 0; i < arr.length; i++) {
      if (i == pos) {
        tail.next = temp;
        break;
      }

      temp = temp.next;
    }
  }
}

class LinkedListCycle {

  // slow fast method => time complexity: O(n) || space complexity => O(1)
  public boolean approach1(Node head) {
    if (head == null || head.next == null) {
      return false;
    }

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }
}

public class LL02_LinkedListCycle {
  public static void main(String[] args) {
    LinkedListCycle obj = new LinkedListCycle();

    // example 1
    System.out.println("---- example 1 ----");
    Node head1 = new Node(new int[] { 3, 2, 0, -4 }, 1);
    System.out.println(obj.approach1(head1));

    // example 2
    System.out.println("---- example 2 ----");
    Node head2 = new Node(new int[] { 1, 2 }, 0);
    System.out.println(obj.approach1(head2));
  }
}