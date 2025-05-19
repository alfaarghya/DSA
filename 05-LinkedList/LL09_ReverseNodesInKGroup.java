/*
LC25: Reverse Nodes in k-Group || https://leetcode.com/problems/reverse-nodes-in-k-group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 

Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000

 

Follow-up: Can you solve the problem in O(1) extra memory space?

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

class ReverseNodesInKGroup {
  // TC => O(n) || SC => O(1)
  public Node reverseKGroup(Node head, int k) {
    Node temp = head;
    Node kthNode = null, nextNode = null;
    Node prevGroupLastNode = null; // last node of prev group last node

    while (temp != null) {
      kthNode = getKthNode(temp, k); // get the kth Node
      // we have reach last node
      if (kthNode == null) {
        prevGroupLastNode.next = temp; // connect last group with current temp
        break;
      }

      nextNode = kthNode.next; // next node of kth node
      kthNode.next = null; // disconnect kth node from linked list
      reverseLL(temp); // reverse the group

      if (head == temp) {
        head = kthNode; // chance the head
      } else {
        prevGroupLastNode.next = kthNode; // connect prev group with current kthNode
      }

      prevGroupLastNode = temp; // prevGroupLastNode will be current temp
      temp = nextNode; // temp will be nextNode
      nextNode = null;

    }

    return head;
  }

  private Node getKthNode(Node curr, int k) {
    while (curr != null && k != 1) {
      curr = curr.next;
      k--;
    }

    return curr;
  }

  private void reverseLL(Node head) {
    Node prev = null, curr = head, nxt = head;

    while (curr != null) {
      nxt = nxt.next;
      curr.next = prev;

      prev = curr;
      curr = nxt;
    }
  }
}

public class LL09_ReverseNodesInKGroup {
  public static void main(String[] args) {
    ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
    Node head;
    int k;

    // example 1
    System.out.println("----- example 1 -----");
    head = new Node(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    k = 2;
    obj.reverseKGroup(head, k).print();

    // example 2
    System.out.println("----- example 2 -----");
    head = new Node(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    k = 3;
    obj.reverseKGroup(head, k).print();
  }
}
