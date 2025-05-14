/*
LC128: Longest Consecutive Sequence || https://leetcode.com/problems/longest-consecutive-sequence
Solved
Medium
Topics
Companies

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:

Input: nums = [1,0,1,2]
Output: 3

 

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9


 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class LongestConsecutiveLength {

  //Time complexity => O(n log(n)) || Space complexity => O(1)
  public int approach1(int[] nums) {
    if(nums.length == 0) {
        return 0;
    }
    if(nums.length == 1) {
        return 1;
    }

    Arrays.sort(nums);

    int length = 1, longestLength = 0;
    int expected = nums[0];

    for(int i = 1; i < nums.length; i++) {
        if(expected+1 == nums[i]) {
            length++;
        } else if(expected != nums[i]) {
            length = 1;
        }

        expected = nums[i];
        longestLength = Math.max(longestLength, length);
    }

    return longestLength;
}

  //Time complexity => O(n) || Space complexity => O(n)
  public int approach2(int[] nums) {
    if(nums.length == 0) {
        return 0;
    }
    if(nums.length == 1) {
        return 1;
    }

    // store all value into set
    Set<Integer> set = new HashSet<>();
    for(int num: nums) {
        set.add(num);
    }

    int length = 0, maxLength = 0;

    for(int val: set) {

        //check for exists previous value
        if(set.contains(val-1)) {
            continue;
        }

        //count length for consecutive element
        length = 1;
        while(set.contains(val+length)) {
            length++;
        }
        
        //calculate max length
        maxLength = Math.max(maxLength, length);
    }

    return maxLength;
}
}

public class Array34_LongestConsecutiveLength{
  public static void main(String[] args) {
    LongestConsecutiveLength obj = new LongestConsecutiveLength();
    int[] nums;

    //example 1
    System.out.println("----- example 1 -----");
    nums = new int[] {3,8,5,10,2,13,11,1,9,6};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    //example 2
    System.out.println("----- example 2 -----");
    nums = new int[] {};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));

    //example 3
    System.out.println("----- example 3 -----");
    nums = new int[] {3};
    System.out.println(obj.approach1(nums));
    System.out.println(obj.approach2(nums));
  }
}