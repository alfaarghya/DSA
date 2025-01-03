import java.util.Scanner;

class HeapSort {

  int[] heap;
  int n;

  /*---- constructor ----*/
  HeapSort(int[] data) {
    this.heap = data;
    this.n = data.length;
  }

  HeapSort() {
    inputData();
  }

  /*---- ----*/

  /*---- Print the Array ----*/
  public void printData() {
    for (int i = 0; i < n; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }

  /*---- ----*/

  /*---- take input from user ----*/
  private void inputData() {
    Scanner scn = new Scanner(System.in);

    System.out.print("Enter the size of your array >> ");
    n = scn.nextInt();
    heap = new int[n];

    System.out.println("-------- Enter " + n + " Data --------");
    for (int i = 0; i < n; i++) {
      System.out.print("\tarr[" + i + "] = ");
      heap[i] = scn.nextInt(); // here we take the input from user
    }
    System.out.println("\t----- -----");

    scn.close();
  }
  /*---- ----*/

  /*---- Ascending Order Sorting ----*/
  public void ascendingOrder() {
    int n = heap.length;
    // step1 => build maxHeap form minHeap
    for (int i = n / 2; i >= 0; i--) {
      heapifyAscending(i, n);
    }

    // step2 => push the largest element to end
    for (int i = n - 1; i > 0; i--) {
      // swap between i & 0th index
      swap(0, i);
      // fix the heap
      heapifyAscending(0, i);
    }
  }
  /*---- ----*/

  /*---- Descending  Order Sorting ----*/
  /*
   * public void descendingOrder() {
   * 
   * // step1 => push the smallest element to end
   * for (int i = n - 1; i > 0; i--) {
   * // swap between i & 0th index
   * swap(0, i);
   * // fix the heap
   * heapifyDescending(0, i);
   * }
   * }
   */
  /*---- ----*/

  /*---- helper function ----*/
  private void heapifyAscending(int idx, int size) {

    // step1 => calculate child index
    int maxIdx = idx;
    int leftChildIdx = maxIdx * 2 + 1;
    int rightChildIdx = maxIdx * 2 + 2;

    // step2 => search for maximum value in both side
    if (leftChildIdx < size && heap[maxIdx] < heap[leftChildIdx]) { // left side
      maxIdx = leftChildIdx;
    }
    if (rightChildIdx < size && heap[maxIdx] < heap[rightChildIdx]) { // right side
      maxIdx = rightChildIdx;
    }

    // step3 => fix the heap
    if (maxIdx != idx) {
      swap(idx, maxIdx);
      heapifyAscending(maxIdx, size);
    }
  }

  /*
   * private void heapifyDescending(int idx, int size) {
   * 
   * // step1 => calculate child index
   * int minIdx = idx;
   * int leftChildIdx = minIdx * 2 + 1;
   * int rightChildIdx = minIdx * 2 + 2;
   * 
   * // step2 => search for minimum value in both side
   * if (leftChildIdx < size && heap[minIdx] > heap[leftChildIdx]) { // left side
   * minIdx = leftChildIdx;
   * }
   * if (rightChildIdx < size && heap[minIdx] > heap[rightChildIdx]) { // right
   * side
   * minIdx = rightChildIdx;
   * }
   * 
   * // step3 => fix the heap
   * if (minIdx != idx) {
   * swap(idx, minIdx);
   * heapifyAscending(minIdx, size);
   * }
   * }
   */

  private void swap(int i, int j) {
    int swap = heap[i];
    heap[i] = heap[j];
    heap[j] = swap;
  }
  /*---- ----*/

}

public class SA05_HeapSort {
  public static void main(String[] args) {
    System.out.println("--------------------------------------");
    int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

    HeapSort is = new HeapSort(data); // use this when u have pre-defined dataset
    System.out.print("Original array > ");
    is.printData();
    is.ascendingOrder();
    System.out.print("Sorted array(ascending) >> ");
    is.printData();
    // is.descendingOrder();
    // System.out.print("Sorted array(descending) >> ");
    // is.printData();
    System.out.println("--------------------------------------");

    System.out.println("--------------------------------------");
    HeapSort is1 = new HeapSort(); // use this when u want to give the data at run time
    System.out.print("Original array >> ");
    is1.printData();
    is1.ascendingOrder();
    System.out.print("Sorted array(ascending)>> ");
    is1.printData();
    // is1.descendingOrder();
    // System.out.print("Sorted array(descending)>> ");
    // is1.printData();
    System.out.println("--------------------------------------");
  }
}