public class SA02_BinarySearch {

    public static void binarySearch(int[] data, int target) { // TC -> O(log(n))
        int startIdx = 0, endIdx = data.length - 1;
        int midIdx = 0;

        while (startIdx <= endIdx) {
            midIdx = startIdx + (endIdx - startIdx) / 2;

            if (data[midIdx] == target) {
                System.out.println(">> " + target + " found at " + midIdx + "th index");
                return;
            } else if (data[midIdx] < target) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }
        System.out.println(">> " + target + " not found!");
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        int[] data = { -11, -5, -2, 0, 1, 1, 10, 15, 55, 65, 65, 69, 90 }; // for binary search always need sorted data

        binarySearch(data, 1);
        System.out.println("--------------------------------------");

    }
}