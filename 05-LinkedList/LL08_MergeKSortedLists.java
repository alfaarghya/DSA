/*
LC23: Merge k Sorted Lists || https://leetcode.com/problems/merge-k-sorted-lists/
Solved
Hard
Topics
Companies

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

 

Constraints:

    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.


 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

class MergeKSortedLists {
  // Approach 1: brute force, sort the array
  // Time complexity: O(k*n) || Space complexity: O(n)
  public Node approach1(Node[] lists) {
    // store all values into arraylist
    List<Integer> arr = new ArrayList<>();
    for (Node head : lists) {
      while (head != null) {
        arr.add(head.data);
        head = head.next;
      }
    }

    // sort the arr
    Collections.sort(arr);

    // create a new merged linked-list
    Node head = new Node(-1);
    Node temp = head;
    for (int val : arr) {
      temp.next = new Node(val);
      temp = temp.next;
    }

    return head.next;
  }

  // Approach 2: Min Heap, minimum k store
  // Time complexity: O(n*log(k)) || Space complexity: O(k)
  public Node approach2(Node[] lists) {
    // store k nodes into min heap
    PriorityQueue<Node> minHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(a.data, b.data));

    for (Node head : lists) {
      if (head != null) {
        minHeap.offer(head);
      }
    }

    // create a new merged linked-list
    Node head = new Node(-1);
    Node temp = head;
    while (!minHeap.isEmpty()) {
      Node smallest = minHeap.poll();
      temp.next = smallest;
      temp = temp.next;

      if (smallest.next != null) {
        minHeap.offer(smallest.next);
      }
    }

    return head.next;
  }

  // Approach 3: merge all lists into list[0]
  // Time complexity: O(k*n) || Space complexity: O(1)
  public Node approach3(Node[] lists) {
    // no list
    if (lists == null || lists.length == 0) {
      return null;
    }

    // only 1 list
    if (lists.length == 1) {
      return lists[0];
    }

    Node head = lists[0];
    // merge all linked-list into head
    for (int i = 1; i < lists.length; i++) {
      Node l1 = head;
      Node l2 = lists[i];
      head = merge(l1, l2);
    }

    return head;
  }

  private Node merge(Node list1, Node list2) {
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
}

public class LL08_MergeKSortedLists {
  public static void main(String[] args) {
    MergeKSortedLists obj = new MergeKSortedLists();
    Node[] lists;

    //example 1
    System.out.println("----- example 1 -----");
    lists = new Node[]{new Node(new int[]{1,4,6}), new Node(new int[]{2,3,4,5}), new Node(new int[]{3}), new Node(new int[]{3,4,7,8,8})};
    // obj.approach1(lists).print();
    // obj.approach2(lists).print();
    obj.approach3(lists).print();
  }
}
