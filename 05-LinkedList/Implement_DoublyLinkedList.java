class DoublyLinkedList<DataType> {

  /*---- Node ----*/
  class Node {
    DataType data;
    Node next;
    Node prev;

    Node(DataType data) {
      this.data = data; // data
      // by default every Node point to null
      this.next = null;
      this.prev = null;
    }
  }
  /*---- ----*/

  public Node head; // head is the first Node of DoublyLinkedList
  public Node tail; // tail is the last Node of DoublyLinkedList
  public static int size; // size is the length of DoublyLinkedList

  /*----- Print DoublyLinkedList ----*/
  public void printForward() { // TC -> O(n)
    // corner case => DoublyLinkedList is empty
    if (head == null) {
      System.out.println("DoublyLinkedList is empty..........");
      return;
    }

    // step1 => temp Node point to the head Node
    Node temp = head;
    // step2 => run a loop until temp is null & display all of the data
    while (temp != null) {
      System.out.print("|p|" + temp.data + "|n|<->");
      temp = temp.next;
    }

    System.out.print("null");
    System.out.println();
  }

  public void printBackward() { // TC -> O(n)
    // corner case => DoublyLinkedList is empty
    if (tail == null) {
      System.out.println("DoublyLinkedList is empty..........");
      return;
    }

    // step1 => temp Node point to the head Node
    Node temp = tail;
    // step2 => run a loop until temp is null & display all of the data
    System.out.print("null");
    while (temp != null) {
      System.out.print("<->|p|" + temp.data + "|n|");
      temp = temp.prev;
    }

    System.out.println();
  }
  /*---- ----*/

  /*---- add a Node at the first of DoublyLinkedList ----*/
  public void addFirst(DataType data) { // TC -> O(1)
    // step1 => create a newNode
    Node newNode = new Node(data);
    // corner case => DoublyLinkedList is empty
    if (head == null) {
      head = tail = newNode;
      size++;
      return;
    }

    // step2 => connect the newNode with head Node
    newNode.next = head;
    head.prev = newNode;
    size++; // increase the size of DoublyLinkedList
    // step3 => newNode become head Node
    head = newNode;
  }
  /*---- ----*/

  /*---- add a Node at the end of DoublyLinkedList ----*/
  public void addLast(DataType data) { // TC -> O(1)
    // step1 => create a newNode
    Node newNode = new Node(data);
    // corner case => DoublyLinkedList is empty
    if (head == null) {
      head = tail = newNode;
      size++;
      return;
    }

    // step2 => connect the newNode with head Node
    newNode.prev = tail;
    tail.next = newNode;
    size++; // increase the size of DoublyLinkedList
    // step3 => newNode become head Node
    tail = newNode;
  }
  /*---- ----*/

  /*---- add  a Node with index ----*/
  public void addWithIndex(int index, DataType data) { // TC -> O(n)
    // corner case => add Node at Oth index
    if (index == 0) {
      addFirst(data);
      return;
    }
    // corner case => add Node at nth index
    if (index == size) {
      addLast(data);
      return;
    }
    // corner case => index is greater than size
    if (index >= size) {
      System.out.println("index is greater than size..........unable to put Node");
      return;
    }

    // step1 => create a new Node & temp Node point to head
    Node newNode = new Node(data);
    Node temp = head;

    // step2 => run a loop until find out index
    int i = 0;
    while (i <= index - 1) {
      temp = temp.next;
      i++;
    }

    // step3 => create prevNode, previous Node of temp Node
    Node prevNode = temp.prev;

    // step4 => build connection between prevNode, newNode, temp
    prevNode.next = newNode;
    newNode.prev = prevNode;

    temp.prev = newNode;
    newNode.next = temp;

  }
  /*---- ----*/

  /*---- remove the first Node of DoublyLinkedList ----*/
  public DataType removeFirst() { // TC -> O(1)
    // corner case 1 => DoublyLinkedList is empty
    if (head == null) {
      System.out.println("DoublyLinkedList is empty..........");
      return null;
    }
    // corner case 2 => DoublyLinkedList has only one Node
    if (head.next == null) {
      Node del = head;
      head = tail = null;
      size = 0;
      return del.data;
    }
    // step1 => temp Node point to the first Node
    Node del = head;
    // step2 => move head to next Node
    head = head.next;
    // step3 => disconnect the del Node from DoublyLinkedList
    del.next = null;
    head.prev = null;

    size--; // decrease the length of DoublyLinkedList

    return del.data;
  }
  /*---- ----*/

  /*---- remove the last Node of DoublyLinkedList ----*/
  public DataType removeLast() { // TC -> O(1)
    // corner case 1 => DoublyLinkedList is empty
    if (head == null) {
      System.out.println("DoublyLinkedList is empty..........");
      return null;
    }
    // corner case 2 => DoublyLinkedList has only one Node
    if (head.next == null) {
      Node del = head;
      head = tail = null;
      size = 0;
      return del.data;
    }
    // step1 => temp Node point to the last Node
    Node del = tail;
    // step2 => move tail to prev Node
    tail = tail.prev;
    // step3 => disconnect the del Node from DoublyLinkedList
    del.prev = null;
    tail.next = null;

    size--; // decrease the length of DoublyLinkedList

    return del.data;
  }
  /*---- ----*/

  /*---- remove a Node with index ----*/
  public DataType removeWithIndex(int index) { // TC -> O(n)
    // corner case 1 => remove first Node
    if (index == 0) {
      return removeFirst();
    }
    // corner case 2 => remove last Node
    if (index == size - 1) {
      return removeLast();
    }
    // corner case 3 => index is greater than size
    if (index >= size) {
      System.out.println("At index " + index + " no Node is there.........");
      return null;
    }
    // step1 => del Node point to head Node
    Node del = head;
    // step2 => run a loop until find out the Node with index to delete
    int i = 0;
    while (i <= index - 1) {
      del = del.next;
      i++;
    }
    // step3 => create prevNode & nextNode point to previous & next Node of del Node
    Node prevNode = del.prev;
    Node nextNode = del.next;
    // step4 => disconnect the del Node
    prevNode.next = nextNode;
    nextNode.prev = prevNode;

    del.next = del.prev = null;
    size++;

    return del.data;
  }
  /*---- ----*/
}

public class Implement_DoublyLinkedList {
  public static void main(String[] args) {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    dll.addFirst(0);
    dll.addFirst(1);
    dll.addFirst(2);
    dll.addFirst(3);
    dll.addLast(4);
    dll.addLast(5);
    dll.addLast(6);
    dll.addLast(7);
    dll.printForward();
    // dll.printBackward();

    // dll.addWithIndex(1, -11);
    dll.removeWithIndex(8);
    dll.printForward();

    // dll.removeFirst();
    // dll.printForward();
    // dll.removeLast();
    // dll.printForward();
  }
}
