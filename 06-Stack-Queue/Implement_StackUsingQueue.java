import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

class Stack1 {
  Queue<Integer> q1, q2;

  /*---- create a Stack ----*/
  Stack1() {
    this.q1 = new LinkedList<Integer>();
    this.q2 = new LinkedList<Integer>();
  }
  /*---- ----*/

  /*---- is empty ----*/
  public boolean isEmpty() {
    return q1.isEmpty() && q2.isEmpty();
  }
  /*---- ----*/

  /*---- push a data into Stack ----*/
  public void push(int data) { // TC => O(n)
    // corner case => empty stack only add single data into q1
    if (isEmpty()) {
      q1.add(data);
      return;
    }

    // step1 => run a loop until move all data from q1 to q2
    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }
    // step2 => add a data into q1
    q1.add(data);
    // step3 => run a loop until move all data from q2 to q1
    while (!q2.isEmpty()) {
      q1.add(q2.remove());
    }
  }
  /*---- ----*/

  /*---- pop a data from Stack ----*/
  public int pop() { // TC -> O(1)
    if (isEmpty()) {
      System.out.println(">> Stack is empty..........");
      return Integer.MIN_VALUE;
    }

    return q1.remove();
  }
  /*---- ----*/

  /*---- peek into the Stack ----*/
  public int peek() { // TC -> O(1)
    if (isEmpty()) {
      System.out.println(">> Stack is empty..........");
      return Integer.MIN_VALUE;
    }

    return q1.peek();
  }
  /*---- ----*/
}

class Stack2 {
  Queue<Integer> q1, q2;

  /*---- create a Stack ----*/
  Stack2() {
    this.q1 = new LinkedList<Integer>();
    this.q2 = new LinkedList<Integer>();
  }
  /*---- ----*/

  /*---- is empty ----*/
  public boolean isEmpty() {
    return q1.isEmpty() && q2.isEmpty();
  }
  /*---- ----*/

  /*---- push a data into Stack ----*/
  public void push(int data) { // TC => O(1)
    q1.add(data);
  }
  /*---- ----*/

  /*---- pop a data from Stack ----*/
  public int pop() { // TC -> O(n)
    if (isEmpty()) {
      System.out.println(">> Stack is empty..........");
      return Integer.MIN_VALUE;
    }

    int del = -1;
    // step1 => run a loop AND move all element from q1 to q2 until we remove last
    // element
    while (!q1.isEmpty()) {

      del = q1.remove();
      // step2 => remove last element from q1
      if (q1.isEmpty()) {
        break;
      }
      q2.add(del);
    }
    // step3 => run a loop AND move all element from q2 to q1
    while (!q2.isEmpty()) {
      q1.add(q2.remove());
    }

    return del;
  }
  /*---- ----*/

  /*---- peek into the Stack ----*/
  public int peek() { // TC -> O(n)
    if (isEmpty()) {
      System.out.println(">> Stack is empty..........");
      return Integer.MIN_VALUE;
    }

    int del = -1;
    // step1 => run a loop AND move all element from q1 to q2 until we remove last
    // element
    while (!q1.isEmpty()) {
      // step2 => last element
      del = q1.remove();
      q2.add(del);
    }

    // step3 => run a loop AND move all element from q2 to q1
    while (!q2.isEmpty()) {
      q1.add(q2.remove());
    }

    return del;
  }
  /*---- ----*/
}

class StackUsingDeque {
  Deque<Integer> dq = new LinkedList<>();

  boolean isEmpty() {
    return dq.isEmpty();
  }

  void push(int data) {
    dq.addFirst(data);
  }

  int pop() {
    if (isEmpty()) {
      System.out.println("Stack is Empty...........");
      return Integer.MIN_VALUE;
    }

    return dq.removeFirst();
  }

  int peek() {
    if (isEmpty()) {
      System.out.println("Stack is Empty...........");
      return Integer.MIN_VALUE;
    }

    return dq.getFirst();
  }
}

public class Implement_StackUsingQueue {
  public static void main(String[] args) {

    Stack1 s1 = new Stack1();
    s1.push(0);
    s1.push(1);
    s1.push(2);
    s1.push(3);

    while (!s1.isEmpty()) {
      System.out.println(s1.peek());
      s1.pop();
    }

    System.out.println("-------------------------");

    Stack2 s2 = new Stack2();
    s2.push(0);
    s2.push(1);
    s2.push(2);
    s2.push(3);

    while (!s2.isEmpty()) {
      System.out.println(s2.peek());
      s2.pop();
    }

    System.out.println("-------------------------");

    StackUsingDeque s3 = new StackUsingDeque();
    s3.push(0);
    s3.push(1);
    s3.push(2);
    s3.push(3);

    while (!s3.isEmpty()) {
      System.out.println(s3.peek());
      s3.pop();
    }
  }
}