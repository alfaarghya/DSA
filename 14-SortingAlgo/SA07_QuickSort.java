import java.util.Scanner;

class QuickSort {
  int[] arr;
  int n;

  /*---- constructor ----*/
  QuickSort(int[] data) {
    this.arr = data;
    this.n = data.length;
  }

  QuickSort() {
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

  //Time complexity: O(n log(n)) || Space complexity: O(1)
  public void ascendingOrder() {
    int low = 0, high = this.n - 1;
    quickSort(this.arr, low, high);
  }

  private void quickSort(int[] arr, int low, int high) {
    if(low < high) {
      //partition point
      int partitionPoint = partition(arr, low, high);
      
      //recursive call
      quickSort(arr, low, partitionPoint-1);
      quickSort(arr, partitionPoint+1, high);
    }
    
  }
  
  private int partition(int[] arr, int low, int high) {
    int pivot = low; //taking first point as pivot point
    int i = low, j = high; //pointers
    
    while(i < j) {

      //search element that is greater than pivot element
      while(arr[i] <= arr[pivot] && i <= high-1) {
        i++;
      }
      
      //search element that is smaller than pivot element
      while(arr[j] > arr[pivot] && j >= low+1) {
        j--;
      }

      //swap between large and small element
      if(i < j) {
        swap(arr, i,j);
      }
    }

    //swap between pivot point and smallest element
    swap(arr, pivot, j);

    return j;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

public class SA07_QuickSort {
  public static void main(String[] args) {
    System.out.println("--------------------------------------");
    int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

    QuickSort qs = new QuickSort(data); // use this when u have pre-defined dataset
    System.out.print("Original array > ");
    qs.printData();
    qs.ascendingOrder();
    System.out.print("Sorted array(ascending) >> ");
    qs.printData();
    System.out.println("--------------------------------------");

    System.out.println("--------------------------------------");
    QuickSort qs1 = new QuickSort(); // use this when u want to give the data at run time
    System.out.print("Original array >> ");
    qs1.printData();
    qs1.ascendingOrder();
    System.out.print("Sorted array(ascending)>> ");
    qs1.printData();
    System.out.println("--------------------------------------");
  }
}