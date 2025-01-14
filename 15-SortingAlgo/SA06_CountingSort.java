import java.util.Scanner;

class CountingSort {
  int[] arr; // store the data
  int n; // size of the array

  /*----- constructor ----- */
  CountingSort(int[] data) { // passing the data at the time of creating a object
    this.arr = data;
    this.n = data.length;
  }

  CountingSort() { // when...we don't have the data to pass...we want to pass the data at run time
    inputData();
  }
  /*----- ----- */

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

  /*---- Ascending Order Sorting(only this part is required to understand Insertion Sort) ----*/
  public void ascendingOrder() { // TC -> O(n^2)
    int large = Integer.MIN_VALUE;

    // step1 => find out largest value in array
    for (int i = 0; i < arr.length; i++) {
      large = Math.max(large, arr[i]);
    }
    // step2 => counting each numbers frequency
    int[] count = new int[large + 1];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i]]++;
    }

    // step3 => change the original array according to the frequency
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        arr[index++] = i;
        count[i]--;
      }
    }
  }
  /*---- ----*/

  /*---- Descending Order Sorting ----*/
  public void descendingOrder() { // TC -> O(n^2)
    int large = Integer.MIN_VALUE;
    // step1 => find out largest value in array
    for (int i = 0; i < arr.length; i++) {
      large = Math.max(large, arr[i]);
    }
    // step2 => counting each numbers frequency
    int[] count = new int[large + 1];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i]]++;
    }

    // step3 => change the original array according to the frequency
    int index = 0;
    for (int i = count.length - 1; i >= 0; i--) {
      while (count[i] > 0) {
        arr[index++] = i;
        count[i]--;
      }
    }
  }
  /*---- ----*/
}

public class SA06_CountingSort {
  public static void main(String[] args) {
    System.out.println("--------------------------------------");
    int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

    CountingSort cs = new CountingSort(data); // use this when u have pre-defined dataset
    System.out.print("Original array > ");
    cs.printData();
    cs.ascendingOrder();
    System.out.print("Sorted array(ascending) >> ");
    cs.printData();
    cs.descendingOrder();
    System.out.print("Sorted array(descending) >> ");
    cs.printData();
    System.out.println("--------------------------------------");

    System.out.println("--------------------------------------");
    CountingSort cs1 = new CountingSort(); // use this when u want to give the data at run time
    System.out.print("Original array >> ");
    cs1.printData();
    cs1.ascendingOrder();
    System.out.print("Sorted array(ascending)>> ");
    cs1.printData();
    cs1.descendingOrder();
    System.out.print("Sorted array(descending)>> ");
    cs1.printData();
    System.out.println("--------------------------------------");
  }
}