/*
LC02: Add Two Numbers || https://leetcode.com/problems/add-two-numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 

Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.

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

class AddTwoNumbers {

  // Time Complexly: O(n) || Space complexity: O(1)
  public Node addTwoNumbers(Node l1, Node l2) {
    Node head = new Node(-1);
    Node temp = head; // tepm node to travel

    // initilize
    int sum = 0, carry = 0, nodeVal = 0;

    // loop while l1 or l2 is not null OR carry is 1
    while (l1 != null || l2 != null || carry == 1) {
      // sum current l1 and l2 node
      if (l1 != null) {
        sum += l1.data;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.data;
        l2 = l2.next;
      }

      // add carry
      sum += carry;

      // calculate carry & current ans
      carry = sum / 10;
      nodeVal = sum % 10;

      // store it into node
      temp.next = new Node(nodeVal);

      // move to next node
      temp = temp.next;
      // make sum = 0 for next iteration
      sum = 0;
    }

    return head.next;
  }
}

public class LL06_AddTwoNumbers {
  public static void main(String[] args) {
    AddTwoNumbers obj = new AddTwoNumbers();
    Node l1;
    Node l2;

    // example 1
    System.out.println("----- example 1 -----");
    l1 = new Node(new int[] { 9, 9, 9, 9 });
    l2 = new Node(new int[] { 1, 2, 3 });
    obj.addTwoNumbers(l1, l2).print();

    // example 2
    System.out.println("----- example 2 -----");
    l1 = new Node(new int[] { 2, 4, 3 });
    l2 = new Node(new int[] { 5, 6, 4 });
    obj.addTwoNumbers(l1, l2).print();

    // example 3
    System.out.println("----- example 3 -----");
    l1 = new Node(new int[] { 0 });
    l2 = new Node(new int[] { 0 });
    obj.addTwoNumbers(l1, l2).print();

    // example 3
    System.out.println("----- example 3 -----");
    l1 = new Node(new int[] { 9, 9, 9, 9, 9, 9, 9 });
    l2 = new Node(new int[] { 9, 9, 9, 9 });
    obj.addTwoNumbers(l1, l2).print();
  }
}
