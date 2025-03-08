public class SA01_LinearSearch {

    public static void linearSearch(int[] data, int target) { // TC => O(n)

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                System.out.println(">> " + target + " found at " + i + "th index");
                return;
            }
        }

        System.out.println(">> " + target + " not found!");
    }

    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        int[] data = { 5, 4, 1, 3, 2, 8, 7, 4, 3 };

        linearSearch(data, 3);
        System.out.println("--------------------------------------");

    }
}