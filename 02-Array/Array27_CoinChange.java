/*
LC322: Coin Change || https://leetcode.com/problems/coin-change/


You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0

 

Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104

 */

import java.util.Arrays;

class CoinChange {

  // time complexity: O(c*a) || Space complexity: O(a)
  public int coinChange(int[] coins, int amount) {
    // store minimum coins for each amount
    int[] dp = new int[amount + 1];
    // fill db with values
    Arrays.fill(dp, amount + 1);

    // no minimum coin at oth index
    dp[0] = 0;

    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        // find the minimum coins required
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    //return minimum coin count or -1
    return dp[amount] > amount ? -1 : dp[amount];
  }
}

public class Array27_CoinChange {
  public static void main(String[] args) {
    CoinChange obj = new CoinChange();
    int[] coins;
    int amount;

    //example 1
    System.out.println("---- example 1 ----");
    coins = new int[] {5,1,2};
    amount = 14;
    System.out.println(obj.coinChange(coins, amount));

    //example 2
    System.out.println("---- example 2 ----");
    coins = new int[] {2};
    amount = 3;
    System.out.println(obj.coinChange(coins, amount));

    //example 3
    System.out.println("---- example 3 ----");
    coins = new int[] {186,419,83,408};
    amount = 6249;
    System.out.println(obj.coinChange(coins, amount));

    //example 4
    System.out.println("---- example 4 ----");
    coins = new int[] {1};
    amount = 0;
    System.out.println(obj.coinChange(coins, amount));
  }
}
