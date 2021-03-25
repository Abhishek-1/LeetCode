package main.array;

import org.junit.Assert;

/**
 *  Problem - 238
 *
 *  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */

public class Q238_Array_Product_ExceptShelf {

  /** Using array **/
  public static int[] productExceptSelf(int[] nums) {

    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    int[] ans = new int[nums.length];

    left[0] = 1;
    for(int i=1; i<nums.length; i++){
      left[i] = left[i-1]*nums[i-1];
    }

    right[nums.length-1] = 1;
    for(int i=nums.length-2; i>= 0; i--){
      right[i] = nums[i+1]*right[i+1];
    }

    for(int i=0; i<nums.length; i++){
      ans[i] = left[i]*right[i];
    }

    return ans;
  }

  /** Using Integer **/
  public static int[] productExceptSelf_Integer(int[] nums) {

    int fwd = 1;
    int bwd = 1;
    int[] ans = new int[nums.length];

    ans[0] = 1;
    for(int i=1; i<nums.length; i++){
      fwd = fwd*nums[i-1];
      ans[i] = fwd;
    }

    for(int i=nums.length-2; i>= 0; i--){
      bwd = nums[i+1]*bwd;
      ans[i] = ans[i]*bwd;
    }

    return ans;
  }


  public static void main(String[] args){
    Assert.assertArrayEquals(productExceptSelf(new int[]{1,2,3,4}), new int[]{24,12,8,6});
    Assert.assertArrayEquals(productExceptSelf_Integer(new int[]{1,2,3,4}), new int[]{24,12,8,6});
  }
}
