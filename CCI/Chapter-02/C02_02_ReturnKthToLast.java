/*
    Return Kth to Last: Implement an algorithm to find the kth to the last element in singly linked list.
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

class Solution {
    /** ----------- My Solutions ----------- **/
    /*
     * Straight forward approach: calculate the size(n) of LL then, find out the
     * (n-k-1)th element on LL
     */
    // TC => O(n) || SC => O(1), where n = size of LinkedList
    public int solution1(Node head, int k) {
        Node curr = head;

        // calculate the size of Linked List
        int n = 0;
        while (curr != null) {
            n++;// increase the size
            curr = curr.next; // move to the next Node
        }

        // corner case, k is large than size of LinkedList
        if (k >= n) {
            return -1;
        }

        // remove kth to last Node
        int removeIdx = n - k - 1;

        // find the value
        curr = head;
        int i = 0;
        while (curr != null) {
            if (i == removeIdx) {
                return curr.data;
            }

            i++;
            curr = curr.next;
        }

        // no value
        return -1;
    }

    /** ----------- Book Solutions ----------- **/
    /*
     * Optimal code: initialize 2 pointers p1 & p2. First we placed them k nodes
     * apart p2 at the beginning and p1 at kth index. Then we move them both at the
     * same pace until p1 become null. On That point we found our value.
     */
    // TC => O(n) || SC => O(1)
    public int solution2(Node head, int k) {
        Node p1 = head, p2 = head;

        for (int i = 0; i <= k; i++) {
            // k is larger than size of LL
            if (p1 == null) {
                return -1;
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }
}

public class C02_02_ReturnKthToLast {

    public static void main(String[] args) {
        Solution obj = new Solution();
        Node head;
        int k;

        // example 1
        System.out.println("---- Example 1 ----");
        head = new Node(new int[] { 4, 5, 4, 3, 7, 5, 4, 6, 3 });
        k = 6;
        System.out.println(obj.solution1(head, k));
        System.out.println(obj.solution2(head, k));

        // example 2
        System.out.println("---- Example 2 ----");
        head = new Node(new int[] { 7, 5, 4, 6, 3 });
        k = 0;
        System.out.println(obj.solution1(head, k));
        System.out.println(obj.solution2(head, k));

        // example 3
        System.out.println("---- Example 3 ----");
        head = new Node(new int[] { 1 });
        k = 3;
        System.out.println(obj.solution1(head, k));
        System.out.println(obj.solution2(head, k));

        // example 4
        System.out.println("---- Example 4 ----");
        head = new Node(new int[] { 1, 1, 1, 1, 1, 1 });
        k = 5;
        System.out.println(obj.solution1(head, k));
        System.out.println(obj.solution2(head, k));

    }
}