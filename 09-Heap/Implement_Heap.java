import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinHeap {

  ArrayList<Integer> heap;

  MinHeap() {
    heap = new ArrayList<>();
  }

  /*---- Calling function ----*/
  public void add(int data) {
    insert(data);
  }

  public void remove() {
    System.out.println("remove >> " + removeValue());
  }

  public void peek() {
    System.out.println("peek >> " + heap.get(0));
  }

  public void show() {
    System.out.println("MaxHeap >> " + heap);
  }
  /*----  ----*/

  /*---- working function ----*/

  /*---- insert data into heap ----*/
  private void insert(int data) {
    // step1 => add value into Heap
    heap.add(data);

    // step2 => fix the heap

    int childIndex = heap.size() - 1;
    int parentIndex = (childIndex - 1) / 2;

    while (heap.get(childIndex) < heap.get(parentIndex)) {
      // swap
      swap(childIndex, parentIndex);

      // update values
      childIndex = parentIndex;
      parentIndex = (childIndex - 1) / 2;
    }
  }
  /*----  ----*/

  /*---- remove data from heap ----*/
  private int removeValue() {
    int del = heap.get(0);
    int n = heap.size();

    // step1 => swap first & last values from heap
    swap(0, n - 1);
    // step2 => remove last value from heap
    heap.remove(n - 1);
    // step3 => fix the heap
    heapify(0);

    return del;
  }
  /*----  ----*/
  /*----  ----*/

  /*---- helper function ----*/
  private void heapify(int idx) {
    // step1 => calculate child index
    int minIdx = idx;
    int leftChildIdx = minIdx * 2 + 1;
    int rightChildIdx = minIdx * 2 + 2;

    // step2 => search for minimum value in both side
    if (leftChildIdx < heap.size() && heap.get(minIdx) > heap.get(leftChildIdx)) { // left side
      minIdx = leftChildIdx;
    }
    if (rightChildIdx < heap.size() && heap.get(minIdx) > heap.get(rightChildIdx)) { // right side
      minIdx = rightChildIdx;
    }

    // step3 => fix the heap
    if (minIdx != idx) {
      swap(idx, minIdx);
      heapify(minIdx);
    }
  }

  private void swap(int i, int j) {
    int swap = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, swap);
  }
  /*---- ----*/
}

class MaxHeap {
  ArrayList<Integer> heap;

  MaxHeap() {
    heap = new ArrayList<>();
  }

  /*---- Calling function ----*/
  public void add(int data) {
    insert(data);
  }

  public void remove() {
    System.out.println("remove >> " + removeValue());
  }

  public void peek() {
    System.out.println("peek >> " + heap.get(0));
  }

  public void show() {
    System.out.println("MaxHeap >> " + heap);
  }
  /*----  ----*/

  /*---- working function ----*/

  /*---- insert data into heap ----*/
  private void insert(int data) {
    // step1 => add value into Heap
    heap.add(data);

    // step2 => fix the heap

    int childIndex = heap.size() - 1;
    int parentIndex = (childIndex - 1) / 2;

    while (heap.get(childIndex) > heap.get(parentIndex)) {
      // swap
      swap(childIndex, parentIndex);

      // update values
      childIndex = parentIndex;
      parentIndex = (childIndex - 1) / 2;
    }
  }
  /*----  ----*/

  /*---- remove data from heap ----*/
  private int removeValue() {
    int del = heap.get(0);
    int n = heap.size();

    // step1 => swap first & last values from heap
    swap(0, n - 1);
    // step2 => remove last value from heap
    heap.remove(n - 1);
    // step3 => fix the heap
    heapify(0);

    return del;
  }
  /*----  ----*/
  /*----  ----*/

  /*---- helper function ----*/
  private void heapify(int idx) {
    // step1 => calculate child index
    int maxIdx = idx;
    int leftChildIdx = maxIdx * 2 + 1;
    int rightChildIdx = maxIdx * 2 + 2;

    // step2 => search for minimum value in both side
    if (leftChildIdx < heap.size() && heap.get(maxIdx) < heap.get(leftChildIdx)) { // left side
      maxIdx = leftChildIdx;
    }
    if (rightChildIdx < heap.size() && heap.get(maxIdx) < heap.get(rightChildIdx)) { // right side
      maxIdx = rightChildIdx;
    }

    // step3 => fix the heap
    if (maxIdx != idx) {
      swap(idx, maxIdx);
      heapify(maxIdx);
    }
  }

  private void swap(int i, int j) {
    int swap = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, swap);
  }
  /*---- ----*/
}

public class Implement_Heap {
  static class Student implements Comparable<Student> {
    String name;
    int rank;

    Student(String name, int rank) {
      this.name = name;
      this.rank = rank;
    }

    @Override
    public int compareTo(Student s2) {
      return this.rank - s2.rank;
    }
  }

  public static void main(String[] args) {
    MinHeap mh = new MinHeap();
    mh.add(5);
    mh.add(9);
    mh.add(7);
    mh.add(8);
    mh.add(1);

    mh.show(); // [1,5,7,8,9]

    mh.peek();
    mh.remove();
    // mh.remove();
    mh.show();// [5,8,7,9]

    System.out.println("---------- ---------");

    MaxHeap maxH = new MaxHeap();
    maxH.add(5);
    maxH.add(6);
    maxH.add(7);
    maxH.add(8);
    maxH.add(1);

    maxH.show(); // [8,7,6,5,1]

    maxH.peek();

    maxH.remove();
    // maxH.remove();
    maxH.show(); // [7,5,6,1]

    System.out.println("---------- Heap using Priority Queue ---------");

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.add(10);
    pq.add(1);
    pq.add(0);
    pq.add(5);

    while (!pq.isEmpty()) {
      System.out.println(pq.remove());
    }

    System.out.println("---------- ---------");

    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());

    pq1.add(10);
    pq1.add(1);
    pq1.add(0);
    pq1.add(5);

    while (!pq1.isEmpty()) {
      System.out.println(pq1.remove());
    }

    System.out.println("---------- ---------");

    PriorityQueue<Student> sPQ = new PriorityQueue<>();
    sPQ.add(new Student("a", 100));
    sPQ.add(new Student("b", 1));
    sPQ.add(new Student("c", 55));
    sPQ.add(new Student("d", 12));

    while (!sPQ.isEmpty()) {
      System.out.println(sPQ.peek().name + "->" + sPQ.peek().rank);
      sPQ.remove();
    }
  }
}