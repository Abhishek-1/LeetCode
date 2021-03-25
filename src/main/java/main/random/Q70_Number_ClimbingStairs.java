package main.random;

import org.junit.Assert;

/**
 *  Problem - 70
 *
 *  You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 */

public class Q70_Number_ClimbingStairs {

  public static int climbStairs(int n) {

    if(n < 2) return n;
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 2;
    for(int i=2; i<n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n-1];

  }

  public static void main(String[] args){
    Assert.assertEquals(climbStairs(3), 3);
  }


}
