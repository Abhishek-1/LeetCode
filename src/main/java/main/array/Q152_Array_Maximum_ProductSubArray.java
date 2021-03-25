package main.array;

import org.junit.Assert;

/**
 *  Problem - 152
 *  Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *  It is guaranteed that the answer will fit in a 32-bit integer.
 *  A subarray is a contiguous subsequence of the array.
 *
 *  Input: nums = [2,3,-2,4]
 *  Output: 6
 *  Explanation: [2,3] has the largest product 6.
 */

public class Q152_Array_Maximum_ProductSubArray {

  public static int maxProduct(int[] nums) {

    if(nums.length == 0) return 0;
    int max = nums[0];
    int min = nums[0];
    int product = nums[0];
    for(int i=1; i<nums.length; i++){
      int temp = max;
      max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
      min = Math.min(nums[i], Math.min(min*nums[i], temp*nums[i]));
      product = Math.max(max, product);
    }

    return product;
  }

  public static void main(String[] args){
    Assert.assertEquals(6, maxProduct(new int[]{2,3,-2,4}));
  }

}
