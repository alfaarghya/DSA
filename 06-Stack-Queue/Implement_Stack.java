import java.util.ArrayList;

class StackWithArrayList {
  // create arraylist -> to store inserted data
  static ArrayList<Integer> list = new ArrayList<>();

  /*---- check if stack is empty or not ----*/
  public boolean isEmpty() {
    return list.size() == 0;
  }
  /*---- ----*/

  /*---- adding a data into stack ----*/
  public void push(int data) { // TC -> O(1)
    list.add(data);
  }

  /*---- ----*/

  /*---- remove top data from stack ----*/
  public int pop() { // TC -> O(1)
    if (isEmpty()) { // corner case -> stack is empty
      System.out.print("Empty.....");
      return Integer.MIN_VALUE;
    }
    int top = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return top;
  }
  /*---- ----*/

  /*---- peek into stack ----*/
  public int peek() { // TC -> O(1)
    if (isEmpty()) { // corner case -> stack is empty
      System.out.print("Empty.....");
      return Integer.MIN_VALUE;
    }
    return list.get(list.size() - 1);
  }
  /*---- ----*/
}

class StackWithArray {
  /*---- Create a empty stack ----*/
  int[] arr;
  int n;
  int index;

  StackWithArray(int capacity) {
    this.arr = new int[capacity];
    this.n = capacity;
    this.index = -1;
  }
  /*---- ----*/

  /*---- is stack empty ----*/
  public boolean isEmpty() { // TC -> O(1)
    return index == -1;
  }
  /*---- ----*/

  /*---- push a data into stack ----*/
  public void push(int data) { // TC -> O(1)
    // corner case => if array is full
    if (index == n - 1) {
      System.out.println(">> stack is full, can't add new data.........");
      return;
    }

    // add the data into the array
    arr[++index] = data;
  }
  /*---- ----*/

  /*---- pop a data from stack ----*/
  public int pop() { // TC -> O(1)
    // corner case => stack is empty
    if (isEmpty()) {
      System.out.println(">> Stack is empty.........");
      return Integer.MIN_VALUE;
    }
    // step1 => store the data
    int del = arr[index];
    // step2 => delete the data and decrease the index by 1
    arr[index--] = 0;

    return del;
  }
  /*---- ----*/

  /*---- peek on top of Stack ----*/
  public int peek() { // TC -> O(1)
    // corner case => stack is empty
    if (isEmpty()) {
      System.out.println(">> Stack is empty.........");
      return Integer.MIN_VALUE;
    }

    return arr[index];
  }
  /*---- ----*/

}

class StackWithLinkedList {
  /*---- Node ----*/
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  /*---- ----*/

  /*---- create a empty stack ----*/
  static Node head;
  /*---- ----*/

  /*---- is stack empty ----*/
  public boolean isEmpty() { // TC -> O(1)
    return head == null;
  }
  /*---- ----*/

  /*---- push a data into stack ----*/
  public void push(int data) { // TC -> O(1)
    // step1 => create a new Node
    Node newNode = new Node(data);
    // connect the Node with head Node
    newNode.next = head;
    // newNode become the head Node
    head = newNode;
  }
  /*---- ----*/

  /*---- pop a data from stack ----*/
  public int pop() { // TC -> O(1)
    // corner case => stack is empty
    if (head == null) {
      System.out.println(">> Stack is empty.........");
      return Integer.MIN_VALUE;
    }
    // step1 => del Node point to head;
    Node del = head;
    // step2 => head move to next Node;
    head = head.next;
    // step3 => disconnect the del Node from stack
    del.next = null;

    return del.data;
  }
  /*---- ----*/

  /*---- peek on top of Stack ----*/
  public int peek() { // TC -> O(1)
    // corner case => stack is empty
    if (head == null) {
      System.out.println(">> Stack is empty.........");
      return Integer.MIN_VALUE;
    }

    return head.data;
  }
  /*---- ----*/
}

public class Implement_Stack {
  public static void main(String args[]) {
    StackWithLinkedList sll = new StackWithLinkedList();
    sll.push(0);
    sll.push(1);
    sll.push(2);
    sll.push(3);
    System.out.println(">>" + sll.peek());

    while (!sll.isEmpty()) {
      System.out.println(sll.pop());
    }
    System.out.println(sll.peek());
    System.out.println(sll.pop());

    System.out.println("-----------------------------------------------");
    // ------------------

    StackWithArrayList sla = new StackWithArrayList();
    sla.push(0);
    sla.push(1);
    sla.push(2);
    sla.push(3);

    System.out.println(">> " + sla.peek());

    while (!sla.isEmpty()) {
      System.out.println(sla.pop());
    }
    // System.out.println(sla.pop());
    System.out.println(sla.peek());

    System.out.println("-----------------------------------------------");
    // ------------------------

    StackWithArray sarr = new StackWithArray(5);
    System.out.println(sarr.isEmpty());
    System.out.println(sarr.pop());

    sarr.push(1);
    sarr.push(11);
    sarr.push(111);
    sarr.push(1111);
    sarr.push(11111);
    sarr.push(111111);

    System.out.println(sarr.isEmpty());
    System.out.println(sarr.pop());
    System.out.println(sarr.pop());
    System.out.println(sarr.pop());
    System.out.println(sarr.pop());
    System.out.println(sarr.peek());
  }
}
