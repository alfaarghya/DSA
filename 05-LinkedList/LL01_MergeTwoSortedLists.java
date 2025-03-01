/*
LC21: Merge Two Sorted Lists || https://leetcode.com/problems/merge-two-sorted-lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
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

class MergeTwoSortedLists {
  // approach 1 => simple loops, time complexity: O(m+n) || space complexity: O(1)
  public Node approach1(Node list1, Node list2) {
    Node list = new Node(-1);
    Node temp = list;

    // GO through both lists and compare the smallest one
    while (list1 != null && list2 != null) {
      if (list1.data < list2.data) {
        temp.next = list1; // add to list
        list1 = list1.next;
      } else {
        temp.next = list2; // add to list
        list2 = list2.next;
      }
      temp = temp.next; // move to next node
    }

    // check for the remaning data -> marge it to list
    if (list1 != null) {
      temp.next = list1; // append rest of nodes
    } else if (list2 != null) {
      temp.next = list2; // append rest of nodes
    }

    return list.next;
  }

  // approach 2 => simple loops, time complexity: O(m+n) || space complexity: O(1)
  public Node approach2(Node list1, Node list2) {
    if (list1 != null && list2 != null) {
      if (list1.data < list2.data) {
        list1.next = approach2(list1.next, list2);
        return list1;
      } else {
        list2.next = approach2(list1, list2.next);
        return list2;
      }
    }

    return list1 != null ? list1 : list2;
  }
}

public class LL01_MergeTwoSortedLists {

  public static void main(String[] args) {
    MergeTwoSortedLists obj = new MergeTwoSortedLists();

    // example 1
    Node list01 = new Node(new int[] { 1, 2, 4 });
    Node list02 = new Node(new int[] { 1, 3, 4 });
    obj.approach1(list01, list02).print();

  }
}