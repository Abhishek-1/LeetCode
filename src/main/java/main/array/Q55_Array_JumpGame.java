package main.array;

import org.junit.Assert;

/** Problem 55
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

public class Q55_Array_JumpGame {

  /** Using DP **/
  public static boolean canJump(int[] nums) {

    if(nums.length < 2) return true;
    int n =nums.length;
    boolean[] dp = new boolean[n];
    dp[n-1] = true;

    for(int i= n-2; i >= 0; i--){
      for(int j=0; j<= nums[i]; j++){
        if(i+j < n && dp[i+j] == true){
          dp[i] =true;
          break;
        }
      }
    }

    return dp[0];
  }

  /** Using iteration **/
  public static boolean canJump_iter(int[] nums) {

    int max = 0;
    for(int i =0; i< nums.length; i++){
      if(i > max) return false;
      max = Math.max(nums[i]+i, max);
    }
    return true;
  }

  public static void main(String[] args){

    Assert.assertEquals(canJump(new int[]{2,3,1,1,4}), true);
    Assert.assertEquals(canJump_iter(new int[]{2,3,1,0,4}), true);

  }

}
