/*
LC155: Min Stack || https://leetcode.com/problems/min-stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

+ MinStack() initializes the stack object.
+ void push(int val) pushes the element val onto the stack.
+ void pop() removes the element on the top of the stack.
+ int top() gets the top element of the stack.
+ int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.


Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:
-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.Stack;

//Time Complexity O(1) || Space Complexity: O(n)
class MinStack1 {
  private int min = Integer.MAX_VALUE; // store the minimum value
  private Stack<Integer> stk;

  public MinStack1() {
    this.stk = new Stack<>();
  }

  public void push(int data) {
    // check if the min value is greater than current data
    // then first push the min into stk
    // and min store the data(which is current minimum value)
    if (data <= min) {
      stk.push(min);
      min = data;
    }

    // now push actual data into stack
    stk.push(data);
  }

  public void pop() {
    // check if stack's top & min are the same
    // then pop() twice & change current minimum value to the last minimum value
    if (stk.peek() == min) {
      stk.pop();
      min = stk.pop();
    } else { // if top & min are not the same, just pop() once
      stk.pop();
    }
  }

  public int top() {
    return stk.peek();
  }

  public int getMin() {
    return min;
  }
}

// Time Complexity O(1) || Space Complexity: O(n)
class MinStack2 {
  // store the data & current minimum value in pair
  class Pair {
    int data;
    int min;

    Pair(int data, int min) {
      this.data = data;
      this.min = min;
    }
  }

  private Stack<Pair> stk;

  MinStack2() {
    stk = new Stack<>();
  }

  public void push(int data) {
    int min;
    // check if stack is empty or not
    if (stk.isEmpty()) {
      min = data; // if empty -> data become the min
    } else {
      // if not empty -> calculate the minimum between previous min & current data
      min = Math.min(stk.peek().min, data);
    }

    // push data & min pair into stack
    stk.push(new Pair(data, min));
  }

  public void pop() {
    stk.pop();
  }

  public int top() {
    return stk.peek().data;
  }

  public int getMin() {
    return stk.peek().min;
  }
}

// Time Complexity O(1) || Space Complexity: O(m*n)
class MinStack3 {
  Stack<Integer> stack;
  Stack<Integer> minStack;

  public MinStack3() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int data) {
    // first push the data into stack
    stack.push(data);

    // check if minStack is empty OR data is smaller than minimum value
    if (minStack.isEmpty() || data <= minStack.peek()) {
      minStack.push(data);
    }
  }

  public void pop() {
    // first pop from stack
    int pop = stack.pop();

    // check if both minStack & pop are the same
    // change current minimum value to the last minimum value
    if (pop == minStack.peek())
      minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}

public class Stack02_MinStack {
  public static void main(String[] args) {
    MinStack1 obj1 = new MinStack1();
    obj1.push(5);
    obj1.push(6);
    obj1.push(3);
    obj1.push(7);
    obj1.push(1);

    obj1.pop();
    // obj1.pop();
    // obj1.pop();
    // obj1.pop();
    System.out.println(obj1.top());
    System.out.println(obj1.getMin());

    System.out.println("---- ----");

    MinStack2 obj2 = new MinStack2();
    obj2.push(5);
    obj2.push(6);
    obj2.push(3);
    obj2.push(7);
    obj2.push(1);

    obj2.pop();
    // obj2.pop();
    // obj2.pop();
    // obj2.pop();
    System.out.println(obj2.top());
    System.out.println(obj2.getMin());
  }
}
