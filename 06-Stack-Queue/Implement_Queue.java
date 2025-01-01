class QueueWithArray {
  /*---- Create a Queue ----*/
  int[] arr;
  int n;
  int rear;

  QueueWithArray(int capacity) {
    this.arr = new int[capacity];
    this.n = capacity;
    rear = -1;
  }
  /*---- ----*/

  /*---- add a data into queue ----*/
  public void add(int data) {
    // corner case => queue is full
    if (rear == n - 1) {
      System.out.println(">> Queue is full, can't add new data.........");
      return;
    }

    arr[++rear] = data;
  }
  /*---- ----*/

  /*---- remove data from the queue ----*/
  public int remove() {
    // corner case 1 => queue is empty
    if (rear == -1) {
      System.out.println(">> queue is empty..........");
      return Integer.MIN_VALUE;
    }
    // corner case 2 => queue only have 1 data point
    if (rear == 0) {
      int del = arr[rear];
      arr[rear] = 0;
      rear = -1;
      return del;
    }
    // step1 => front data is going to delete
    int del = arr[0];
    // step2 => copy all the into previous index
    for (int i = 0; i < rear; i++) {
      arr[i] = arr[i + 1];
    }
    // step3 => reduce the rear by 1, and rear index value will be zero(0)
    arr[rear--] = 0;

    return del;
  }
  /*---- ----*/

  /*---- peek into the queue ----*/
  public int peek() {
    if (rear == -1) {
      System.out.println(">> queue is empty..........");
      return Integer.MIN_VALUE;
    }

    return arr[0];
  }
  /*---- ----*/

  public boolean isEmpty() {
    return rear == -1;
  }
}

class QueueWithLinkedList<DataType> {
  /*---- Node ----*/
  class Node {
    DataType data;
    Node next;

    Node(DataType data) {
      this.data = data;
      this.next = null;
    }
  }
  /*---- ----*/

  /*---- Create a Queue ----*/
  public Node head;
  public Node tail;
  /*----  ----*/

  /*---- add a data into queue ----*/
  public void add(DataType data) {
    // step1 => create a new Node
    Node newNode = new Node(data);
    // corner case => queue is empty
    if (head == null) {
      head = tail = newNode;
    }
    // step2 => connect the Node at the rare side
    tail.next = newNode;
    // step3 => newNode become tail Node
    tail = newNode;
  }
  /*---- ----*/

  /*---- remove data from queue ----*/
  public DataType remove() {
    // step1 => del Node point to the first Node of Queue
    Node del = head;
    // corner case 1 => queue is empty
    if (head == null) {
      System.out.println(">> Queue is empty ..........");
      return null;
    }
    // corner case 2 => only 1 data
    if (head.next == null) {
      head = tail = null;
      return del.data;
    }
    // step2 => head move to next data Node
    head = head.next;
    // step3 => disconnect the del Node
    del.next = null;

    return del.data;
  }
  /*---- ----*/

  /*---- peek into the queue ----*/
  public DataType peek() {
    if (head == null) {
      System.out.println(">>queue is empty..........");
      return null;
    }

    return head.data;
  }
  /*---- ----*/

  /*---- normal print in linked list ----*/
  void printLL() {
    if (head == null) {
      System.out.println("Queue is empty..........");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }
  /*---- ----*/
}

public class Implement_Queue {
  public static void main(String[] args) {
    QueueWithLinkedList<Integer> qll = new QueueWithLinkedList<>();
    qll.add(0);
    qll.add(1);
    qll.add(2);
    qll.add(3);

    qll.printLL();
    qll.remove();

    qll.printLL();

    System.out.println("-----------------------------------------");

    QueueWithArray qa = new QueueWithArray(10);
    qa.add(1);
    qa.add(2);
    qa.add(3);

    // qa.remove();
    // qa.remove();
    System.out.println("----Print----");
    while (!qa.isEmpty()) {
      System.out.println(qa.peek());
      qa.remove();
    }
  }
}
