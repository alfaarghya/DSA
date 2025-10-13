/*
    Remove Dups: Write code to remove duplicates from an unsorted list.

    Follow Up => How would you solve this problem if a temporary puffer is not allowed?
 */

import java.util.HashSet;

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

class Solution {
    /** ----------- My Solutions ----------- **/

    // With temporary buffer
    // TC => O(n) || SC => O(n), where n = size of linked list
    public Node solution1(Node head) {
        if (head == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>(); // store only unique value

        // pointers
        Node curr = head;
        Node prev = null;

        // remove duplicates
        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next; // connect prev & curr.next
            } else {
                set.add(curr.data);
                prev = curr;
            }

            curr = curr.next;
        }

        return head;

    }

    /** ----------- Book Solutions ----------- **/

    // without temporary buffer
    // TC => O(n^2) || SC => O(1), where n = size of linked list
    public Node solution2(Node head) {
        Node curr = head;

        while (curr != null) {

            // remove all duplicates inside linked list
            Node temp = curr;
            while (temp.next != null) {
                // duplicate found
                if (temp.next.data == curr.data) {
                    temp.next = temp.next.next;
                }

                // move temp pointer
                temp = temp.next;
            }

            // move curr pointer
            curr = curr.next;
        }

        return head;
    }

}

public class C02_01_RemoveDups {

    public static void main(String[] args) {
        Solution obj = new Solution();
        Node head;

        // example 1
        System.out.println("---- Example 1 ----");
        head = new Node(new int[] { 4, 5, 4, 3, 7, 5, 4, 6, 3 });
        obj.solution1(head).print();
        obj.solution2(head).print();

        // example 2
        System.out.println("---- Example 2 ----");
        head = new Node(new int[] { 7, 5, 4, 6, 3 });
        obj.solution1(head).print();
        obj.solution2(head).print();

        // example 3
        System.out.println("---- Example 3 ----");
        head = new Node(new int[] { 1 });
        obj.solution1(head).print();
        obj.solution2(head).print();

        // example 4
        System.out.println("---- Example 4 ----");
        head = new Node(new int[] { 1, 1, 1, 1, 1, 1 });
        obj.solution1(head).print();
        obj.solution2(head).print();

    }
}