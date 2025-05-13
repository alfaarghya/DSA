/*
LC55: Jump Game || https://leetcode.com/problems/jump-game/

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 

Constraints:

    1 <= nums.length <= 10^4
    0 <= nums[i] <= 10^5


 */

class JumpGame {
  //Time Complexity => O(n) || Space Complexity => O(1)
  public boolean canJump(int[] nums) {
    int reach = 0;
    for(int i = 0; i < nums.length; i++ ){
        
        //when current position is bigger than max jump
        if(i > reach) {
            return false;
        }

        reach = Math.max(reach, nums[i]+i);
    }

    return true;
}
}

public class Array33_JumpGame {
  public static void main(String[] args) {
    JumpGame obj = new JumpGame();
    int[] nums;

    //example 1
    System.out.println("----- example 1 -----");
    nums = new int[] {3,2,1,0,4};
    System.out.println(obj.canJump(nums));

    //example 2
    System.out.println("----- example 2 -----");
    nums = new int[] {2,3,1,1,4};
    System.out.println(obj.canJump(nums));
  }
}
