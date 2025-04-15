/*
LC167: Two Sum II - Input Array Is Sorted || https://leetcode.com/problems/two-sum-ii-input-array-is-sorted


Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

 

Constraints:
    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
 */

class TwoSumII {
  // all Two Sum I approaches work

  //Approach - two pointers on sorted array
  //Time complexity => O(n) || Space complexity => O(1)
    public int[] twoSum(int[] numbers, int target) {
        //two pointers
        int start = 0, end = numbers.length-1;
        int total;

        while(start <= end) {
            //calculate total
            total = numbers[start] + numbers[end];

            //check in sorted array
            if(total == target) {
                return new int[] {start+1, end+1};
            } else if (total > target) {
                end--;
            } else if(total < target) {
                start++;
            }
        }

        //nothing found
        return new int[] {};
    }

    public void print(int[] arr) {
    System.out.print("[");
    for (int x : arr) {
      System.out.print(" " + x + " ");
    }
    System.out.print("]\n");
  }
}

public class Array25_TwoSumII {
  public static void main(String[] args) {
    TwoSumII obj = new TwoSumII();
    
    //example 1
    System.out.println("---- example 1 ----");
    int[] numbers1 = {2,7,11,15};
    int target1 = 9;
    obj.print(obj.twoSum(numbers1, target1));

    //example 2
    System.out.println("---- example 2 ----");
    int[] numbers2 = {2,3,4};
    int target2 = 6;
    obj.print(obj.twoSum(numbers2, target2));

    //example 3
    System.out.println("---- example 3 ----");
    int[] numbers3 = {-1,0};
    int target3 = -1;
    obj.print(obj.twoSum(numbers3, target3));

    //example 4
    System.out.println("---- example 4 ----");
    int[] numbers4 = {-2,-1,5,6,9,11,13,14};
    int target4 = 14;
    obj.print(obj.twoSum(numbers4, target4));
  }
}