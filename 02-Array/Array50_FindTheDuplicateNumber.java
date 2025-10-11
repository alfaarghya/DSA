/*
LC287: Find the Duplicate Number
 || https://leetcode.com/problems/find-the-duplicate-number/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Example 3:

Input: nums = [3,3,3,3,3]
Output: 3

 

Constraints:

    1 <= n <= 105
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.

 */

import java.util.Arrays;

class FindTheDuplicateNumber {

    // TC => O(n*log(n)) || SC => O(1) , where n = size of nums
    public int approach1(int[] nums) {
        // sort the array
        Arrays.sort(nums);

        // find the duplicate
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    // TC => O(n) || SC => O(n) , where n = size of nums
    public int approach2(int[] nums) {
        int n = nums.length - 1; // get the range
        int[] freq = new int[n]; // track the frequency

        // find the duplicate
        for (int val : nums) {
            freq[val - 1]++;

            // check if frequency encounter any value greater than 1
            if (freq[val - 1] >= 2) {
                return val;
            }
        }

        return -1;
    }

    // TC => O(n) || SC => O(1) , where n = size of nums
    public int approach3(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            // if the value nums[index] is already negative
            if (nums[index] < 0) {
                return index; // found the ans
            }

            // make values negative
            nums[index] *= -1;
        }

        return -1;
    }
}

public class Array50_FindTheDuplicateNumber {
    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        int[] arr;

        // example 1
        System.out.println("---- Example 1 ----");
        arr = new int[] { 1, 3, 4, 2, 2 };
        System.out.println(obj.approach1(arr));
        System.out.println(obj.approach2(arr));
        System.out.println(obj.approach3(arr));

        // example 2
        System.out.println("---- Example 2 ----");
        arr = new int[] { 3, 1, 3, 4, 2 };
        System.out.println(obj.approach1(arr));
        System.out.println(obj.approach2(arr));
        System.out.println(obj.approach3(arr));

        // example 3
        System.out.println("---- Example 3 ----");
        arr = new int[] { 3, 3, 3, 3, 3 };
        System.out.println(obj.approach1(arr));
        System.out.println(obj.approach2(arr));
        System.out.println(obj.approach3(arr));

    }
}
