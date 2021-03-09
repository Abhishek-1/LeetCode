import org.junit.Assert;

/**
 *  Problem - 53
 *
 *  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 */
public class Q53_Max_SubArray {

  /** Using sliding window **/
  public static int maxSubArray_SW(int[] nums) {
    int sum = 0;
    int start = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int i=0; i< nums.length; i++){
      while(sum < 0 && start < i) {
        sum -= nums[start++];
      }
      sum += nums[i];
      maxSum = Math.max(maxSum, sum);
    }

    return maxSum;

  }

  /** Using Recursive **/
  public static int maxSubArray_Recursive(int[] nums) {

    int maxSum = nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];

    for(int i = 1; i< nums.length; i++){
      dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
      maxSum = Math.max(maxSum, dp[i]);
    }

    return maxSum;

  }

  public static void main(String args[]){
    Assert.assertEquals(maxSubArray_SW(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
    Assert.assertEquals(maxSubArray_Recursive(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6);
  }

}
