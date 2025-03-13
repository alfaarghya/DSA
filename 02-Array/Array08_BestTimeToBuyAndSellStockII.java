/*
LC122: Best Time to Buy and Sell Stock II || https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */

class BestTimeToBuyAndSellStockII {
  // Time Complexity: O(n) || Space Complexity: O(1)
  public int approach(int[] prices) {
    int buy = prices[0]; // buy at first day
    int profit = 0; // profit

    // calculate the maximum profit
    for (int i = 1; i < prices.length; i++) {
      if (buy < prices[i]) { // now we can sell stock & earn profit
        profit += prices[i] - buy;
      }

      buy = prices[i];
    }

    return profit;
  }
}

public class Array08_BestTimeToBuyAndSellStockII {
  public static void main(String[] args) {
    BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();

    // example 1
    System.out.println("---- example 1 ----");
    int[] prices1 = { 7, 1, 5, 3, 6, 4 };
    System.out.println(obj.approach(prices1));

    // example 2
    System.out.println("---- example 2 ----");
    int[] prices2 = { 7, 6, 4, 3, 1 };
    System.out.println(obj.approach(prices2));

    // example 3
    System.out.println("---- example 3 ----");
    int[] prices3 = { 8, 9, 10, 5, 1, 4, 6, 7 };
    System.out.println(obj.approach(prices3));

    // example 4
    System.out.println("---- example 4 ----");
    int[] prices4 = { 8, 9, 10, 6, 3, 1, 8, 12, 15 };
    System.out.println(obj.approach(prices4));
  }
}