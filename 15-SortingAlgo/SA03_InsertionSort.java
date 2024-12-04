import java.util.Scanner;

class InsertionSort {
    int[] arr; // store the data
    int n; // size of the array

    /*----- constructor ----- */
    InsertionSort(int[] data) { // passing the data at the time of creating a object
        this.arr = data;
        this.n = data.length;
    }

    InsertionSort() { // when...we don't have the data to pass...we want to pass the data at run time
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
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int previousIdx = i - 1;

            while (previousIdx >= 0 && arr[previousIdx] > current) {
                arr[previousIdx + 1] = arr[previousIdx];
                previousIdx--;
            }
            arr[previousIdx + 1] = current;
        }
    }
    /*---- ----*/

    /*---- Descending Order Sorting ----*/
    public void descendingOrder() { // TC -> O(n^2)
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int previousIdx = i - 1;

            while (previousIdx >= 0 && arr[previousIdx] < current) {
                arr[previousIdx + 1] = arr[previousIdx];
                previousIdx--;
            }
            arr[previousIdx + 1] = current;
        }
    }
    /*---- ----*/

}

public class SA03_InsertionSort {
    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

        InsertionSort is = new InsertionSort(data); // use this when u have pre-defined dataset
        System.out.print("Original array > ");
        is.printData();
        is.ascendingOrder();
        System.out.print("Sorted array(ascending) >> ");
        is.printData();
        is.descendingOrder();
        System.out.print("Sorted array(descending) >> ");
        is.printData();
        System.out.println("--------------------------------------");

        System.out.println("--------------------------------------");
        InsertionSort is1 = new InsertionSort(); // use this when u want to give the data at run time
        System.out.print("Original array >> ");
        is1.printData();
        is1.ascendingOrder();
        System.out.print("Sorted array(ascending)>> ");
        is1.printData();
        is1.descendingOrder();
        System.out.print("Sorted array(descending)>> ");
        is1.printData();
        System.out.println("--------------------------------------");

    }
}