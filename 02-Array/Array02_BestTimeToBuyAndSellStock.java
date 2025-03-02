/*
LC121: Best Time to Buy and Sell Stock || https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */

class BestTimeToBuyAndSellStock {
  public int approach1(int[] prices) {
    int buy = prices[0]; // buy at first day
    int profit = 0; // profit on a day
    int maxProfit = 0; // maximum profit we can make

    // calculate the maximum profit
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < buy) { // for now we can't sell stock, but can buy stock
        buy = prices[i];
      } else { // now we can sell stock & earn profit
        profit = prices[i] - buy;
        maxProfit = Math.max(profit, maxProfit); // find max profit
      }
    }

    return maxProfit;
  }
}

public class Array02_BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();

    // example 1
    int[] prices1 = { 7, 1, 5, 3, 6, 4 };
    System.out.println(obj.approach1(prices1));

    // example 2
    int[] prices2 = { 7, 6, 4, 3, 1 };
    System.out.println(obj.approach1(prices2));
  }
}