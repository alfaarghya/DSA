import java.util.Scanner;

class SelectionSort {
    int[] arr; // store the data
    int n; // size of the array

    /*----- constructor ----- */
    SelectionSort(int[] data) { // passing the data at the time of creating a object
        this.arr = data;
        this.n = data.length;
    }

    SelectionSort() { // when...we don't have the data to pass...we want to pass the data at run time
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

    /*---- Ascending Order Sorting(only this part is required to understand Selection Sort) ----*/
    public void ascendingOrder() { // TC -> O(n^2)
        for (int i = 0; i < n - 1; i++) {
            int minPosition = i; // store current i-th element index
            for (int j = i + 1; j < n; j++) {
                if (arr[minPosition] > arr[j]) {
                    minPosition = j;
                }
            }

            /* swapping */
            int temp = arr[minPosition];
            arr[minPosition] = arr[i];
            arr[i] = temp;
        }
    }
    /*---- ----*/

    /*---- Descending Order Sorting ----*/
    public void descendingOrder() { // TC -> O(n^2)
        for (int i = 0; i < n - 1; i++) {
            int minPosition = i; // store current i-th element index
            for (int j = i + 1; j < n; j++) {
                if (arr[minPosition] < arr[j]) {
                    minPosition = j;
                }
            }

            /* swapping */
            int temp = arr[minPosition];
            arr[minPosition] = arr[i];
            arr[i] = temp;
        }
    }
    /*---- ----*/

}

public class SA02_SelectionSort {
    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

        SelectionSort ss = new SelectionSort(data); // use this when u have pre-defined dataset
        System.out.print("Original array > ");
        ss.printData();
        ss.ascendingOrder();
        System.out.print("Sorted array(ascending) >> ");
        ss.printData();
        ss.descendingOrder();
        System.out.print("Sorted array(descending) >> ");
        ss.printData();
        System.out.println("--------------------------------------");

        System.out.println("--------------------------------------");
        SelectionSort ss1 = new SelectionSort(); // use this when u want to give the data at run time
        System.out.print("Original array >> ");
        ss1.printData();
        ss1.ascendingOrder();
        System.out.print("Sorted array(ascending)>> ");
        ss1.printData();
        ss1.descendingOrder();
        System.out.print("Sorted array(descending)>> ");
        ss1.printData();
        System.out.println("--------------------------------------");
    }
}