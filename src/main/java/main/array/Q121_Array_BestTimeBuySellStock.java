package main.array;

import org.junit.Assert;

/**
 *  Problem - 121
 *  You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class Q121_Array_BestTimeBuySellStock {

  public static int maxProfit(int[] prices) {

    int max = 0;
    int cur = prices[0];
    for(int i=1; i< prices.length; i++){
      if(prices[i] < cur)  cur = prices[i];
      else max= Math.max(prices[i]-cur, max);
    }
    return max;
  }

  public static void main(String[] args){
    Assert.assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));
  }

}
