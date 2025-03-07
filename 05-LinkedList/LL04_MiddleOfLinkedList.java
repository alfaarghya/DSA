/*
LC876: Middle of the Linked List || https://leetcode.com/problems/middle-of-the-linked-list/

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.


Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 
Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
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

class MiddleOfLinkedList {

  // Time Complexity: O(n) || Space Complexity: O(1)
  public Node middleOfLinkedList(Node head) {
    // there is no Node or only one Node
    if (head == null || head.next == null) {
      return head;
    }

    // two pointers
    Node slow = head, fast = head;

    // find out the middle
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // answer
    return slow;
  }
}

public class LL04_MiddleOfLinkedList {
  public static void main(String[] args) {
    MiddleOfLinkedList obj = new MiddleOfLinkedList();

    // example 1
    System.out.println("---- example 1 ----");
    Node list1 = new Node(new int[] { 1, 2, 3, 4, 5 });
    System.out.println(obj.middleOfLinkedList(list1).data);

    // example 2
    System.out.println("---- example 2 ----");
    Node list2 = new Node(new int[] { 1, 2 });
    System.out.println(obj.middleOfLinkedList(list2).data);

    // example 3
    System.out.println("---- example 3 ----");
    Node list3 = new Node(new int[] { 1, 2, 3, 4, 5, 6 });
    System.out.println(obj.middleOfLinkedList(list3).data);

    // example 4
    System.out.println("---- example 4 ----");
    Node list4 = new Node();
    System.out.println(obj.middleOfLinkedList(list4).data);

    // example 5
    System.out.println("---- example 5 ----");
    Node list5 = new Node(new int[] { 1 });
    System.out.println(obj.middleOfLinkedList(list5).data);
  }
}