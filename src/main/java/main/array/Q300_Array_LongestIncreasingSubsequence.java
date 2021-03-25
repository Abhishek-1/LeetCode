package main.array;

/**
 *  Problem - 300
 *  Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *  A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the
 *  remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *  Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 */

public class Q300_Array_LongestIncreasingSubsequence {

  /** Using Dynamic Programming **/
  public int lengthOfLIS(int[] nums) {
    if(nums.length < 2) return nums.length;
    int[] dp = new int[nums.length];
    int max = 0;
    dp[0] = 1;
    for(int i=1; i<nums.length; i++){
      dp[i] = 1;
      for(int j=0; j < i; j++){
        if(nums[j] < nums[i]){
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
    }

    for(int i=0; i< nums.length; i++){
      max = Math.max(dp[i], max);
    }

    return max;
  }

  /** Using recursive **/
  public int lengthOfLIS_recursive(int[] nums) {

    if(nums.length == 0 || nums.length == 1) return nums.length;
    int max = 0;

    for(int i=0; i < nums.length; i++){
      max = Math.max(recursiveLIS(nums, i+1, nums[i]), max);
    }

    return max+1;

  }

  public int recursiveLIS(int[] nums, int pos, int cond){
    if(pos == nums.length){
      return 0;
    }

    int t1 = 0;
    int t2 = 0;
    if(nums[pos] > cond)
      t1 = 1+ recursiveLIS(nums, pos+1, nums[pos]);

    t2 = recursiveLIS(nums, pos+1, cond);

    return Math.max(t1, t2);
  }


}
