import java.util.ArrayList;
import java.util.Scanner;

class MergeSort {
  int[] arr;
  int n;

  /*---- constructor ----*/
  MergeSort(int[] data) {
    this.arr = data;
    this.n = data.length;
  }

  MergeSort() {
    inputData();
  }
  /*---- ----*/

  /*---- Print the Array ----*/
  public void printData() {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
  /*---- ----*/

  /*---- take input from user ----*/
  private void inputData() {
    Scanner scn = new Scanner(System.in);

    System.out.print("Enter the size of your array >> ");
    n = scn.nextInt();
    arr = new int[n];

    System.out.println("-------- Enter " + n + " Data --------");
    for (int i = 0; i < n; i++) {
      System.out.print("\tarr[" + i + "] = ");
      arr[i] = scn.nextInt(); // here we take the input from user
    }
    System.out.println("\t----- -----");

    scn.close();
  }
  /*---- ----*/

  public void ascendingOrder() {
    int startIdx = 0, endIdx = arr.length - 1;
    mergeSort(startIdx, endIdx);
  }

  private void mergeSort(int startIdx, int endIdx) {
    if (startIdx >= endIdx) {
      return;
    }

    int midIdx = startIdx + (endIdx - startIdx) / 2;
    mergeSort(startIdx, midIdx);
    mergeSort(midIdx + 1, endIdx);
    merge(startIdx, midIdx, endIdx);
  }

  private void merge(int startIdx, int midIdx, int endIdx) {
    ArrayList<Integer> temp = new ArrayList<>(); // temporary array

    // 2 pointers
    int left = startIdx, right = midIdx + 1;

    // sorting
    while (left <= midIdx && right <= endIdx) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left++]);
      } else {
        temp.add(arr[right++]);
      }
    }

    // copy rest of the values
    while (left <= midIdx) {
      temp.add(arr[left++]);
    }
    while (right <= endIdx) {
      temp.add(arr[right++]);
    }

    // re-write the arr with the sorted Data
    for (int i = startIdx; i < endIdx; i++) {
      arr[i] = temp.get(i - startIdx);
    }
  }

}

public class SA04_MergeSort {
  public static void main(String[] args) {
    System.out.println("--------------------------------------");
    int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

    MergeSort ms = new MergeSort(data); // use this when u have pre-defined dataset
    System.out.print("Original array > ");
    ms.printData();
    ms.ascendingOrder();
    System.out.print("Sorted array(ascending) >> ");
    ms.printData();
    System.out.println("--------------------------------------");

    System.out.println("--------------------------------------");
    MergeSort ms1 = new MergeSort(); // use this when u want to give the data at run time
    System.out.print("Original array >> ");
    ms1.printData();
    ms1.ascendingOrder();
    System.out.print("Sorted array(ascending)>> ");
    ms1.printData();
    System.out.println("--------------------------------------");

  }
}
