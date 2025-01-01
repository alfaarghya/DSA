import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Queue1<DataType> {
  Stack<DataType> s1, s2;

  /*---- create a Queue ----*/
  Queue1() {
    this.s1 = new Stack<>();
    this.s2 = new Stack<>();
  }
  /*---- ----*/

  /*---- is empty ----*/
  public boolean isEmpty() {
    return s1.isEmpty() && s2.isEmpty();
  }
  /*---- ----*/

  /*---- add a data into Queue ----*/
  public void add(DataType data) { // TC -> O(n)
    // corner case => Queue is empty
    if (isEmpty()) {
      s1.push(data);
      return;
    }

    // step1 => run a loop AND move all data from s1 to s2
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    // step1 => add a data into s1
    s1.push(data);
    // step2 => run a loop AND move all data from s2 to s1
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }
  /*---- ----*/

  /*---- remove data from Queue ----*/
  public DataType remove() { // TC -> O(1)
    // corner case => Queue is empty
    if (isEmpty()) {
      System.out.println(">> Queue is empty...........");
      return null;
    }

    return s1.pop();
  }
  /*---- ----*/

  /*---- remove data from Queue ----*/
  public DataType peek() { // TC -> O(1)
    // corner case => Queue is empty
    if (isEmpty()) {
      System.out.println(">> Queue is empty...........");
      return null;
    }

    return s1.peek();
  }
  /*---- ----*/

}

class Queue2<DataType> {
  Stack<DataType> s1, s2;

  /*---- create a Queue ----*/
  Queue2() {
    this.s1 = new Stack<>();
    this.s2 = new Stack<>();
  }
  /*---- ----*/

  /*---- is empty ----*/
  public boolean isEmpty() {
    return s1.isEmpty() && s2.isEmpty();
  }
  /*---- ----*/

  /*---- add a data into Queue ----*/
  public void add(DataType data) { // TC -> O(1)
    s1.add(data);
  }
  /*---- ----*/

  /*---- remove data from Queue ----*/
  public DataType remove() { // TC -> O(n)
    // corner case => Queue is empty
    if (isEmpty()) {
      System.out.println(">> Queue is empty...........");
      return null;
    }
    // step1 => run a loop AND move all data from s1 to s2
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    // step2 => remove top data from s2
    DataType del = s2.pop();
    // step3 => run a loop AND move all data from s2 to s1
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }

    return del;
  }
  /*---- ----*/

  /*---- remove data from Queue ----*/
  public DataType peek() { // TC -> O(n)
    // corner case => Queue is empty
    if (isEmpty()) {
      System.out.println(">> Queue is empty...........");
      return null;
    }

    // step1 => run a loop AND move all data from s1 to s2
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    // step2 => remove top data from s2
    DataType peek = s2.peek();
    // step3 => run a loop AND move all data from s2 to s1
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }

    return peek;
  }
  /*---- ----*/

}

class QueueUsingDeque<DataType> {
  Deque<DataType> dq = new LinkedList<>();

  boolean isEmpty() {
    return dq.isEmpty();
  }

  public void add(DataType data) {
    if (isEmpty()) {
      dq.addFirst(data);
      return;
    }

    dq.addLast(data);
  }

  public DataType remove() {
    if (isEmpty()) {
      System.out.println("Queue is empty.........");
      return null;
    }

    return dq.removeFirst();
  }

  public DataType peek() {
    if (isEmpty()) {
      System.out.println("Queue is empty.........");
      return null;
    }

    return dq.getFirst();
  }
}

public class Implement_QueueUsingStack {
  public static void main(String[] args) {
    Queue1<Integer> q1 = new Queue1<>();
    System.out.println(q1.isEmpty());
    q1.add(0);
    q1.add(1);
    q1.add(2);
    q1.add(3);
    q1.add(4);
    q1.add(5);

    while (!q1.isEmpty()) {
      System.out.print(q1.peek() + " ");
      q1.remove();
    }
    System.out.println("\n" + q1.isEmpty());

    System.out.println("------------------------------");

    Queue2<Integer> q2 = new Queue2<>();
    System.out.println(q2.isEmpty());
    q2.add(0);
    q2.add(1);
    q2.add(2);
    q2.add(3);
    q2.add(4);
    q2.add(5);

    while (!q2.isEmpty()) {
      System.out.print(q2.remove() + " ");
      // q2.remove();
    }
    System.out.println("\n" + q2.isEmpty());

    System.out.println("------------------------------");

    QueueUsingDeque<Integer> q3 = new QueueUsingDeque<>();
    System.out.println(q3.isEmpty());
    q3.add(0);
    q3.add(1);
    q3.add(2);
    q3.add(3);
    q3.add(4);
    q3.add(5);

    while (!q3.isEmpty()) {
      System.out.print(q3.remove() + " ");
      // q2.remove();
    }
    System.out.println("\n" + q3.isEmpty());

  }
}
