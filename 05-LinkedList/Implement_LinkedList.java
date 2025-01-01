class LinkedList<DataType> {
  /*---- Node ----*/
  class Node {
    DataType data;
    Node next;

    Node(DataType data) {
      this.data = data; // Node's data
      this.next = null; // by default every Node point to null
    }
  }
  /*---- ----*/

  public Node head; // this will point to the first Node of LinkedList
  public Node tail; // this will point to the tail Node of LinkedList
  public static int size; // this will track the size of LinkedList

  /*---- Print Linked List ----*/
  public void print() { // TC -> O(n)
    // corner case => LinkedList is empty
    if (head == null) {
      System.out.println("Linked List is Empty..........");
      return;
    }

    // step1 => a temp node point to head node/first node (because if we use head
    // node to print, head will not point to the first Node)
    Node temp = head;
    // step2 => run a loop until temp node is null
    while (temp != null) {
      // step3 => display the data
      System.out.print("|" + temp.data + "|-> ");
      // step4 => change the node to it's next
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }
  /*---- ----*/

  /*---- add a Node at first of LinkedList ----*/
  public void addFirst(DataType data) { // TC -> O(1)
    // step1 => Create a newNode Node
    Node newNode = new Node(data);

    // corner case => LinkedList is empty
    if (head == null) {
      head = tail = newNode; // connect the newNode Node
      size++; // increase the size of LinkedList
      return;
    }
    // step2 => connect newNode Node to head Node
    newNode.next = head;
    size++; // increase the size of LinkedList
    // step3 => newNode Node becomes head
    head = newNode;
  }
  /*---- ----*/

  /*---- add a Node at the last of the LinkedList ----*/
  public void addLast(DataType data) { // TC -> O(1)
    // step1 => Create a newNode Node
    Node newNode = new Node(data);

    // corner case => LinkedList is empty
    if (head == null) {
      head = tail = newNode;
      size++; // increase the size of LinkedList
      return;
    }
    // step2 => connect tail to newNode
    tail.next = newNode;
    size++; // increase the size of the LinkedList
    // step3 => newNode becomes tail Node
    tail = newNode;
  }
  /*---- ----*/

  /*---- add a Node with index ----*/
  public void addWithIndex(DataType data, int index) { // TC -> O(n)
    // corner case 1 => index is zero
    if (index == 0) {
      addFirst(data);
      return;
    }
    // corner case 2 => index is greater than size of LinkedList
    if (index > size) {
      System.out.println("unable to put the Node..........cause index is greater than size of LinkedList");
      return;
    }

    // step1 => Create a New Node
    Node newNode = new Node(data);
    // step2 => run a loop until we found the previous index Node
    Node prev = head;
    int i = 0;

    while (i < index - 1) {
      prev = prev.next;
      i++;
    }

    // step3 => newNode point to next index Node
    newNode.next = prev.next;
    // step4 => previous index Node points to newNode
    prev.next = newNode;
    size++; // increase the size of the LinkedList
  }
  /*---- ----*/

  /*---- remove first Node of the LinkedList ----*/
  public DataType removeFirst() { // TC -> O(1)
    // step1 => temp Node point to head Node
    Node temp = head;
    // corner case 1 => LinkedList is empty
    if (head == null) {
      System.out.println("Linked List is Empty..........");
      return null;
    }
    // corner case 2 => only one Node in LinkedList
    if (head.next == null) {
      head = tail = null;
      size = 0;
      return temp.data;
    }

    // step2 => head Node shift to next Node
    head = head.next;
    // step3 => disconnect temp Node from LinkedList
    temp.next = null;
    size--; // decrease the size of LinkedList

    return temp.data;
  }
  /*---- ----*/

  /*---- remove last Node of the LinkedList ----*/
  public DataType removeLast() { // TC -> o(n)
    // corner case 1 => LinkedList is empty
    if (head == null) {
      System.out.println("Linked List is Empty..........");
      return null;
    }
    // corner case 2 => only one node in LinkedList
    if (head.next == null) {
      Node temp = head;
      head = tail = null;
      size = 0;
      return temp.data;
    }

    // step1 => prev Node & temp Node to find out 2nd last Node
    Node prev = head;
    Node temp = head.next.next;
    // step2 => run a loop and reach to the 2nd last Node
    while (temp != null) {
      prev = prev.next;
      temp = temp.next;
    }

    Node del = prev;
    // step3 => 2nd last node point to null and disconnect the last Node
    prev.next = null;
    // step4 => now tail will point to prev Node
    tail = prev;
    size--; // decrease the size of LinkedList

    return del.data;
  }
  /*---- ----*/

  /*---- remove a Node with Index ----*/
  public DataType removeWithIndex(int index) { // TC -> O(n)
    // corner case 3 => index is greater than size of LinkedList
    if (index > size) {
      System.out.println("unable to put the Node..........cause index is greater than size of LinkedList");
      return null;
    }
    // corner case 1 => LinkedList is empty
    if (head == null) {
      System.out.println("Linked List is Empty..........");
      return null;
    }
    // corner case 2 => when LinkedList have only 1 Node
    if (head.next == null) {
      Node del = head;
      head = tail = null;
      size = 0;
      return del.data;
    }

    // step1 => create a prev Node point to head node & del Node point to 2nd Node
    Node prev = head;
    Node del = head.next;
    // step2 => run a loop until we found the index
    int i = 0;
    while (i < index - 1) {
      prev = prev.next;
      del = del.next;
      i++;
    }
    // step3 => prev Node connect to del Node's next Node
    prev.next = del.next;
    // step4 => disconnect the del Node from the LinkedList
    del.next = null;
    size--; // decrese the size of LinkedList

    return del.data;
  }
  /*---- ----*/

  /*---- Search in LinkedList ----*/
  public int itrSearch(DataType key) { // TC -> O(n)
    int i = 0;
    Node temp = head;

    while (temp != null) {
      if (temp.data == key) { // check
        return i;
      }
      temp = temp.next;
      i++;
    }
    return -1;
  }

  public int recursiveSearch(DataType key) { // TC -> O(n)
    return helper(head, key);
  }

  private int helper(Node head, DataType key) {
    // base case -> empty LinkedList
    if (head == null) {
      return -1;
    }
    // Check
    if (head.data == key) {
      return 0;
    }
    // recursive call
    int idx = helper(head.next, key);
    if (idx == -1) {
      return -1;
    }
    return idx + 1;
  }
  /*---- ----*/

  /*---- Reverse LinkedLIst ----*/
  public void reverse() {
    Node prev = null;
    Node curr = head;
    Node nxt;

    while (curr != null) {
      // step1 -> next node of curr is nxt Node
      nxt = curr.next;
      // step2 -> curr Node point to prev Node
      curr.next = prev;
      // Step3 -> prev Node Becomes curr Node
      prev = curr;
      // step4 -> curr Node become nxt Node
      curr = nxt;
    }

    head = prev;
  }
  /*---- ----*/
}

public class Implement_LinkedList {
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();

    ll.print();

    ll.addFirst(10);
    ll.addFirst(5);
    ll.addFirst(-10);

    ll.print();

    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);

    ll.print();

    ll.removeFirst();

    ll.print();

    ll.removeLast();

    ll.print();

    ll.addWithIndex(11, 2);

    ll.print();

    ll.removeWithIndex(3);

    ll.print();

    System.out.println(ll.itrSearch(7));
    System.out.println(ll.recursiveSearch(7));

    ll.reverse();
    ll.print();
  }
}
