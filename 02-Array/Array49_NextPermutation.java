/*
LC31: Next Permutation || https://leetcode.com/problems/next-permutation/

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100

 */

import java.util.Arrays;

class NextPermutation {
    // TC => O(n) || SC => O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // corner case 1 -> one element
        if (n == 1) {
            return;
        }

        // Find out the position where i is smaller than i+1
        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // no break point -> array is in decreasing order
        if (breakPoint == -1) {
            reverseArray(nums, 0, n - 1); // convert it in increasing order
            return;
        }

        // find next greater number in right half
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, i, breakPoint);
                break;
            }
        }

        // reverse the right half
        reverseArray(nums, breakPoint + 1, n - 1);
    }

    private void reverseArray(int[] nums, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            swap(nums, startIdx, endIdx);

            startIdx++;
            endIdx--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class Array49_NextPermutation {
    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] arr;

        // example 1
        System.out.println("---- Example 1 ----");
        arr = new int[] { 1, 1, 3, 5, 2 };
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        // example 2
        System.out.println("---- Example 2 ----");
        arr = new int[] { 6, 4, 3, 1 };
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        // example 3
        System.out.println("---- Example 3 ----");
        arr = new int[] { 2, 3, 7, 6, 5, 3 };
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
