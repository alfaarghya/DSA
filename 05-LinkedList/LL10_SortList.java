/*
LC148: Sort List || https://leetcode.com/problems/sort-list/

Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []

 

Constraints:

    The number of nodes in the list is in the range [0, 5 * 104].
    -105 <= Node.val <= 105

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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

class SortList {

  // Time complexity: O(n log(n)) || Space complexity: O(1)
  public Node sortList(Node head) {
    return mergeSort(head);
  }

  private Node mergeSort(Node head) {
    // base case
    if (head == null || head.next == null) {
      return head;
    }

    // find the mid
    Node mid = findMid(head);

    // divide LL into 2 LL
    Node leftHead = head;
    Node rightHead = mid.next;
    mid.next = null; // disconnect leftHead from original LL

    // recursive call
    leftHead = mergeSort(leftHead);
    rightHead = mergeSort(rightHead);

    // merge
    return merge(leftHead, rightHead);
  }

  private Node merge(Node l1, Node l2) {
    Node head = new Node(-1);
    Node temp = head;

    // merge l1 & l1 into sorted manner
    while (l1 != null && l2 != null) {
      if (l1.data < l2.data) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }

      temp = temp.next;
    }

    // merge rest of the values
    if (l1 != null) {
      temp.next = l1;
    } else {
      temp.next = l2;
    }

    return head.next;
  }

  private Node findMid(Node head) {
    Node slow = head, fast = head, prev = null;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    return prev;
  }
}

public class LL10_SortList {
  public static void main(String[] args) {
    SortList obj = new SortList();
    Node head;

    // example 1
    System.out.println("----- example 1 -----");
    head = new Node(new int[] { 3, 1, 5, 2, 4 });
    obj.sortList(head).print();

    // example 2
    System.out.println("----- example 2 -----");
    head = new Node(new int[] { 5, 4, 6, 2, 6, 3 });
    obj.sortList(head).print();
  }
}
